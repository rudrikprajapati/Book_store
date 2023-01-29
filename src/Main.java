import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Console;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        UserDatabase database = new UserDatabase();
        Console console = System.console();
        if (console == null) {
            throw new Exception("System.console is supported only in consoles. Please run this program in a console.");
        }

        //adding dummy data of user
        User user1 = new User("rudrikprajapati", "rudrik", "prajapati");
        User user2 = new User("dhruvgheewala", "dhruv", "gheewala");
        User user3 = new User("nirlayrana", "nirlay", "rana");
        User user4 = new User("palashshah", "palash", "shah");
        User user5 = new User("sakshipatel", "sakshi", "patel");

        database.addUser(user1);
        database.addUser(user2);
        database.addUser(user3);
        database.addUser(user4);
        database.addUser(user5);

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
                String password = new String(console.readPassword("%s", "Password: "));
                User user = new User(fullname, username, password);
                database.addUser(user);
                System.out.println("Registration successful!");
            }
            else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.next();
                System.out.print("Enter password: ");
                String password = new String(console.readPassword("%s", "Password: "));
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

        Book book1 = new Book("Game of thrones", 8000,9  );
        Book book2 = new Book("Naruto", 4500,3  );
        Book book3 = new Book("Attack On Titan", 3000,7  );
        Book book4 = new Book("One Piece", 9500,2  );
        Book book5 = new Book("Death Note", 900,4  );

        Display.addBook(book1);
        Display.addBook(book2);
        Display.addBook(book3);
        Display.addBook(book4);
        Display.addBook(book5);
    }
}

