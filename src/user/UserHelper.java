package user;

import book.Book;

import java.util.ArrayList;
import java.util.HashMap;

public class UserHelper {

    //Forget Password - Just Checking If Name Is Same As Old Or Not , If Yes We Change The Password , Else We Return False
    public boolean forgetPassword(String uName, String newPass, HashMap<String, User> users) {
        boolean userNameCheck = users.containsKey(uName);

        if (userNameCheck) {
            users.get(uName).setPassword(newPass);
            return true;
        } else {
            return false;
        }
    }


    // Passing User Object And Using Its Data To Display User Profile
    public void displayUserProfile(User user) {
        System.out.println("--------------------------- USER PROFILE-------------------------------- ");
        System.out.println("Username : " + user.getUsername());
        System.out.println("Points : " + user.getPoints());


        ArrayList<Book> bookBought = user.getBookBought();

        System.out.println("Books Bought : ");

        System.out.println("Book ID " + " | " + "Book Name" + " | " + " Book Author ");

        for (int i = 0; i < user.getBookBought().size(); i++) {
            System.out.println(bookBought.get(i).getBook_id() + " | " + bookBought.get(i).getName() + " | " + bookBought.get(i).getAuthor());
        }
        System.out.println("----------------------END OF USER PROFILE-------------------------------- ");

    }


}
