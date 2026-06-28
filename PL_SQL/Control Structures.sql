-- Scenario 1
begin
    for cus in (select CustomerID, DOB from Customers) loop
        if months_between (sysdate, cus.DOB)/12 > 60 then
            update Loans
            set InterestRate = InterestRate - 1
            where CustomerID = cus.CustomerID;
        end if;
    end loop;
    commit;
end;

-- Scenario 2
alter table Customers
add IsVIP boolean default FALSE;
begin
    for cus in (select CustomerID from Customers 
                where Balance > 10000) loop
        update Customers
        set IsVIP = TRUE
        where CustomerID = cus.CustomerID;
    end loop;
    commit;
end;

-- Scenario 3
begin
    for loan in (select LoanID, CustomerID, EndDate
                 from Loans
                 where EndDate between sysdate and sysdate + 30) loop
        dbms_output.put_line('Customer ID '||loan.CustomerID||
                             ' has Loan ID '||loan.LoanID||
                             ' due on '||to_char(loan.EndDate, 'YYYY-MM-DD'));
    end loop;
end;