public class User {
    public String fullname;
    public String username;
    public String password;

    public User(String fullname, String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }

    //public String checkFullname(){ return fullname; }
    //public boolean checkFullname(String fullname) { return this.fullname.equals(fullname); }
}
