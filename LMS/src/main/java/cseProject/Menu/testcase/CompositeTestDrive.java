/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseProject.Menu.testcase;

import cseProject.Menu.AdminBookManage;
import cseProject.Menu.AdminMain;
import cseProject.Menu.AdminUserManage;
import cseProject.Menu.Menu;
import cseProject.Menu.MenuComponent;

/**
 *
 * @author 이승환
 */
public class CompositeTestDrive { // 컴포지트 테스트 코드

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuComponent allMenus = new Menu(); // 얘는 컴포지트 노드 (하위메뉴 가능)
        MenuComponent managerMenu = new AdminMain(allMenus); // 관리자 초기 화면(여기 안에 도서관리와 이용자 관리가 있음)
        MenuComponent bookManage = new AdminBookManage(allMenus); // 초기화면 -> 도서관리 (리프노드, 하위메뉴 X)
        MenuComponent userManage = new AdminUserManage(allMenus); // 초기화면 -> 이용자관리 (리프노드, 하위메뉴 X)
        allMenus.add(managerMenu);
        managerMenu.add(bookManage);
        managerMenu.add(userManage);
        allMenus.printMenu();

        //allMenus.getChild(0).getChild(1).printMenu();
    }

}
