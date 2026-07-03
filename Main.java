package accounts;

public class Main {

    public static void main(String[] args) {

        SavingsAccount sav = new SavingsAccount("SAV-001", 100000, 5);
        CurrentAccount cur = new CurrentAccount("CUR-001", 50000, 20000);

        Customer john = new Customer("John Mukasa");
        john.addAccount(sav);
        john.addAccount(cur);

        System.out.println("=== Initial statements ===");
        System.out.println(sav.generateStatement());
        System.out.println(cur.generateStatement());

        System.out.println("\n=== Savings account behaviour ===");
        System.out.println("Withdraw 30,000 from savings -> " + sav.withdraw(30000));
        System.out.println("Withdraw 200,000 from savings (should fail) -> " + sav.withdraw(200000));
        sav.addInterest();
        System.out.println("After 5% interest: " + sav.generateStatement());

        System.out.println("\n=== Current account behaviour ===");
        System.out.println("Withdraw 60,000 from current (uses overdraft) -> " + cur.withdraw(60000));
        System.out.println(cur.generateStatement());
        System.out.println("Withdraw 20,000 more (should fail, exceeds overdraft) -> " + cur.withdraw(20000));

        System.out.println("\n=== Customer total worth ===");
        System.out.printf("%s's total worth: UGX %.2f%n", john.getName(), john.totalWorth());
    }
}