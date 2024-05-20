/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseProject.Menu;

/**
 *
 * @author 이승환
 */
public class MenuTestDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MenuComponent allMenus = new Menu("전체 메뉴", "전체 메뉴 선택");
        MenuComponent managerMenu = new Menu("관리자 메뉴", "관리자 메뉴 선택");
        MenuComponent generalMenu = new Menu("이용자 메뉴", "이용자 메뉴 선택");
        MenuComponent bookManage = new Menu("도서 관리 메뉴", "관리자 메뉴 속 도서 메뉴 입니다");
        //메뉴 객체들 생성

        allMenus.add(managerMenu);
        allMenus.add(generalMenu);
        // 전체 메뉴에 각 메뉴 추가

        managerMenu.add(new MenuItem("도서 등록/삭제/수정", "도서관련탭"));
        // 관리자 메뉴에 메뉴 추가
        managerMenu.add(bookManage);
        // 관리자 메뉴 속 메뉴 추가

        bookManage.add(new MenuItem("도서 등록", "등록 관련 탭"));
        bookManage.add(new MenuItem("도서 삭제", "삭제 관련 탭"));
        //메뉴 속 메뉴에 메뉴 항목 생성
//        MenuComponent adminMenu = new AdminMenu("관리자 메뉴", "관리자 관련 메뉴 선택");
//        mainMenu.add(adminMenu);

        allMenus.print();
        managerMenu.print();
        bookManage.print();

    }

}
