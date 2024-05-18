/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Forms.MainForm;

import cseProject.Login.User_Manager;
import cseProject.Helper.ProxyHelper;

/**
 *
 * @author 이승환
 */
public class General_Form_Behavior implements Main_Form_Behavior {

     private static final ProxyHelper helper = ProxyHelper.getInstance();

    @Override
    public void show_MainForm() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 도서 검색/대출/반납                         │");
        System.out.println("│ 2. 희망도서 신청                               │");
        System.out.println("│ 3. 내 정보 조회                                │");
        System.out.println("│ 4. 로그아웃                                    │");
        System.out.println("└────────────────────────┘");
        String choice = helper.getUserInput();
        switch (choice) {
            case "1" -> {
                System.out.println("도서 관련 탭.");
                show_BookForm();
            }
            case "2" -> {
                System.out.println("희망도서 신청 탭.");
                show_RequestingBook();
            }
            case "3" -> {
                System.out.println("내 정보 탭");
                show_MyInformation();
            }
            case "4" -> {
                System.out.println("로그아웃을 실행합니다");
                User_Manager.getInstance().userLogout();
            }
            default -> {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public void show_BookForm() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 도서 검색                                   │");
        System.out.println("│ 2. 도서 대출                                   │");
        System.out.println("│ 3. 도서 반납                                   │");
        System.out.println("│ 4. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");
        String choice = helper.getUserInput();
        if ("4".equals(choice)) {
            System.out.println("메인 화면으로 돌아갑니다");
            show_MainForm();
        }
    }

    public void show_RequestingBook() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 희망도서 신청                               │");
        System.out.println("│ 2. 희망도서 신청 현황                          │");
        System.out.println("│ 3. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");
        String choice = helper.getUserInput();
        if ("3".equals(choice)) {
            System.out.println("메인 화면으로 돌아갑니다");
            show_MainForm();
        }
    }

    public void show_MyInformation() {

    }
}
