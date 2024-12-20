package bankapplication;
import java.util.ArrayList;
import java.util.List;
public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: $0.0");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
        System.out.println("Deposited $" + amount + " successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
        transactionHistory.add("Withdrew: $" + amount);
        System.out.println("Withdrew $" + amount + " successfully.");
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance to transfer.");
            return;
        }
        this.withdraw(amount);
        targetAccount.deposit(amount);
        transactionHistory.add("Transferred $" + amount + " to " + targetAccount.getAccountNumber());
        System.out.println("Transferred $" + amount + " to account " + targetAccount.getAccountNumber() + " successfully.");
    }

    public void printTransactionHistory() {
        System.out.println("\nTransaction History for Account: " + accountNumber);
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }

    public void displayAccountDetails() {
        System.out.println("\nAccount Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: $" + balance);
    }
}
