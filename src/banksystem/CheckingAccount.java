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
}

