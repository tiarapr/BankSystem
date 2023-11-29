package banksystem;

/**
 *
 * @author Tiara
 */
import java.util.Date;

public class Transaction {
    private String accountNumber;
    private Date transactionDate;
    private double amount;
    private String type; // Misalnya: "DEPOSIT", "WITHDRAW"

    // Konstruktor untuk Transaction
    public Transaction(String accountNumber, double amount, String type) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
        this.transactionDate = new Date(); // Menetapkan tanggal saat ini untuk transaksi
    }

    // Getter dan setter
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Metode untuk mencetak detail transaksi
    public void printTransactionDetails() {
        System.out.println("Transaction: " + type);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + transactionDate);
    }
    
    @Override
    public String toString() {
        return "-> Transaction: " + type + "\n" +
               "   Account Number: " + accountNumber + "\n" +
               "   Amount: " + amount + "\n" +
               "   Date: " + transactionDate + "\n";
    }
}

