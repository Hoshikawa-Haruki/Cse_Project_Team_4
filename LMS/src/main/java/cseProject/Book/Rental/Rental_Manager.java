/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Book.Rental;

import cseProject.Book.Book_Info;
import cseProject.Book.Book_Manager;
import cseProject.FileManagerTemplate.FileManagerTemplate;
import cseProject.Helper.SystemHelper;
import cseProject.Login.User_Manager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 이승환
 */
public class Rental_Manager {

    private static Rental_Manager instance;
    private static SystemHelper helper = SystemHelper.getInstance();
    private ArrayList<Rental_Info> rentalDB = new ArrayList<>();

    public ArrayList<Rental_Info> getRentalDB() {
        return rentalDB;
    }

    public void setRentalDB(ArrayList<Rental_Info> rentalDB) {
        this.rentalDB = rentalDB;
    }

    private void Rental_Manager() {

    }

    public static Rental_Manager getInstance() {
        if (instance == null) {
            instance = new Rental_Manager();
        }
        return instance;
    }

    public void add_rentalDB(Rental_Info rental_Membership) {
        rentalDB.add(rental_Membership);
    }

    public void remove_rentalDB(Rental_Info rental_Membership) {
        rentalDB.remove(rental_Membership);
    }

    public void doRental(Book_Info targetBook) { // 도서 대여
        String userID = User_Manager.getInstance().getLoginUser().getUserID();
        String userName = User_Manager.getInstance().getLoginUser().getUserName();
        String title = targetBook.getTitle();
        String ISBN = targetBook.getISBN();
        if (!targetBook.getIsBorrorwed()) {
            targetBook.setIsBorrorwed(true);

            Rental_Info rtbook = new Rental_Info(userID, userName, title, ISBN);

            add_rentalDB(rtbook);
            System.out.println("- " + targetBook.getTitle() + " 도서가 대여 되었습니다.");
            try {
                FileManagerTemplate.getInstance("Book").writeDBFile("Book_Info.txt");
                FileManagerTemplate.getInstance("Rental").writeDBFile("Rental_Info.txt");
            } catch (IOException ex) {
                Logger.getLogger(Rental_Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("해당 도서는 현재 대여중입니다.");
        }
    }

    public void doReturn(Rental_Info targetBook) { // 도서 반납
        remove_rentalDB(targetBook);
        Book_Info targetReturnBook = Book_Manager.getInstance().findBookByISBN(targetBook.getISBN());
        if (targetReturnBook != null) {
            targetReturnBook.setIsBorrorwed(false);
            System.out.println("- " + targetBook.getTitle() + " 도서가 반납되었습니다.");
            try {
                FileManagerTemplate.getInstance("Book").writeDBFile("Book_Info.txt");
                FileManagerTemplate.getInstance("Rental").writeDBFile("Rental_Info.txt");
            } catch (IOException ex) {
                Logger.getLogger(Rental_Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            System.out.println("현재 해당 도서는 대여중이 아닙니다.");
        }
    }

    public Rental_Info findMyBookByISBN() { // rental_DB 에서 본인 책 찾기
        System.out.print("▶ 대상 도서 ISBN : ");
        String ISBN = helper.getUserInput();
        for (Rental_Info targetBook : rentalDB) {
            if (targetBook.getISBN().equals(ISBN)) {
                return targetBook;
            }
        }
        return null;
    }

    public void showMyRentalInfo() {
        System.out.println("● " + User_Manager.getInstance().getLoginUser().getUserName() + " 님의 대여 정보 입니다");
        System.out.println("────────────────────────────────────────────────────────────────────────");
        String myID = User_Manager.getInstance().getLoginUser().getUserID();
        for (Rental_Info rental : rentalDB) {
            if (rental.getUserID().equals(myID)) {
                //System.out.println(rental.getTitle() + " " + rental.getISBN());
                System.out.println(String.format("%s%20s", rental.getTitle(), rental.getISBN()));
            }
        }
        System.out.println("────────────────────────────────────────────────────────────────────────");
    }

    public void showAllRentalInfo() {
        System.out.println("● 현재 모든 이용자의 대여 정보 입니다");
        System.out.println("────────────────────────────────────────────────────────────────────────");
        System.out.println(String.format("%-5s %-15s %-15s %-15s %-15s", "No", "아이디", "이름", "도서명", "ISBN"));

        int rowNumber = 1;
        for (Rental_Info rental : rentalDB) {
            System.out.println(String.format("%-5d %-20s %-15s %-15s %-15s", rowNumber, rental.getUserID(), rental.getUserName(), rental.getTitle(), rental.getISBN()));
            rowNumber++;
        }
        System.out.println("────────────────────────────────────────────────────────────────────────");
    }
}
