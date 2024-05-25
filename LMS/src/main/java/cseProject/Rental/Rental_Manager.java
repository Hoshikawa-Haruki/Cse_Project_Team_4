/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Rental;

import cseProject.Book.Book_Info;
import cseProject.FileManagerTemplate.FileManagerTemplate;
import cseProject.Helper.RealSystemHelper;
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
    private static RealSystemHelper helper = RealSystemHelper.getInstance();
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
        System.out.println("대여목록에 추가 합니다");
        String userID = User_Manager.getInstance().getLoginUser().getUserID();
        String userName = User_Manager.getInstance().getLoginUser().getUserName();
        String title = targetBook.getTitle();
        String ISBN = targetBook.getISBN();

        Rental_Info rtbook = new Rental_Info(userID, userName, title, ISBN);

        add_rentalDB(rtbook);
        System.out.println("- " + targetBook.getTitle() + " 도서가 대여되었습니다.");
        try {
            FileManagerTemplate.getInstance("Rental").writeDBFile("Rental_Info.txt");
        } catch (IOException ex) {
            Logger.getLogger(Rental_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doReturn(Rental_Info targetBook) { // 도서 대여
        System.out.println("반납을 실행 합니다");
        remove_rentalDB(targetBook);
        System.out.println("- " + targetBook.getTitle() + " 도서가 반납되었습니다.");
        try {
            FileManagerTemplate.getInstance("Rental").writeDBFile("Rental_Info.txt");
        } catch (IOException ex) {
            Logger.getLogger(Rental_Manager.class.getName()).log(Level.SEVERE, null, ex);
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
}
