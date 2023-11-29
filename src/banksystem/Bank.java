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

    // Metode untuk transfer antar akun
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = getAccount(fromAccountNumber);
        Account toAccount = getAccount(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            System.out.println("One or both accounts not found.");
            return;
        }

        if (fromAccount.getBalance() < amount) {
            System.out.println("Insufficient funds in the source account.");
            return;
        }

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("Transferred " + amount + " from account " + fromAccountNumber + " to account " + toAccountNumber);
    }

     // Metode untuk mendapatkan semua pengguna
    public List<User> getUsers() {
        return users;
    }
}

