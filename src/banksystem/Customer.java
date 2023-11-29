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
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    deposit();
                    break;
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

