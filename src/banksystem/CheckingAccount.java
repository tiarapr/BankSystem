package banksystem;

/**
 *
 * @author Tiara
 */
public class CheckingAccount extends Account {
    private double transactionFee;

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

    // Override metode withdraw
    @Override
    public void withdraw(double amount) {
        if (amount + transactionFee <= balance) {
            super.withdraw(amount);
            balance -= transactionFee; // Mengurangi biaya transaksi dari saldo
            System.out.println("Withdrawn: " + amount + ". Transaction fee: " + transactionFee);
        } else {
            System.out.println("Insufficient funds for withdrawal and transaction fee.");
        }
    }

    // Getter dan setter untuk transactionFee
    public double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }
}

