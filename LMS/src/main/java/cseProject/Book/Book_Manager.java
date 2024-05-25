/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Book;

import cseProject.FileManagerTemplate.FileManagerTemplate;
import cseProject.Helper.RealSystemHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        System.out.println("- 도서를 추가 합니다.");
        System.out.print("▶ 제목 : ");
        String title = helper.getUserInput();
        System.out.print("▶ 저자 : ");
        String author = helper.getUserInput();
        System.out.print("▶ 장르 : ");
        String genre = helper.getUserInput();
        System.out.print("▶ 출판사 : ");
        String publisher = helper.getUserInput();
        System.out.print("▶ ISBN : ");
        String ISBN = helper.getUserInput();

        Book_Info book = new Book_Info(title, author, genre, publisher, ISBN, false);

        add_BookDB(book);
        System.out.println("- " + book.getTitle() + " 도서가 추가되었습니다.");
        try {
            FileManagerTemplate.getInstance("Book").writeDBFile("Book_Info.txt");
        } catch (IOException ex) {
            Logger.getLogger(Book_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Book_Info> findBooksByTitle() { // 제목으로 검색 (안쓰이는중)
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

    public ArrayList<Book_Info> findBooksByOption() { // 검색 조건 (안쓰이는중)
        System.out.println("1.제목 2.저자 3.장르 4.출판사 5.대여 상태");
        System.out.println("옵션을 골라주세요.");
        String option = helper.getUserInput();
        ArrayList<Book_Info> books = new ArrayList<>();
        switch (option) {
            case "1" -> {
                String title = helper.getUserInput();
                for (Book_Info book : bookDB) {
                    if (book.getTitle().contains(title)) {
                        books.add(book);
                    }
                }
            }
            case "2" -> {
                String author = helper.getUserInput();
                for (Book_Info book : bookDB) {
                    if (book.getAuthor().contains(author)) {
                        books.add(book);
                    }
                }
            }
            case "3" -> {
                String genre = helper.getUserInput();
                for (Book_Info book : bookDB) {
                    if (book.getGenre().contains(genre)) {
                        books.add(book);
                    }
                }
            }
            case "4" -> {
                String publisher = helper.getUserInput();
                for (Book_Info book : bookDB) {
                    if (book.getPublisher().contains(publisher)) {
                        books.add(book);
                    }
                }
            }
            case "5" -> {
                boolean isBorrowed = Boolean.parseBoolean(helper.getUserInput());
                for (Book_Info book : bookDB) {
                    if (book.getIsBorrorwed() == isBorrowed) {
                        books.add(book);
                    }
                }
            }
        }
        return books;
    }

    public ArrayList<Book_Info> findBooksByAll() { // 모든 검색어
        System.out.print("▶ 키워드 : ");
        String option = helper.getUserInput(); // 검색어
        ArrayList<Book_Info> books = new ArrayList<>();

        for (Book_Info book : bookDB) {
            if (book.getTitle().contains(option)) {
                books.add(book);
            }
        }

        for (Book_Info book : bookDB) {
            if (book.getAuthor().contains(option)) {
                books.add(book);
            }
        }

        for (Book_Info book : bookDB) {
            if (book.getGenre().contains(option)) {
                books.add(book);
            }
        }

        for (Book_Info book : bookDB) {
            if (book.getPublisher().contains(option)) {
                books.add(book);
            }
        }

        for (Book_Info book : bookDB) {
            if (book.getISBN().contains(option)) {
                books.add(book);
            }
        }

//        boolean isBorrowed = Boolean.parseBoolean(option);
//        for (Book_Info book : bookDB) {
//            if (book.getIsBorrorwed() == isBorrowed) {
//                books.add(book);
//            }
//        }
        return books;
    }

    public void showBooks(ArrayList<Book_Info> targetBooks) { // 조건에 맞는 책 출력
        if (targetBooks.isEmpty()) {
            System.out.println("────────────────────────────────────────────────────────────────────────");
            System.out.println("조건에 맞는 도서 목록이 없습니다.");
            System.out.println("────────────────────────────────────────────────────────────────────────");
        } else {
            System.out.println("────────────────────────────────────────────────────────────────────────");
            System.out.printf("%1s%5s%25s%20s%20s%20s%20s\n", "번호", "제목", "저자", "장르", "출판사", "ISBN", "대여여부");
            System.out.println("────────────────────────────────────────────────────────────────────────");
            for (int i = 0; i < targetBooks.size(); i++) {
                Book_Info book = targetBooks.get(i);
                System.out.printf(
                        "%-5d %-20s %-20s %-10s %-20s %-20s %-10s\n",
                        i + 1,
                        book.getTitle(),
                        book.getAuthor(),
                        book.getGenre(),
                        book.getPublisher(),
                        book.getISBN(),
                        borrowCheck(book)
                );
            }
        }
    }

    public Book_Info findBookByISBN() {
        System.out.print("▶ 대상 도서 ISBN : ");
        String ISBN = helper.getUserInput();
        for (Book_Info book : bookDB) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public Book_Info findBookByISBN(String ISBN) {
        for (Book_Info book : bookDB) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public void editBook(Book_Info targetBook) {
        if (targetBook == null) {
            System.out.println("- 해당 ISBN의 도서가 없습니다.");
            return;
        }

        System.out.println("- 도서를 수정 합니다. 수정할 내용이 없으면 enter을 입력하세요");
        System.out.print("▶ 제목 : ");
        String title = helper.getUserInput();
        System.out.print("▶ 저자 : ");
        String author = helper.getUserInput();
        System.out.print("▶ 장르 : ");
        String genre = helper.getUserInput();
        System.out.print("▶ 출판사 : ");
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

        try {
            FileManagerTemplate.getInstance("Book").writeDBFile("Book_Info.txt");
        } catch (IOException ex) {
            Logger.getLogger(Book_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeBook(Book_Info targetBook) {

        System.out.println("- " + targetBook.getTitle() + " 도서가 삭제되었습니다");
        getBookDB().remove(targetBook);
        try {
            FileManagerTemplate.getInstance("Book").writeDBFile("Book_Info.txt");
        } catch (IOException ex) {
            Logger.getLogger(Book_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayBooks() { // 모든 책 보여주기
        if (bookDB.isEmpty()) {
            System.out.println("────────────────────────────────────────────────────────────────────────");
            System.out.println("현재 도서 목록이 없습니다.");
            System.out.println("────────────────────────────────────────────────────────────────────────");
        } else {
            System.out.println("────────────────────────────────────────────────────────────────────────");
            System.out.printf("%1s%5s%25s%20s%20s%20s%20s\n", "번호", "제목", "저자", "장르", "출판사", "ISBN", "대여여부");
            System.out.println("────────────────────────────────────────────────────────────────────────");
            for (int i = 0; i < bookDB.size(); i++) {
                Book_Info book = bookDB.get(i);
                System.out.printf(
                        "%-5d %-20s %-20s %-10s %-20s %-20s %-10s\n",
                        i + 1,
                        book.getTitle(),
                        book.getAuthor(),
                        book.getGenre(),
                        book.getPublisher(),
                        book.getISBN(),
                        borrowCheck(book)
                );
            }
            System.out.println("────────────────────────────────────────────────────────────────────────");
        }
    }

    public String borrowCheck(Book_Info book) {
        if (book.getIsBorrorwed() == false) {
            return "대여가능";
        } else {
            return "대여중";
        }
    }
}
