/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseProject;

import cseProject.Book.Book_Manager;
import cseProject.FileManagerTemplate.FileManagerTemplate;
import cseProject.Forms.Admin_Form;
import cseProject.Forms.Form;
import cseProject.Forms.General_Form;
import cseProject.LoginState.UserContext;
import java.io.IOException;

/**
 *
 * @author 이승환
 */
public class KangTestDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here 
//        Form form;
//        int select = 0;
//
//        if (select == 0) {
//            form = new Admin_Form();
//        } else {
//            form = new General_Form();
//        }
//        form.perform_Main();

        // User file manager
        FileManagerTemplate.getInstance("User").createDBFile("User_Info.txt");
        FileManagerTemplate.getInstance("User").createDB("User_Info.txt");

        // Book file manager
        FileManagerTemplate.getInstance("Book").createDBFile("Book_Info.txt");
        FileManagerTemplate.getInstance("Book").createDB("Book_Info.txt");

        // Rental file manager
        FileManagerTemplate.getInstance("Rental").createDBFile("Rental_Info.txt");
        FileManagerTemplate.getInstance("Rental").createDB("Rental_Info.txt");

        UserContext ctx = UserContext.getInstance();
        ctx.login();

    }
}
