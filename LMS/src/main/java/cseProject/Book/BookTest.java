/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseProject.Book;

import cseProject.Helper.RealSystemHelper;
import java.io.IOException;

/**
 *
 * @author 이승환
 */
public class BookTest {

    /**
     * @param args the command line arguments
     */
    private static RealSystemHelper helper = RealSystemHelper.getInstance();

    public static void main(String[] args) throws IOException {
        
        Book_Manager manager = new Book_Manager();
        while (true) {
            String choice = helper.getUserInput();
            if ("1".equals(choice)) {
                manager.make_Book();
            }
            else{
                manager.displayBooks();
            }
        }
    }
}
