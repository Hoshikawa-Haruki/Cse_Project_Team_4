/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Forms.MainForm;

/**
 *
 * @author 이승환
 */
import cseProject.SystemHelper;

public class Admin_Form_Behavior implements Main_Form_Behavior {

    private static SystemHelper helper = SystemHelper.getInstance();

    @Override
    public void show_MainForm() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 도서 현황/검색/등록/수정                    │");
        System.out.println("│ 2. 희망도서 조회                               │ ");
        System.out.println("│ 3. 이용자 관리                                 │");
        System.out.println("│ 4. 도서관 관리                                 │");
        System.out.println("└────────────────────────┘");

        String choice = helper.getUserInput();
        switch (choice) {
            case "1" -> {
                System.out.println("도서 관련 탭.");
                show_BookManageForm();
            }
            case "2" -> {
                System.out.println("희망도서 조회 탭.");
                show_RequestList();
            }
            case "3" -> {
                System.out.println("이용자 관리 탭");
                show_UserManageForm();
            }
            case "4" -> {
                System.out.println("도서관 관리 탭");
                show_LibraryManageForm();
            }
            default -> {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public void show_BookManageForm() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 도서 현황                                   │");
        System.out.println("│ 2. 도서 검색                                   │");
        System.out.println("│ 3. 도서 등록                                   │");
        System.out.println("│ 4. 도서 정보 수정                              │");
        System.out.println("│ 5. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");
        String choice = helper.getUserInput();
        if ("5".equals(choice)) {
            System.out.println("메인 화면으로 돌아갑니다");
            show_MainForm();
        }
    }

    public void show_RequestList() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 희망도서 신청 현황                          │");
        System.out.println("│ 2. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");
        String choice = helper.getUserInput();
        if ("2".equals(choice)) {
            System.out.println("메인 화면으로 돌아갑니다");
            show_MainForm();
        }
    }

    public void show_UserManageForm() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 이용자 현황                                 │");
        System.out.println("│ 2. 이용자 검색                                 │");
        System.out.println("│ 3. 이용자 삭제                                 │");
        System.out.println("│ 4. 이용자 정보 수정                            │");
        System.out.println("│ 5. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");
        String choice = helper.getUserInput();
        if ("3".equals(choice)) {
            System.out.println("메인 화면으로 돌아갑니다");
            show_MainForm();
        }
    }

    public void show_LibraryManageForm() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 회원가입 현황                               │");
        System.out.println("│ 2. 연체료 납부 현황                            │");
        System.out.println("│ 3. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");
        String choice = helper.getUserInput();
        if ("3".equals(choice)) {
            System.out.println("메인 화면으로 돌아갑니다");
            show_MainForm();
        }
    }
}