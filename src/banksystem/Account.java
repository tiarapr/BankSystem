package banksystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiara
 */
public class Account {
    protected String accountNumber;
    protected Customer cust;

    public Account(String accountNumber, Customer cust) {
        this.accountNumber = accountNumber;
        this.cust = cust;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Get the cust (Customer) of the account
    public Customer getCust() {
        return cust;
    }
}

