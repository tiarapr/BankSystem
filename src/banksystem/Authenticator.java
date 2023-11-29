package banksystem;

/**
 *
 * @author Tiara
 */
public class Authenticator {
    
    public boolean authenticate(User user, String password) {
        return user.getPassword().equals(password);
    }
}

