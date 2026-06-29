-- scenario 1
create or replace trigger UpdateCustomerLastModified
before update on Cusrtomers
for each ROW
BEGIN
    :new.LastModified := sysdate;
end;

--scenario 2
create table AuditLog (
    LogID number generated always as identity primary key,
    TransactionID number,
    ActionDate Date,
    Amount number,
    TransactionType varchar2(10)
);

create or replace trigger LogTransaction
after insert on Transactions
for each row 
begin
    insert into AuditLog(TransactionID, ActionDate, Amount, TransactionType)
    values(:new.TransactionID, sysdate, :new.Amount, :new.TransactionType);
end;
 
-- scenario 3
create or replace trigger CheckTransactionRules
before insert on Transactions
for each row
declare curr_bal number;
begin
    if :new.TransactionType = 'Deposit' and :new.Amount <= 0 then
        raise_application_error('Transaction Failed. Deposit Amount must be positive');
    end if;
    if :new.TransactionType = 'Withdrawl' then
        select Balance into curr_bal
        from Accounts where AccountID = :new.AccountID;
        if :new.amount > curr_bal then
            raise_application_error('Transaction Failed. Insufficient funds');
        end if;
    end if;
end;