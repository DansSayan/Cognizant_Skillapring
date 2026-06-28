-- scenario 1
create or replace procedure SafeTransferFunds (
    p_sourceacc in number,
    p_destacc in number,
    p_amt in number
) IS v_currbal number;
     e_notfunds exception;
BEGIN
    select Balance into v_currbal from Accounts
    where AccountID = p_sourceacc;
    if v_currbal < p_amt THEN raise e_notfunds;
    end if;
    update Accounts
    set Balance = Balance - p_amt
    where AccountID = p_sourceacc;
    update Accounts
    set Balance = Balance + p_amt
    where AccountID = p_destacc;
    commit;
    dbms_output.put_line('Transfer successful!');
EXCEPTION
    when e_notfunds then rollback;
    dbms_output.put_line('Insufficient funds in the source account');
    when others then rollback;
    dbms_output.put_line('Transfer failed due to system error');
end;

-- scenario 2
create or replace procedure UpdateSalary (
    p_empID in Number,
    p_percent in NUMBER
) is v_dummy number;
BEGIN
    select EmployeeID into v_dummy
    from Employees where EmployeeID = p_empID;
    update EMPLOYEES
    set Salary = Salary + (Salary*(p_percent/100))
    where EmployeeID = p_empID;
    commit;
    dbms_output.put_line('Salary updated successfully');
exception
    when no_data_found THEN
    dbms_output.put_line('Employee ID '||p_empID||
                         ' does not exist');
    when others THEN
    dbms_output.put_line('Could not update salary');
end;

-- scenario 3
create or replace procedure AddNewCustomer (
    p_customerID in number,
    p_name in varchar2,
    p_dob in date,
    p_balance in number
) is 
begin
    insert into Customers (CustomerID, Name, DOB, Balance, LastModified)
    values (p_customerID, p_name, p_dob, p_balance, sysdate);
    commit;
    dbms_output.put_line('Customer added successfully');
EXCEPTION
    when dup_val_on_index THEN
    dbms_output.put_line('Customer with ID '||p_CustomerID||
                         ' already exists');
    when others THEN
    dbms_output.put_line('System Error!');
end;
