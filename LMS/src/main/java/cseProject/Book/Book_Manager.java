/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Book;

import java.util.ArrayList;

/**
 *
 * @author 이승환
 */
public class Book_Manager {

    private static Book_Manager instance;
    private ArrayList<Book_Info> bookDB = new ArrayList<>();

    public static Book_Manager getInstance() {
        if (instance == null) {
            instance = new Book_Manager();
        }
        return instance;
    }

    public ArrayList<Book_Info> getBookDB() {
        return bookDB;
    }

    public void add_bookDB(Book_Info book_Membership) {
        bookDB.add(book_Membership);
    }
}
