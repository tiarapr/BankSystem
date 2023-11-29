package banksystem;

/**
 *
 * @author Tiara
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User {
    private List<Account> accounts; // Daftar akun yang dimiliki oleh nasabah

    public Customer(String name, String id, String password) {
        super(name, id, password);
        this.accounts = new ArrayList<>();
    }

    // Metode untuk menambahkan akun ke nasabah
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Metode untuk mendapatkan daftar akun
    public List<Account> getAccounts() {
        return accounts;
    }
    
    //Menu Utama Customer
    public void customerMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    viewTransaction();
                    break;
                case 6:
                    return; // Kembali ke menu utama
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    private void viewBalance() {
    System.out.println("\nYour Account Balances:");
    for (Account account : accounts) {
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("------------------------");
    }
}

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Account Number for Deposit: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter Deposit Amount: ");
            double amount = scanner.nextDouble();
            if (amount > 0) {
                account.deposit(amount);
                System.out.println("Deposit successful. New balance: " + account.getBalance());
            } else {
                System.out.println("Invalid deposit amount.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Account Number for Withdrawal: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter Withdrawal Amount: ");
            double amount = scanner.nextDouble();
            if (amount > 0 && account.getBalance() >= amount) {
                account.withdraw(amount);
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
            } else {
                System.out.println("Invalid withdrawal amount or insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private void transfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Source Account Number: ");
        String sourceAccountNumber = scanner.nextLine();
        System.out.print("Enter Destination Account Number: ");
        String destinationAccountNumber = scanner.nextLine();

        Account sourceAccount = findAccount(sourceAccountNumber);
        Account destinationAccount = findAccount(destinationAccountNumber);

        if (sourceAccount != null && destinationAccount != null) {
            System.out.print("Enter Transfer Amount: ");
            double amount = scanner.nextDouble();
            if (amount > 0 && sourceAccount.getBalance() >= amount) {
                sourceAccount.withdraw(amount);
                destinationAccount.deposit(amount);
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Invalid transfer amount or insufficient balance.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public void viewTransaction() {
        System.out.println("\nTransaction History for " + getName());

        for (Account account : accounts) {
            List<Transaction> transactions = account.getTransactions();
            System.out.println("\nAccount Number: " + account.getAccountNumber());

            if (transactions.isEmpty()) {
                System.out.println("No transactions available.");
            } else {
                System.out.println("Transactions:");
                for (Transaction transaction : transactions) {
                    System.out.println(transaction.toString());
                }
            }
        }
    }

    // Metode untuk mencari akun berdasarkan nomor akun
    private Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

}

