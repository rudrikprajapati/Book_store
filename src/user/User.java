package user;

import book.Book;

import java.util.ArrayList;

public class User {

    private String username, password;
    private double points = 600;
    private final int uid = (int) (Math.random() * (100 - 10 + 1) + 10);
    ArrayList<Book> bookBought = new ArrayList<Book>();

    public ArrayList<Book> getBookBought() {
        return bookBought;
    }

    public boolean buyBook(Book book)
    {
            bookBought.add(book);
            return true;
    }

    //Get - UserName
    public String getUsername() {
        return username;
    }

    // Set Username
    public void setUsername(String username) {
        this.username = username;
    }

    // Get - Password
    public String getPassword() {
        return password;
    }

    // Set - Password
    public void setPassword(String password) {
        this.password = password;
    }

    // Get - User Points
    public double getPoints() {
        return points;
    }

    // Set - User Points
    public void setPoints(double points) {
        this.points = points;
    }

    // Get User ID
    public int getUid() {
        return uid;
    }

}


