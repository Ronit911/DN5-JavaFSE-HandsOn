-- Exercise 1: Control Structures

-- Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
-- Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.
DECLARE
    CURSOR c_customers IS
        SELECT customer_id, age FROM customers;
BEGIN
    FOR cust IN c_customers LOOP
        IF cust.age > 60 THEN
            UPDATE loans
            SET interest_rate = interest_rate - 1
            WHERE customer_id = cust.customer_id;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: A customer can be promoted to VIP status based on their balance.
-- Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.
DECLARE
    CURSOR c_customers IS
        SELECT customer_id, balance FROM customers;
BEGIN
    FOR cust IN c_customers LOOP
        IF cust.balance > 10000 THEN
            UPDATE customers
            SET IsVIP = 'TRUE'
            WHERE customer_id = cust.customer_id;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
-- Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.
DECLARE
    CURSOR c_loans IS
        SELECT l.loan_id, l.customer_id, c.customer_name, l.due_date
        FROM loans l
        JOIN customers c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR loan IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || loan.customer_name || 
                             ' (ID: ' || loan.customer_id || 
                             '), your loan ' || loan.loan_id || 
                             ' is due on ' || TO_CHAR(loan.due_date, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/
