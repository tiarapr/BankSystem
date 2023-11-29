package banksystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiara
 */
public class Account {
    protected String accountNumber;
    protected double balance;
    protected double interestRate;
    protected Customer cust;
    private List<Transaction> transactions;

    public Account(String accountNumber, double balance, double interestRate, Customer cust) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;
        this.cust = cust;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        Transaction transaction = new Transaction(accountNumber, amount, "DEPOSIT");
        transactions.add(transaction);
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    // Get the cust (Customer) of the account
    public Customer getCust() {
        return cust;
    }
}

