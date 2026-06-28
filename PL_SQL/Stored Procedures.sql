--scenario 1
create or replace procedure ProcessMonthlyInterest is
begin
    update Accounts
    set Balance = Balance+(Balance*0.01), LastModified = sysdate
    where AccountType = 'Savings';
    commit;
end;

-- scenario 2
create or replace procedure UpdateEmployeeBonus (
    emp_dept in varchar2,
    emp_bonus in number
) is
BEGIN
    update Employees
    set Salary = Salary+(Salary*(emp_bonus/100))
    where Department = emp_dept;
    commit;
end;

--scenario 3
create or replace procedure TransferFunds (
    from_acc in number,
    to_acc in number,
    transfer_amt in number
) is source_bal number;
begin
    select Balance into source_bal
    from Accounts
    where AccountID = from_acc;
    if source_bal >= transfer_amt then
        update Accounts
        set Balance = Balance - transfer_amt
        where AccountID = from_acc;
        update Accounts
        set Balance = Balance + transfer_amt
        where AccountID = to_acc;
        commit;
    else
        dbms_output.put_line('Insufficient balance in account '|| from_acc);
    end if;
end;