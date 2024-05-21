/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Book;

import cseProject.FileManager;

/**
 *
 * @author 이승환
 */
public class RentalObserver implements Observer {

    private Subject book_Info;

    public RentalObserver(Book_Info book_Info) {
        this.book_Info = book_Info;
        this.book_Info.registerObserver(this);
    }

    @Override
    public void updateRental(String ISBN) {
        Book_Info book = null;
        for (Book_Info bk : Book_Manager.getInstance().getBookDB()) {
            if (bk.getISBN().equals(ISBN)) {
                book = bk;
            }
        }

        if (book != null) {
            book.setIsBorrorwed(true);
            System.out.println(ISBN + " 도서가 대여 되었습니다.");
            FileManager.getInstance().writeDBFile("Book_Info.txt");
        } else {
            System.out.println(ISBN + " 도서가 없습니다.");
        }
    }

    @Override
    public void updateReturn(String ISBN) {
        Book_Info book = null;
        for (Book_Info bk : Book_Manager.getInstance().getBookDB()) {
            if (bk.getISBN().equals(ISBN)) {
                book = bk;
            }
        }

        if (book != null) {
            book.setIsBorrorwed(false);
            System.out.println(ISBN + " 도서가 반납 되었습니다.");
            FileManager.getInstance().writeDBFile("Book_Info.txt");
        } else {
            System.out.println(ISBN + " 도서가 없습니다.");
        }
    }

}
