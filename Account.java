package accounts;

public abstract class Account implements Statement {

    protected String accountNo;
    protected double balance;

    public Account(String accountNo, double opening) {
        this.accountNo = accountNo;
        this.balance = opening;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public abstract boolean withdraw(double amount);

    public double getBalance() {
        return balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    @Override
    public String generateStatement() {
        return String.format("Account No: %s | Balance: UGX %.2f", accountNo, balance);
    }
}