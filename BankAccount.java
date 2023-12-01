import java.util.Scanner;

// BankAccount class to represent the user's account
class BankAccount {
    /**
     *
     */
    private String accountHolderName;
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    private double balance;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// ATM interface to perform operations on the BankAccount
interface ATM {
    void displayMenu();

    void performTransaction(int choice);
}

// ATMImplementation class implementing the ATM interface
class ATMImplementation implements ATM {
    private BankAccount bankAccount;

    public ATMImplementation(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Display Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    @Override
    public void performTransaction(int choice) {
        try (Scanner scanner = new Scanner(System.in)) {
            switch (choice) {
                case 1:
                    System.out.println("Balance: $" + bankAccount.getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: $" + bankAccount.getBalance());
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    boolean success = bankAccount.withdraw(withdrawalAmount);
                    if (success) {
                        System.out.println("Withdrawal successful. New balance: $" + bankAccount.getBalance());
                    } else {
                        System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting. Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

