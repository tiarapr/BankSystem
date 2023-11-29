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
    protected Customer cust;

    public Account(String accountNumber, double balance, Customer cust) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.cust = cust;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Get the cust (Customer) of the account
    public Customer getCust() {
        return cust;
    }
}

