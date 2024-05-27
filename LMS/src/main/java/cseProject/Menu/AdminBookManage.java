/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Menu;

import cseProject.Book.Book_Manager;
import cseProject.Helper.SystemHelper;

/**
 *
 * @author 이승환
 */
public class AdminBookManage extends MenuComponent {

    private MenuComponent allMenus;

    public AdminBookManage(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    @Override
    public void printMenu() {
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
            String choice = SystemHelper.getInstance().getUserInput();
            switch (choice) {
                case "1" -> {
                    System.out.println("도서 현황");
                    Book_Manager.getInstance().displayBooks();
                    allMenus.getChild(0).getChild(0).printMenu();
                    valid = true;
                }
                case "2" -> {
                    System.out.println("도서 검색");
                    Book_Manager.getInstance().showBooks(Book_Manager.getInstance().findBooksByAll());
                    allMenus.getChild(0).getChild(0).printMenu();
                    valid = true;

                }
                case "3" -> {
                    System.out.println("도서 등록");
                    Book_Manager.getInstance().makeBook();
                    allMenus.getChild(0).getChild(0).printMenu();
                    valid = true;
                }
                case "4" -> {
                    System.out.println("도서 정보 수정");
                    Book_Manager.getInstance().editBook(Book_Manager.getInstance().findBookByISBN());
                    allMenus.getChild(0).getChild(0).printMenu();
                    valid = true;
                }
                case "5" -> {
                    System.out.println("도서 삭제");
                    Book_Manager.getInstance().removeBook(Book_Manager.getInstance().findBookByISBN());
                    allMenus.getChild(0).getChild(0).printMenu();
                    valid = true;
                }
                case "6" -> {
                    System.out.println("이전 화면으로 돌아갑니다");
                    allMenus.getChild(0).printMenu();
                    valid = true;
                }
                default -> {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }

}
