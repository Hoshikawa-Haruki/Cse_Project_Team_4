/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Book;

import cseProject.FileManagerTemplate.FileManagerTemplate;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 이승환
 */
public class RentalObserver_Dead implements Observer_Dead {

    private Subject book_Info;

    public RentalObserver_Dead(Book_Info book_Info) {
        this.book_Info = book_Info;
        //this.book_Info.registerObserver(this);
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
            try {
                FileManagerTemplate.getInstance("Book").writeDBFile("Book_Info.txt");
            } catch (IOException ex) {
                Logger.getLogger(RentalObserver_Dead.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println(ISBN + " 해당 도서가 없습니다.");
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
            try {
                FileManagerTemplate.getInstance("Book").writeDBFile("Book_Info.txt");
            } catch (IOException ex) {
                Logger.getLogger(RentalObserver_Dead.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println(ISBN + " 해당 도서가 없습니다.");
        }
    }
}
