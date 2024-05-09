/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Login.UserCreation;

import cseProject.Login.User_Info;
import cseProject.Login.User_Manager;
import cseProject.SystemHelper;
import java.io.IOException;

/**
 *
 * @author 이승환
 */
public class Admin_UserCreation_Behavior implements UserCreation_Behavior {

    private SystemHelper helper = SystemHelper.getInstance();
    private User_Manager userManager = User_Manager.getInstance();

    @Override
    public void make_User(String newAdminID, String newAdminPW, String newAdminName, boolean newisManager) throws IOException {
        System.out.print("관리자 코드를 입력하세요:");
        String AdminCode = helper.getUserInput();
        if (!AdminCode.equals("admin1111")) {
            System.out.println("올바르지 않은 관리자 코드입니다. 회원가입을 취소합니다.");
            return; // 메서드를 즉시 종료하고 호출자로 반환
        } else {
            User_Info newAdmin = new User_Info(newAdminID, newAdminPW, newAdminName, true); // 로그인 시스템에서 받은 정보를 객체로 생성
            User_Manager.getInstance().add_userDB(newAdmin);
            System.out.println("관리자 회원가입이 완료되었습니다.");
        }
    }
}
