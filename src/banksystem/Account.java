package banksystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiara
 */
public class Account {
    protected String accountNumber;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

