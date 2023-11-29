package banksystem;

/**
 *
 * @author Tiara
 */
import java.util.List;
import java.util.Scanner;

public class BankSystem {
    private Bank bank;
    private Authenticator authenticator;
    private User currentUser;

    public BankSystem() {
        bank = new Bank();
        authenticator = new Authenticator();
        buatAkun();
    }
    
    //Buat akun default Admin dan Customer
    private void buatAkun() {
        // Membuat akun admin default
        Admin defaultAdmin = new Admin("Admin Bank", "admin", "admin");
        bank.addUser(defaultAdmin);

        // Membuat akun customer default
        Customer defaultCustomer = new Customer("Tiara Putri Ramadhani", "tiara", "tiara123");
        bank.addUser(defaultCustomer);

        // Akun default (tabungan) untuk customer
        SavingsAccount customerSavingsAccount = new SavingsAccount("SA12345", 1000.0, 1.5, defaultCustomer);
        defaultCustomer.addAccount(customerSavingsAccount);
        bank.addAccount(customerSavingsAccount);

        // Akun default (giro) untuk customer
        CheckingAccount customerCheckingAccount = new CheckingAccount("CA12345", 500.0, 1.0, defaultCustomer);
        defaultCustomer.addAccount(customerCheckingAccount);
        bank.addAccount(customerCheckingAccount);
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nWelcome to the Bank System");
                System.out.println("1. Login");
                System.out.println("2. Register Customer");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        login(scanner);
                        break;
                    case 2:
                        registerCustomer(scanner);
                        break;
                    case 3:
                        System.out.println("Exiting system...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }

    private void login(Scanner scanner) {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        User user = bank.getUser(id);
        if (user != null && authenticator.authenticate(user, password)) {
            currentUser = user;
            System.out.println("\nLogin successful.");
            // Menampilkan jenis pengguna yang login (Admin atau Customer)
            if (currentUser instanceof Admin) {
                System.out.println("Logged in as Admin: " + currentUser.getName());
                adminMenu();
                
            } else if (currentUser instanceof Customer) {
                System.out.println("Logged in as Customer: ");
                System.out.println("Name: " + currentUser.getName());
                System.out.println("ID: " + currentUser.getId());
                ((Customer) currentUser).customerMenu();
                
            }
        } else {
            System.out.println("Invalid ID or Password.");
        }
    }
    
    private void registerCustomer(Scanner scanner) {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Customer Password: ");
        String password = scanner.nextLine();

        // Buat objek Customer baru
        Customer newCustomer = new Customer(name, id, password);

        // Tambahkan Customer ke dalam sistem Bank
        bank.addUser(newCustomer);

        // Buat akun tabungan baru untuk Customer
        SavingsAccount savingsAccount = new SavingsAccount(generateAccountNumber(), 0.0, 0.0, newCustomer);
        newCustomer.addAccount(savingsAccount);
        bank.addAccount(savingsAccount);

        // Buat akun giro baru untuk Customer
        CheckingAccount checkingAccount = new CheckingAccount(generateAccountNumber(), 0.0, 0.0, newCustomer);
        newCustomer.addAccount(checkingAccount);
        bank.addAccount(checkingAccount);

        System.out.println("Customer registration successful.");
    }

    // Metode untuk menghasilkan nomor akun secara acak (contoh sederhana)
    private String generateAccountNumber() {
        return "ACC" + (int) (Math.random() * 10000);
    }
    
    //Method untuk Admin
    public void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(choice != 2){
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View All Users and Their Accounts");
            System.out.println("2. View All Transaction History");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Dapatkan semua pengguna dari Bank
                    List<User> users = bank.getUsers();
                    System.out.println("\nAll Users and Their Accounts:");

                    for (User user : users) {
                        System.out.println("User: " + user.getName());
                        if (user instanceof Customer) {
                            Customer customer = (Customer) user;
                            List<Account> accounts = customer.getAccounts();
                            System.out.println("Accounts:");
                            for (Account account : accounts) {
                                System.out.println("  Account Number: " + account.getAccountNumber());
                                System.out.println("  Balance: " + account.getBalance());
                            }
                        }
                        System.out.println("------------------------");
                    }
                    break;
                case 2:
                    // Kode untuk Method view all transaction history (soon)
                    break;
                    
                case 3:
                    // Kembali ke menu utama (tidak perlu tindakan tambahan)
                    break;
                default:
                    System.out.println("Invalid choice.");
            }   
            
        }
       
    }

    public static void main(String[] args) {
        new BankSystem().start();
    }
}

