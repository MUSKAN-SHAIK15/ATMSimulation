import java.util.Scanner;

public class ATMSimulation {
    private double balance;
    private final Scanner scanner;

    public ATMSimulation() {
        this.balance = 1000.00; // Initial balance
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ATMSimulation atm = new ATMSimulation();
        atm.run();
    }

    public void run() {
        int choice;

        do {
            displayMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println(); // Print a newline for better readability
        } while (choice != 4);
    }

    private void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Please select an option: ");
    }

    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextInt();
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    private void depositMoney() {
        System.out.print("Enter the amount to deposit: $");
        double amount = getValidAmount();
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited: $%.2f%n", amount);
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = getValidAmount();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew: $%.2f%n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Please try again.");
        } else {
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
    }

    private double getValidAmount() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid amount: ");
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextDouble();
    }
}

