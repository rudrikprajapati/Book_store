import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDatabase database = new UserDatabase();

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter Fullname: ");
                String fullname = scanner.next();
                System.out.print("Enter username: ");
                String username = scanner.next();
                System.out.print("Enter password: ");
                String password = scanner.next();
                User user = new User(fullname, username, password);
                database.addUser(user);
                System.out.println("Registration successful!");
            }
            else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.next();
                System.out.print("Enter password: ");
                String password = scanner.next();
                User user = database.getUser(username);
                if (user != null && user.verifyPassword(password)) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Incorrect username or password.");
                }
                System.out.println("1. Forgot password ");
                System.out.println("2. Exit ");
                int select = scanner.nextInt();
                if(select == 1){
                    System.out.print("Enter username: ");
                    username = scanner.next();
                    user = database.getUser(username);
                    System.out.print("Enter New Password :");
                    UserDatabase.ForgotPassword(user);
                    System.out.println("Password Changed Successfully!");
                }
                else if(select == 2){
                    continue;
                }
                else System.out.println("Invalid choice.");
            }
            else if (choice == 3) {
                break;
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
    }
}

