/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseProject.Book;

import cseProject.SystemHelper;
import java.io.IOException;

/**
 *
 * @author 이승환
 */
public class BookTest {

    /**
     * @param args the command line arguments
     */
    private static SystemHelper helper = SystemHelper.getInstance();

    public static void main(String[] args) throws IOException{
        System.out.println("책 추가하기");
        String title = helper.getUserInput();
        String author = helper.getUserInput();
        String ISBN = helper.getUserInput();
    }

}
