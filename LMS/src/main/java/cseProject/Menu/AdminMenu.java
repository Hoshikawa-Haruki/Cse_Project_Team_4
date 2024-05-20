/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Menu;

/**
 *
 * @author 이승환
 */
public class AdminMenu extends Menu {

    public AdminMenu(String name, String description) {
        super(name, description);

        add(new MenuItem("────────────────────────", ""));
        add(new MenuItem("1. 도서 등록", "도서를 등록합니다."));
        add(new MenuItem("2. 도서 삭제", "도서를 삭제합니다."));
        add(new MenuItem("3. 이용자 관리", "이용자 정보를 관리합니다."));
        add(new MenuItem("4. 대여 관리", "대여 정보를 관리합니다."));
        add(new MenuItem("5. 로그아웃", "로그아웃합니다."));
        add(new MenuItem("────────────────────────", ""));
    }
    // 별로 안좋은 방법
}
