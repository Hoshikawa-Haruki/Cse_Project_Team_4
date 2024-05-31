/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Forms.MainForm;

/**
 *
 * @author 이승환
 */
import cseProject.Helper.SystemHelper;
import cseProject.Menu.MenuBuilder;
import cseProject.Menu.MenuComponent;

public class Admin_Form_Behavior implements Main_Form_Behavior {

    private static final SystemHelper helper = SystemHelper.getInstance();
    private MenuComponent allMenus;

    public Admin_Form_Behavior() {
        this.allMenus = MenuBuilder.getInstance();
    }

    @Override
    public void show_MainForm() {
        allMenus.getChild(0).printMenu();
    }

//    public void showBookManageForm() {
//        System.out.println("┌────────────────────────┐");
//        System.out.println("│ 1. 도서 현황                                   │");
//        System.out.println("│ 2. 도서 검색                                   │");
//        System.out.println("│ 3. 도서 등록                                   │");
//        System.out.println("│ 4. 도서 정보 수정                              │");
//        System.out.println("│ 5. 도서 삭제                                   │");
//        System.out.println("│ 6. 돌아가기                                    │");
//        System.out.println("└────────────────────────┘");
//        boolean valid = false;
//        while (!valid) {
//            String choice = helper.getUserInput();
//            switch (choice) {
//                case "1" -> {
//                    System.out.println("도서 현황");
//                    Book_Manager.getInstance().displayBooks();
//                    showBookManageForm();
//                    valid = true;
//                }
//                case "2" -> {
//                    System.out.println("도서 검색");
//                    Book_Manager.getInstance().showBooks(Book_Manager.getInstance().findBooksByAll());
//                    showBookManageForm();
//                    valid = true;
//                }
//                case "3" -> {
//                    System.out.println("도서 등록");
//                    Book_Manager.getInstance().makeBook();
//                    showBookManageForm();
//                    valid = true;
//                }
//                case "4" -> {
//                    System.out.println("도서 정보 수정");
//                    Book_Manager.getInstance().editBook(Book_Manager.getInstance().findBookByISBN());
//                    showBookManageForm();
//                    valid = true;
//                }
//                case "5" -> {
//                    System.out.println("도서 삭제");
//                    Book_Manager.getInstance().removeBook(Book_Manager.getInstance().findBookByISBN());
//                    showBookManageForm();
//                    valid = true;
//                }
//                case "6" -> {
//                    System.out.println("이전 화면으로 돌아갑니다");
//                    show_MainForm();
//                    valid = true;
//                }
//                default -> {
//                    System.out.println("잘못된 입력입니다.");
//                }
//            }
//        }
//    }
//    public void showUserManageForm() {
//        System.out.println("┌────────────────────────┐");
//        System.out.println("│ 1. 이용자 현황                                 │");
//        System.out.println("│ 2. 이용자 검색                                 │");
//        System.out.println("│ 3. 이용자 정보 수정                            │");
//        System.out.println("│ 4. 이용자 별 대출현황                          │");
//        System.out.println("│ 5. 돌아가기                                    │");
//        System.out.println("└────────────────────────┘");
//
//        boolean valid = false;
//        while (!valid) {
//            String choice = helper.getUserInput();
//            switch (choice) {
//                case "1" -> {
//                    System.out.println("이용자 현황");
//                    invoker.executeCommand("inspect");
//                    showUserManageForm();
//                    valid = true;
//                }
//                case "2" -> {
//                    System.out.println("이용자 검색");
//                    invoker.executeCommand("search");
//                    showUserManageForm();
//                    valid = true;
//                }
//                case "3" -> {
//                    System.out.println("이용자 정보 수정");
//                    invoker.executeCommand("modify");
//                    showUserManageForm();
//                    valid = true;
//                }
//                case "4" -> {
//                    System.out.println("이용자 별 대출 현황");
//                    Rental_Manager.getInstance().showAllRentalInfo();
//                    valid = true;
//                    showUserManageForm();
//                }
//                case "5" -> {
//                    System.out.println("이전 화면으로 돌아갑니다");
//                    show_MainForm();
//                    valid = true;
//                }
//                default -> {
//                    System.out.println("잘못된 입력입니다.");
//                }
//            }
//        }
//    }
}
