package banksystem;

/**
 *
 * @author Tiara
 */
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private List<User> users;

    public Bank() {
        accounts = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Metode untuk menambahkan akun
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Metode untuk menambahkan pengguna
    public void addUser(User user) {
        users.add(user);
    }

    // Metode untuk mendapatkan akun berdasarkan nomor akun
    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; // Atau throw exception
    }
    
    public List<Account> getAllAccounts() {
        return accounts;
    }

    // Metode untuk mencari pengguna berdasarkan ID
    public User getUser(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null; // Atau throw exception
    }

    // Metode untuk mendapatkan semua pengguna
    public List<User> getUsers() {
        return users;
    }
}

