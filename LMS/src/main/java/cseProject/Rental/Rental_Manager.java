/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Rental;

import cseProject.Book.Book_Info;
import cseProject.FileManager;
import cseProject.Login.User_Manager;
import java.util.ArrayList;

/**
 *
 * @author 이승환
 */
public class Rental_Manager {

    private static Rental_Manager instance;
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

    public void doRental(Book_Info targetBook) {
        System.out.println("대여목록에 추가 합니다");
        String userID = User_Manager.getInstance().getLoginUser().getUserID();
        String userName = User_Manager.getInstance().getLoginUser().getUserName();
        String title = targetBook.getTitle();
        String ISBN = targetBook.getISBN();

        Rental_Info rtbook = new Rental_Info(userID, userName, title, ISBN);

        add_rentalDB(rtbook);
        System.out.println("- " + targetBook.getTitle() + " 도서가 대여되었습니다.");
        FileManager.getInstance().writeDBFile("Rental_Info.txt");
    }

    public void doReturn(Book_Info targetBook) {
        System.out.println("반납 실행 합니다");
        String userID = User_Manager.getInstance().getLoginUser().getUserID();
        String userName = User_Manager.getInstance().getLoginUser().getUserName();
        String title = targetBook.getTitle();
        String ISBN = targetBook.getISBN();

        Rental_Info rtbook = new Rental_Info(userID, userName, title, ISBN);

        add_rentalDB(rtbook);
        System.out.println("- " + targetBook.getTitle() + " 도서가 대여되었습니다.");
        FileManager.getInstance().writeDBFile("Rental_Info.txt");
    }
    
    public void findMyRentedBook(){
        System.out.println("반납할 책을 입력하세요");
    }
}
