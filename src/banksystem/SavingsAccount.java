package banksystem;

/**
 *
 * @author VNX
 */
public class SavingsAccount extends Account {
    private double interestRate;

    // Konstruktor untuk SavingsAccount
    public SavingsAccount(String accountNumber, double balance, double interestRate, Customer cust) {
        super(accountNumber, balance, interestRate, cust);
    }

    // Metode untuk menghitung bunga dan menambahkannya ke saldo
    public void addInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
    }

    // Getter dan setter untuk interestRate
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}

