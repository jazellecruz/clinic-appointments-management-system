
package main.java.models;

public class Admin {
    private int adminId;
    private String email;
    private String password;
    private boolean isAuthenticated;
    
    public Admin() { }
    
    public Admin(int adminId, String email, String password, boolean isAuthenticated) {
       this.adminId = adminId;
       this.email = email;
       this.password = password;
       this.isAuthenticated = isAuthenticated;
    }

    public int getAdminId() {
        return adminId;
    }


    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }


    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the isAuthenticated
     */
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    /**
     * @param isAuthenticated the isAuthenticated to set
     */
    public void setIsAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
    
    
 }
