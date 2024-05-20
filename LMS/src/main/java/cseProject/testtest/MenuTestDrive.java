/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.testtest;

/**
 *
 * @author 이승환
 */
public class MenuTestDrive {

    public static void main(String[] args) {
        // 메뉴 객체들 생성
        MenuComponent allMenus = new Menu("전체 메뉴", "전체 메뉴 선택");
        MenuComponent managerMenu = new Menu("관리자 메뉴", "관리자 메뉴 선택");
        MenuComponent generalMenu = new Menu("이용자 메뉴", "이용자 메뉴 선택");
        MenuComponent bookManage = new Menu("도서 관리 메뉴", "관리자 메뉴 속 도서 메뉴 입니다");

        // 전체 메뉴에 각 메뉴 추가
        allMenus.add(managerMenu);
        allMenus.add(generalMenu);

        // 관리자 메뉴에 메뉴 추가
        managerMenu.add(new MenuItem("도서 등록/삭제/수정", "도서관련탭"));
        managerMenu.add(bookManage);

        // 메뉴 속 메뉴에 메뉴 항목 생성
        bookManage.add(new MenuItem("도서 등록", "등록 관련 탭"));
        bookManage.add(new MenuItem("도서 삭제", "삭제 관련 탭"));

        // 전체 메뉴 출력
        //allMenus.print();
        //        // 특정 조건에 맞는 메뉴만 출력 (예: '관리자 메뉴'와 관련된 항목)
        //        System.out.println("\n조건에 맞는 메뉴 (관리자):");
        //        allMenus.print("", "관리자");
        allMenus.print("", "관리자");
    }
}
