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
import cseProject.Menu.AdminBookManage;
import cseProject.Menu.AdminMain;
import cseProject.Menu.AdminUserManage;
import cseProject.Menu.Menu;
import cseProject.Menu.MenuBuilder;
import cseProject.Menu.MenuComponent;
import cseProject.UsermanagementFunction.command.UserManagementInvoker;

public class Admin_Form_Behavior implements Main_Form_Behavior {

    private static final SystemHelper helper = SystemHelper.getInstance();
    private MenuComponent allMenus;

    public Admin_Form_Behavior() {
        this.allMenus = MenuBuilder.getInstance();
    }

    @Override
    public void show_MainForm() {
//        MenuComponent allMenus = new Menu(); // 컴포지트 노드 (하위메뉴 가능)
//        MenuComponent managerMenu = new AdminMain(allMenus); // 컴포지트 노드 (하위메뉴 가능)
//        MenuComponent bookManage = new AdminBookManage(allMenus); // 초기화면 -> 도서관리 (리프노드, 하위메뉴 X)
//        MenuComponent userManage = new AdminUserManage(allMenus); // 초기화면 -> 이용자관리 (리프노드, 하위메뉴 X)
//
//        allMenus.add(managerMenu); // allMenus.0 = 관리자 메뉴
//        managerMenu.add(bookManage); // allMenus.0.1 = 도서 관리
//        managerMenu.add(userManage); // allMenus.0.2 = 이용자 관리
//        managerMenu.printMenu();
        allMenus.getChild(0).printMenu();
    }

    public void showBookManageForm() {
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
    }

    public void showUserManageForm() {
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
    }

}
