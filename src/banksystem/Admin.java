   package banksystem;

/**
 *
 * @author Tiara
 */
public class Admin extends User {
    
    public Admin(String name, String id, String password) {
        super(name, id, password);
    }

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

