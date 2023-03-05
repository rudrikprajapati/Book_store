import book.Availability;
import book.Book;
import book.BookHelper;
import user.User;
import user.UserHelper;

import java.io.Console;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static String consolePass() {
        Console console = System.console();
        String tempPass = "";
        if (console != null) {
            char tx[] = console.readPassword("Enter Password : ");
            tempPass = String.valueOf(tx);
            if (tempPass.length() != 0) {
                for (char c : tx) {
                    System.out.print("*");
                }
            }
            print("");
        }
        return tempPass;
    }

    public static void main(String[] args) {

        boolean isRegistered = false, isLoggedIn = false;
        HashMap<String, User> users = new HashMap<>();
        User loggedUser = null;

        UserHelper userHelper = new UserHelper();
        BookHelper bookHelper = new BookHelper();

        Scanner scanner = new Scanner(System.in);
        String userName = "", password = "";
        String fmt = "%2$5s %3$10s%n";
        int choice = -1;

////         User Login And Password
        while (true) {
            while (!isLoggedIn || !isRegistered) {

                print("Enter 1 For Registering");
                print("Enter 2 For Login");
                print("Enter 3 For Forget Password");

                print("Enter Your Choice : ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {

                        print("Please Enter username:");
                        scanner.nextLine();
                        userName = scanner.nextLine();

                        password = consolePass();

                        User createUser = new User();

                        //Checking If Username Already Exists - Not Permitting Multiple Users With Same Username
                        boolean allowUser = users.containsKey(userName);

                        if (!allowUser) {
                            createUser.setUsername(userName);
                            createUser.setPassword(password);

                            users.put(userName, createUser);
                        } else {
                            print("Username Already Exists");
                        }

                        isRegistered = true;

                    }
                    case 2 -> {
                        if (isRegistered) {
                            print("Please Enter username:");
                            scanner.nextLine();
                            String uName = scanner.nextLine();

                            boolean userNameCheck = users.containsKey(uName);

                            if (userNameCheck) {
                                String pass = consolePass();

                                String userPass = users.get(userName).getPassword();

                                if (userPass.equals(pass)) {
                                    isLoggedIn = true;
                                    loggedUser = users.get(userName);
                                } else {
                                    print("Wrong userName or Password");
                                }
                            }

                        } else {
                            print("Please Register Before Trying To Login");
                        }
                    }
                    case 3 -> {
                        if (isRegistered) {
                            print("Please Enter username:");
                            scanner.nextLine();
                            String uName = scanner.nextLine();
                            String newPass = consolePass();
                            boolean passChangeStatus = userHelper.forgetPassword(uName, newPass, users);
                            if (passChangeStatus) {
                                print("Password Changed Successfully");
                            } else {
                                print("Oops Wrong Username");
                            }
                        } else {
                            print("You Must Register Before , If You Wanna Change Password");
                        }

                    }
                    default -> {
                        print("Wrong Choice...");
                    }
                }
            }

            // Part 2 -> Display Books & Buy Books
            while (choice != 3) {
                bookHelper.showBooks();
                print("\n \n");
                print("Enter 1 For Show Profile");
                print("Enter 2 For Purchase");
                print("Enter 3 For Logout");
                print("Enter 4 For Exit");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        // Show Profile
                        userHelper.displayUserProfile(loggedUser);
                    }
                    case 2 -> {
                        // Buy Books
                        print("Enter Book ID : ");
                        int ch = scanner.nextInt();
                        ch = ch - 1; // Decreasing One As We Have 0 Base Indexing
                        // Checking If Book ID aka Index Is Valid Or Not
                        if (ch >= 0 && ch < bookHelper.getBooksLength()) {
                            Book bk = bookHelper.getSpecificBook(ch);
                            double userPoints = loggedUser.getPoints();
                            double bookPoint = bk.getPoints();

                            if (bk.getAvailability() == Availability.IN_STORE && userPoints >= bookPoint) {
                                boolean isCompleted = loggedUser.buyBook(bk);
                                loggedUser.setPoints(userPoints - bookPoint);
                                bookHelper.decreaseBookCopies(ch);
                                if (isCompleted) {
                                    System.out.println("--------------------------- Transaction Status -------------------------------- ");
                                    print("Book Bought");
                                    System.out.println("--------------------------- Transaction Status -------------------------------- ");

                                    userHelper.displayUserProfile(loggedUser);
                                }
                            } else {
                                System.out.println("--------------------------- Transaction Status -------------------------------- ");
                                print("The Book Is Not Available To Buy Or You Have Less Points Kindly Check");
                                System.out.println("--------------------------- Transaction Status -------------------------------- ");

                            }
                        } else {
                            print("Please Enter Valid ID");
                        }
                    }
                    case 3 -> {
                        isLoggedIn = false;
                        loggedUser = null;
                        break;
                    }
                    case 4 -> {
                        scanner.close();
                        exit(1);
                    }
                }
            }
        }
    }
}



