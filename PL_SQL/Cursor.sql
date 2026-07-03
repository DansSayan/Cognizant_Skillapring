--scenario 1
declare
    cursor GenerateMonthlyStatements is
        select TransactionID, AccountID, Amount, TransactionType, TransactionDate
        from Transactions
        where extract(month from TransactionDate)=extract(month from sysdate)
              and extract (year from TransactionDate)=extract(year from sysdate);
    trans GenerateMonthlyStatements%rowtype;
begin
    open GenerateMonthlyStatements;
    loop
        fetch GenerateMonthlyStatements into trans;
        exit when GenerateMonthlyStatements%notfound;
        dbms_output.put_line('Account: '||trans.AccountID||
                             ' | ID: '||trans.TransactionID||
                             ' | Amount: $'||trans.Amount||
                             ' | Date: '||to_char(trans.TransactionDate, 'YYYY-MM-DD'));
    end loop;
    close GenerateMonthlyStatements;
end;

-- scenario 2
declare 
    cursor ApplyAnnualFee is
        select AccountID, Balance from Accounts;
    AnnualFee constant number := 20;
begin
    for acc in ApplyAnnualFee loop
        update Accounts
        set Balance = Balance - AnnualFee,
            LastModified = sysdate
        where AcccountID = acc.AccountID;
    end loop;
    commit;
end;

-- Scenario 3
declare
    cursor UpdateLoanInterestRates is
        Select LoanID, InterestRate from Loans;
BEGIN
    for r_loan in UpdateLoanInterestRates loop
        update Loans
        set InterestRate = InterestRate + 0.5
        where LoanID = r_loan.LoanID;
    end loop;
    commit;
end;