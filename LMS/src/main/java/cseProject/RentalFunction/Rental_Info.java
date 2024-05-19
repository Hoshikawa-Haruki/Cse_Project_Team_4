/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.RentalFunction;

/**
 *
 * @author 이승환
 */
public class Rental_Info {

    private String userID;
    private String userName;
    private String Title;
    private String ISBN;

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
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
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
        this.Title = Title;
        this.ISBN = ISBN;
    }

}
