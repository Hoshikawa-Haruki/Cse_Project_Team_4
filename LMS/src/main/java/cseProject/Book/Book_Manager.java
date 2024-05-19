/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Book;

import cseProject.FileManager;
import cseProject.Helper.RealSystemHelper;
import java.util.ArrayList;

/**
 *
 * @author 이승환
 */
public class Book_Manager {

    private static Book_Manager instance;
    private ArrayList<Book_Info> bookDB = new ArrayList<>();
    private static RealSystemHelper helper = RealSystemHelper.getInstance();

    public static Book_Manager getInstance() {
        if (instance == null) {
            instance = new Book_Manager();
        }
        return instance;
    }

    public ArrayList<Book_Info> getBookDB() {
        return bookDB;
    }

    public void add_BookDB(Book_Info book_Membership) {
        bookDB.add(book_Membership);
    }

    public void makeBook() {
        System.out.println("도서를 추가 합니다.");
        System.out.print("제목: ");
        String title = helper.getUserInput();
        System.out.print("저자: ");
        String author = helper.getUserInput();
        System.out.print("장르: ");
        String genre = helper.getUserInput();
        System.out.print("출판사: ");
        String publisher = helper.getUserInput();
        System.out.print("ISBN: ");
        String ISBN = helper.getUserInput();

        Book_Info book = new Book_Info(title, author, genre, publisher, ISBN);
        add_BookDB(book);
        FileManager.getInstance().writeDBFile("Book_Info.txt");
    }

    public ArrayList<Book_Info> findBooksByTitle() {
        System.out.print("대상 도서 제목: ");
        String title = helper.getUserInput();
        ArrayList<Book_Info> books = new ArrayList<>();
        for (Book_Info book : bookDB) {
            if (book.getTitle().equals(title)) {
                books.add(book);
            }
        }
        return books;
    }

    public void showBooks(ArrayList<Book_Info> targetBooks) {
        if (targetBooks.isEmpty()) {
            System.out.println("책 목록이 비어 있습니다.");
        } else {
            for (int i = 0; i < targetBooks.size(); i++) {
                Book_Info book = targetBooks.get(i);
                System.out.println(
                        i + 1
                        + "."
                        + String.format("%15s", book.getTitle())
                        + String.format("%15s", book.getAuthor())
                        + String.format("%15s", book.getGenre())
                        + String.format("%15s", book.getPublihser())
                        + String.format("%15s", book.getISBN())
                );
            }
        }
    }

    public Book_Info findBookByISBN() {
        System.out.print("대상 도서 ISBN: ");
        String ISBN = helper.getUserInput();
        for (Book_Info book : bookDB) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public void editBook(Book_Info targetBook) {
        if (targetBook == null) {
            System.out.println("해당 ISBN의 도서가 없습니다.");
            return;
        }

        System.out.println("도서를 수정 합니다.");
        System.out.print("제목: ");
        String title = helper.getUserInput();
        System.out.print("저자: ");
        String author = helper.getUserInput();
        System.out.print("장르: ");
        String genre = helper.getUserInput();
        System.out.print("출판사: ");
        String publisher = helper.getUserInput();

        if (!title.isBlank()) {
            targetBook.setTitle(title);
        }

        if (!publisher.isBlank()) {
            targetBook.setPublisher(publisher);
        }

        if (!genre.isBlank()) {
            targetBook.setGenre(genre);
        }

        if (!author.isBlank()) {
            targetBook.setAuthor(author);
        }

        FileManager.getInstance().writeDBFile("Book_Info.txt");
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
                        + String.format("%15s", book.getGenre())
                        + String.format("%15s", book.getPublihser())
                        + String.format("%15s", book.getISBN())
                );
            }
        }
    }
}
