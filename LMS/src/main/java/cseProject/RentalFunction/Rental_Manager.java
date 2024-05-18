/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.RentalFunction;

import java.util.ArrayList;

/**
 *
 * @author 이승환
 */
public class Rental_Manager {

    private ArrayList<Rental_Info> rentalDB = new ArrayList<>();
    private static Rental_Manager instance;

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
}
