/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseProject;

import cseProject.Forms.Admin_Form;
import cseProject.Forms.Form;
import cseProject.Forms.General_Form;

/**
 *
 * @author 이승환
 */
public class KangTestDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Form form;
        int select = 0;

        if (select == 0) {
            form = new Admin_Form();
        } else {
            form = new General_Form();
        }
        form.perform_Main();
    }
}
