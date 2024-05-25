/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Forms.MainForm;

/**
 *
 * @author 이승환
 */
import cseProject.Book.Book_Manager;
import cseProject.LoginState.UserContext;
import cseProject.Helper.ProxyHelper;

public class Admin_Form_Behavior implements Main_Form_Behavior {

    private static final ProxyHelper helper = ProxyHelper.getInstance();

    @Override
    public void show_MainForm() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 도서 현황/검색/등록/수정                    │");
        System.out.println("│ 2. 희망도서 조회                               │ ");
        System.out.println("│ 3. 이용자 관리                                 │");
        System.out.println("│ 4. 도서관 관리                                 │");
        System.out.println("│ 5. 로그아웃                                    │");
        System.out.println("└────────────────────────┘");

        boolean valid = false;
        while (!valid) {
            String choice = helper.getUserInput();
            switch (choice) {
                case "1" -> {
                    System.out.println("도서 관련 탭.");
                    showBookManageForm();
                    valid = true;
                }
                case "2" -> {
                    System.out.println("희망도서 조회 탭.");
                    showRequestList();
                    valid = true;
                }
                case "3" -> {
                    System.out.println("이용자 관리 탭");
                    showUserManageForm();
                    valid = true;
                }
                case "4" -> {
                    System.out.println("도서관 관리 탭");
                    showLibraryManageForm();
                    valid = true;
                }
                case "5" -> {
                    System.out.println("로그아웃을 실행합니다");
                    UserContext.getInstance().logout();
                    valid = true;
                }
                default -> {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }

    public void showBookManageForm() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 도서 현황                                   │");
        System.out.println("│ 2. 도서 검색                                   │");
        System.out.println("│ 3. 도서 등록                                   │");
        System.out.println("│ 4. 도서 정보 수정                              │");
        System.out.println("│ 5. 도서 삭제                                   │");
        System.out.println("│ 6. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");
        boolean valid = false;
        while (!valid) {
            String choice = helper.getUserInput();
            switch (choice) {
                case "1" -> {
                    System.out.println("도서 현황");
                    Book_Manager.getInstance().displayBooks();
                    showBookManageForm();
                    // todo
                    valid = true;
                }
                case "2" -> {
                    System.out.println("도서 검색");
                    // todo
                    Book_Manager.getInstance().showBooks(Book_Manager.getInstance().findBooksByAll());
                    showBookManageForm();
                    valid = true;
                }
                case "3" -> {
                    System.out.println("도서 등록");
                    // todo
                    Book_Manager.getInstance().makeBook();
                    showBookManageForm();
                    valid = true;
                }
                case "4" -> {
                    System.out.println("도서 정보 수정");
                    // todo
                    //Book_Manager.getInstance().editBook();
                    Book_Manager.getInstance().editBook(Book_Manager.getInstance().findBookByISBN());
                    showBookManageForm();
                    valid = true;
                }
                case "5" -> {
                    Book_Manager.getInstance().removeBook(Book_Manager.getInstance().findBookByISBN());
                    showBookManageForm();
                    valid = true;
                }
                case "6" -> {
                    System.out.println("이전 화면으로 돌아갑니다");
                    show_MainForm();
                    valid = true;
                }
                default -> {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }

    public void showRequestList() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 희망도서 신청 현황                          │");
        System.out.println("│ 2. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");
        String choice = helper.getUserInput();
        if ("2".equals(choice)) {
            System.out.println("이전 화면으로 돌아갑니다");
            show_MainForm();
        }
    }

    public void showUserManageForm() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 이용자 현황                                 │");
        System.out.println("│ 2. 이용자 검색                                 │");
        System.out.println("│ 3. 이용자 삭제                                 │");
        System.out.println("│ 4. 이용자 정보 수정                            │");
        System.out.println("│ 6. 이용자 별 대출현황                          │");
        System.out.println("│ 5. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");
        String choice = helper.getUserInput();
        if ("5".equals(choice)) {
            System.out.println("이전 화면으로 돌아갑니다");
            show_MainForm();
        }
    }

    public void showLibraryManageForm() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 회원가입 현황                               │");
        System.out.println("│ 2. 연체료 납부 현황                            │");
        System.out.println("│ 3. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");
        String choice = helper.getUserInput();
        if ("3".equals(choice)) {
            System.out.println("이전 화면으로 돌아갑니다");
            show_MainForm();
        }
    }
}
