/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Forms.MainForm;

/**
 *
 * @author 이승환
 */
public class Admin_Form_Behavior implements Main_Form_Behavior {

    @Override
    public void show_MainForm() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 도서 검색/등록/수정                         │");
        System.out.println("│ 2. 희망도서 조회                               │ ");
        System.out.println("│ 3. 이용자 관리                                 │");
        System.out.println("│ 4. 도서관 관리                                 │");
        System.out.println("└────────────────────────┘");
    }
}
