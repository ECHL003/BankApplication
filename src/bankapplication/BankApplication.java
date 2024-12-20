package bankapplication;
import java.util.Scanner;
public class BankApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static BankOperations operations = new BankOperations();
    public static void main(String[] args) {
       while (true) {
            System.out.println("\n--- Bank Application ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Account Details");
            System.out.println("6. View Transaction History");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    operations.createAccount();
                    break;
                case 2:
                    operations.depositFunds();
                    break;
                case 3:
                    operations.withdrawFunds();
                    break;
                case 4:
                    operations.transferFunds();
                    break;
                case 5:
                    operations.viewAccountDetails();
                    break;
                case 6:
                    operations.viewTransactionHistory();
                    break;
                case 7:
                    System.out.println("Exiting application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
