/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Menu;

import cseProject.Helper.SystemHelper;
import cseProject.Book.Rental.Rental_Manager;
import cseProject.UsermanagementFunction.command.UserManagementInvoker;

/**
 *
 * @author 이승환
 */
public class AdminUserManage extends MenuItem { // 리프노드

    UserManagementInvoker invoker = new UserManagementInvoker();
    private MenuComponent allMenus;

    public AdminUserManage(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    @Override
    public void printMenu() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 이용자 현황                                 │");
        System.out.println("│ 2. 이용자 검색                                 │");
        System.out.println("│ 3. 이용자 정보 수정/삭제                       │");
        System.out.println("│ 4. 이용자 별 대출현황                          │");
        System.out.println("│ 5. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");

        boolean valid = false;
        while (!valid) {
            String choice = SystemHelper.getInstance().getUserInput();
            switch (choice) {
                case "1" -> {
                    System.out.println("이용자 현황");
                    invoker.executeCommand("inspect");
                    this.printMenu();
                    valid = true;
                }
                case "2" -> {
                    System.out.println("이용자 검색");
                    invoker.executeCommand("search");
                    this.printMenu();
                    valid = true;
                }
                case "3" -> {
                    System.out.println("이용자 정보 수정/삭제");
                    invoker.executeCommand("modify");
                    this.printMenu();
                    valid = true;
                }
                case "4" -> {
                    System.out.println("이용자 별 대출 현황");
                    Rental_Manager.getInstance().showAllRentalInfo();
                    valid = true;
                    this.printMenu();
                }
                case "5" -> {
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
