package entities;

/**
 * Created by prajapas on 7/13/2017.
 */
public class Admin {
    private String userName;
    private String name;

    public Admin(String userName, String name) {
        this.userName = userName;
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
