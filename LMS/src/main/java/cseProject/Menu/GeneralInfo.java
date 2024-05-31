/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Menu;

import cseProject.Book.Rental.Rental_Manager;

/**
 *
 * @author 이승환
 */
public class GeneralInfo extends MenuItem {

    private MenuComponent allMenus;

    public GeneralInfo(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    @Override
    public void printMenu() {
        Rental_Manager.getInstance().showMyRentalInfo();
        allMenus.getChild(1).printMenu();
    }

}
