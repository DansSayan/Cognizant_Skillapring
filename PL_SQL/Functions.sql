-- scenario 1
create or replace function CalculateAge(
    cust_dob in date
) return number is cust_age number;
BEGIN
    cust_age := floor(months_between(sysdate, cust_dob)/12);
    return cust_age;
end;

-- scenario 2
create or replace function CalculateMonthlyInstallment(
    loan_amt in number,
    interest_rt in number,
    loan_duration in number
) return number is
    m_rate number;
    tot_months number;
    m_installment number;
begin
    m_rate := (interest_rt/100) / 12;
    tot_months := loan_duration * 12;
    if m_rate = 0 then 
        m_installment := loan_amt / tot_months;
    else
        m_installment := loan_amt * m_rate * power(1+m_rate, tot_months) / (power(1+m_rate, tot_months)-1);
    end if;
    return round(m_installment, 2);
end;

--scenario 3
create or replace function HasSufficientBalance (
    acc_id in number,
    acc_amt in number
) return boolean is curr_bal number;
BEGIN
    select Balance into curr_bal
    from Accounts where AccountID = acc_id;
    if curr_bal >= acc_amt then 
        return true;
    else
        return false;
    end if;
end;