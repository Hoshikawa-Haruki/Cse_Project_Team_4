/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseProject;

import cseProject.FileManagerTemplate.FileManagerTemplate;
import cseProject.LoginState.UserContext;
import java.io.IOException;

/**
 *
 * @author 이승환
 */
public class MainDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
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
