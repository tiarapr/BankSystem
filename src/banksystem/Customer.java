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
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewBalance();
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

