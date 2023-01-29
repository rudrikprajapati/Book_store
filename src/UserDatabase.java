import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserDatabase {
    static Scanner scanner = new Scanner(System.in);
    private List<User> users;

    public UserDatabase() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void ForgotPassword(User user){
        user.password = scanner.next();
    }
}