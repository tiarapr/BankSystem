package banksystem;

/**
 *
 * @author Tiara
 */
public class User {
    protected String name;
    protected String id;
    protected String password;

    // Konstruktor untuk User
    public User(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    // Getter dan setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
