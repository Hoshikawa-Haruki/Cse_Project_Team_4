/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Menu;

/**
 *
 * @author 이승환
 */
public class MenuBuilder {

    private static MenuComponent allMenus;

    private MenuBuilder() {
    }

    public static MenuComponent getInstance() {
        if (allMenus == null) {
            allMenus = buildAllMenus();
        }
        return allMenus;
    }

    public static MenuComponent buildAllMenus() {
        MenuComponent allMenus = new Menu; // 전체 메뉴

        // 관리자 메뉴 설정
        MenuComponent managerMenu = new AdminMain(allMenus); // 관리자의 컴포지트 노드 (하위메뉴 가능)
        MenuComponent bookManage = new AdminBookManage(allMenus); // 초기화면 -> 도서관리 (리프노드, 하위메뉴 X)
        MenuComponent userManage = new AdminUserManage(allMenus); // 초기화면 -> 이용자관리 (리프노드, 하위메뉴 X)

        allMenus.add(managerMenu); // allMenus.0 = 관리자 메뉴
        managerMenu.add(bookManage); // allMenus.0.1 = 도서 관리
        managerMenu.add(userManage); // allMenus.0.2 = 이용자 관리

        // 사용자 메뉴 설정
        MenuComponent generalMenu = new GeneralMain(allMenus); // 사용자의 컴포지트 노드 (하위메뉴 가능)
        MenuComponent generalBook = new GeneralBook(allMenus); // 리프노드
        MenuComponent generalInfo = new GeneralInfo(allMenus); // 리프노드

        allMenus.add(generalMenu); // allMenus.1 = 사용자 메뉴
        generalMenu.add(generalBook); // allMenus.1.1 = 도서 대여/반납
        generalMenu.add(generalInfo); // allMenus.1.2 = 내 정보 조회
        return allMenus;
    }
}
