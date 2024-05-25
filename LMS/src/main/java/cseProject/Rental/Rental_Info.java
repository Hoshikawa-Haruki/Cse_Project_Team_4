/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Rental;

import cseProject.Book.Book_Info;
import cseProject.FileManagerTemplate.FileManagerTemplate;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 이승환
 */
public class Rental_Info implements Observer {

    private String userID;
    private String userName;
    private String title;
    private String ISBN;

    private Book_Info book_info;

    public void setSubject(Book_Info book_info) {
        this.book_info = book_info;
        this.book_info.registerObserver(this);
    }

    @Override
    public void update(String title) {
        this.title = title;
        try {
            FileManagerTemplate.getInstance("Rental").writeDBFile("Rental_Info.txt");
        } catch (IOException ex) {
            Logger.getLogger(Rental_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Rental_Info(String userID, String userName, String Title, String ISBN) {
        this.userID = userID;
        this.userName = userName;
        this.title = Title;
        this.ISBN = ISBN;
    }

}
