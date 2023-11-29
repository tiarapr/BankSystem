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

