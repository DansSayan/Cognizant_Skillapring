-- scenario 1
create or replace package CustomerManagement IS
    procedure AddCustomer(
        new_CustomerID in number,
        new_name in varchar2,
        new_dob in date,
        new_balance in number
    );
    function getBalance(cus_ID in number) return number;
end CustomerManagement;
create or replace package body CustomerManagement IS
    procedure AddCustomer(
        new_CustomerID in number,
        new_name in varchar2,
        new_dob in date,
        new_balance in number
    ) IS
    begin
        insert into Customers(
            CustomerID, 
            Name, 
            DOB, 
            Balace, 
            LastModified
        )
        values (
            new_CustomerID, 
            new_name, 
            new_dob, 
            new_balance, 
            sysdate
        );
        commit;
    end AddCustomer;
    function getBalance(new_CustomerID in number)
        return number is acc_bal number;
    BEGIN
        select Balance into acc_bal
        from Customers where CustomrID = newCustomerID;
        return acc_bal;
    end getBalance;
end CustomerManagement;

-- scenarion 2
create or replace package EmployeeManagement is
    procedure NewEmployee(
        emp_ID in number,
        emp_name in varchar2,
        emp_pos in varchar2,
        emp_sal in number,
        emp_dept in varchar2
    );
    function EmpSalary(emp_ID in number) return number;
end EmployeeManagement;
create or replace package body EmployeeManagement IS
    procedure NewEmployee(
        emp_ID in number,
        emp_name in varchar2,
        emp_pos in varchar2,
        emp_sal in number,
        emp_dept in varchar2
    ) is
    begin 
        insert into Employees(
            EmployeeID, 
            Name, 
            Position, 
            Salary, 
            Department, 
            HireDate
        )
        values (
            emp_ID, 
            emp_name, 
            emp_pos, 
            emp_sal, 
            emp_dept, 
            sysdate
        );
        commit;
    end NewEmployee;
    function EmpSalary(emp_ID in number)
    return number is month_sal number;
    begin 
        select Salary into month_sal
        from Employees where EmployeeID = emp_ID;
        return month_sal*12;
    end EmpSalary;
end EmployeeManagement;

-- scenario 3
create or replace package AccountOperations is
    procedure OpenAccount(
        acc_ID in number,
        cus_id in number,
        acc_type in varchar2,
        acc_bal in number
    );
    procedure CloseAccount(acc_ID in number);
end AccountOperations;
create or replace package body AccountOperations IS
    procedure OpenAccount(
        acc_ID in number,
        cus_id in number,
        acc_type in varchar2,
        acc_bal in number
    );
    begin 
        insert into Accounts(
            AccountID,
            CustomerID,
            AccountType, 
            Balance,
            LastModified
        )
        values (
            acc_ID, 
            cus_ID, 
            acc_type, 
            acc_bal, 
            sysdate
        );
        commit;
    end OpenAccount;
    prodecure CloseAccount(acc_ID in number) IS
    begin 
        delete from Accounts where AccountID = acc_ID;
        commit;
    end CloseAccount;
end AccountOperations;