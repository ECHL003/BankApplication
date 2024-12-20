package bankapplication;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class BankOperations {
    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter unique account number: ");
        String accountNumber = scanner.nextLine();
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account number already exists. Try a different number.");
            return;
        }
        accounts.put(accountNumber, new BankAccount(accountNumber, name));
        System.out.println("Account created successfully!");
    }

    public void depositFunds() {
        BankAccount account = getAccountByNumber();
        if (account == null) return;

        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    public void withdrawFunds() {
        BankAccount account = getAccountByNumber();
        if (account == null) return;

        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    public void transferFunds() {
        System.out.print("Enter your account number: ");
        String sourceAccountNumber = scanner.nextLine();
        BankAccount sourceAccount = accounts.get(sourceAccountNumber);
        if (sourceAccount == null) {
            System.out.println("Source account not found.");
            return;
        }

        System.out.print("Enter target account number: ");
        String targetAccountNumber = scanner.nextLine();
        BankAccount targetAccount = accounts.get(targetAccountNumber);
        if (targetAccount == null) {
            System.out.println("Target account not found.");
            return;
        }

        System.out.print("Enter transfer amount: ");
        double amount = scanner.nextDouble();
        sourceAccount.transfer(targetAccount, amount);
    }

    public void viewAccountDetails() {
        BankAccount account = getAccountByNumber();
        if (account == null) return;

        account.displayAccountDetails();
    }

    public void viewTransactionHistory() {
        BankAccount account = getAccountByNumber();
        if (account == null) return;

        account.printTransactionHistory();
    }

    private BankAccount getAccountByNumber() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return null;
        }
        return account;
    }
}
