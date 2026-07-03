package accounts;

public class SavingsAccount extends Account {

    private double rate;

    public SavingsAccount(String accountNo, double opening, double rate) {
        super(accountNo, opening);
        this.rate = rate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance - amount < 0) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void addInterest() {
        balance += balance * (rate / 100.0);
    }
}