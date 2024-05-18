/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Book;

import cseProject.SystemHelper;
import java.util.ArrayList;

/**
 *
 * @author 이승환
 */
public class Book_Manager {

    private static Book_Manager instance;
    private ArrayList<Book_Info> bookDB = new ArrayList<>();
    private static SystemHelper helper = SystemHelper.getInstance();

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

    public void make_Book() {
        System.out.println("도서를 추가 합니다");
        System.out.print("제목");
        String title = helper.getUserInput();
        System.out.print("출판사: ");
        String publisher = helper.getUserInput();
        System.out.print("장르: ");
        String genre = helper.getUserInput();
        System.out.print("ISBN: ");
        String ISBN = helper.getUserInput();
        System.out.print("저자: ");
        String author = helper.getUserInput();

        Book_Info book = new Book_Info(title, publisher, author, genre, ISBN);
        add_bookDB(book);
    }

    public void displayBooks() {
        if (bookDB.isEmpty()) {
            System.out.println("책 목록이 비어 있습니다.");
        } else {
            for (int i = 0; i < bookDB.size(); i++) {
                Book_Info book = bookDB.get(i);
                System.out.println(
                        i + 1
                        + "."
                        + String.format("%15s", book.getTitle())
                        + String.format("%15s", book.getAuthor())
                        + String.format("%15s", book.getPublihser())
                        + String.format("%15s", book.getGenre())
                        + String.format("%15s", book.getISBN())
                );
            }
        }
    }
}
