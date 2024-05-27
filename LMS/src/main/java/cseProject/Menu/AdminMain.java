/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Menu;

import cseProject.Helper.SystemHelper;
import cseProject.LoginState.UserContext;

/**
 *
 * @author 이승환
 */
public class AdminMain extends Menu {

    private MenuComponent allMenus;

    public AdminMain(MenuComponent allMenus) {
        //super("1. 관리자 메뉴");
        this.allMenus = allMenus;
    }

    @Override
    public void printMenu() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 도서 현황/검색/등록/수정                    │");
        System.out.println("│ 2. 이용자 관리                                 │");
        System.out.println("│ 3. 로그아웃                                    │");
        System.out.println("└────────────────────────┘");

        boolean valid = false;
        while (!valid) {
            String choice = SystemHelper.getInstance().getUserInput();
            switch (choice) {
                case "1" -> {
                    System.out.println("도서 관련 탭.");
                    allMenus.getChild(0).getChild(0).printMenu();
                    valid = true;
                }
                case "2" -> {
                    System.out.println("이용자 관리 탭");
                    allMenus.getChild(0).getChild(1).printMenu();
                    valid = true;
                }
                case "3" -> {
                    UserContext.getInstance().logout();
                    valid = true;
                }
                default -> {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }

}
