-- Exercise 3: Stored Procedures

-- Scenario 1: The bank needs to process monthly interest for all savings accounts.
-- Write a stored procedure ProcessMonthlyInterest that calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE savings_accounts
    SET balance = balance + (balance * 0.01);
    
    COMMIT;
END ProcessMonthlyInterest;
/

-- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
-- Write a stored procedure UpdateEmployeeBonus that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department_id IN NUMBER,
    p_bonus_percentage IN NUMBER
)
IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * (p_bonus_percentage / 100))
    WHERE department_id = p_department_id;
    
    COMMIT;
END UpdateEmployeeBonus;
/

-- Scenario 3: Customers should be able to transfer funds between their accounts.
-- Write a stored procedure TransferFunds that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_source_account_id IN NUMBER,
    p_target_account_id IN NUMBER,
    p_amount IN NUMBER
)
IS
    v_source_balance NUMBER;
BEGIN
    -- Check balance of the source account
    SELECT balance INTO v_source_balance
    FROM accounts
    WHERE account_id = p_source_account_id
    FOR UPDATE; -- Lock the row for update

    IF v_source_balance >= p_amount THEN
        -- Deduct from source
        UPDATE accounts
        SET balance = balance - p_amount
        WHERE account_id = p_source_account_id;

        -- Add to target
        UPDATE accounts
        SET balance = balance + p_amount
        WHERE account_id = p_target_account_id;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer successful.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in the source account.');
        ROLLBACK;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Account not found.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
        ROLLBACK;
END TransferFunds;
/
