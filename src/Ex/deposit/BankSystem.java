package Ex.deposit;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }

    public void checkBalance() {
        System.out.println("Account " + accountNumber + " has $" + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("123456789", 1000.00);

        myAccount.deposit(500.00);
        myAccount.withdraw(200.00);
        myAccount.checkBalance();

        // 잘못된 사용 예
        myAccount.withdraw(2000.00);
        myAccount.deposit(-100.00);
    }
}