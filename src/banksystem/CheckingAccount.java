package banksystem;

/**
 *
 * @author Tiara
 */
public class CheckingAccount extends Account {
    // Konstruktor untuk CheckingAccount
    public CheckingAccount(String accountNumber, double balance, double interestRate, Customer cust) {
        super(accountNumber, balance, interestRate, cust);
    }

    // Override metode deposit
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        balance -= transactionFee; // Mengurangi biaya transaksi dari saldo
        System.out.println("Deposited: " + amount + ". Transaction fee: " + transactionFee);
    }
}

