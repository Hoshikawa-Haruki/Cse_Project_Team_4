/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.LoginState;

import cseProject.Forms.Admin_Form;
import cseProject.Forms.Factory.ConcreteFormFactory;
import cseProject.Forms.Factory.FormFactory;
import cseProject.Forms.Form;
import cseProject.Login.User_Manager;

/**
 *
 * @author 이승환
 */
public class LoggedInState implements LoginState {

    @Override
    public void login(UserContext context) {
        System.out.println("로그인 되었습니다.");
        FormFactory ff = new ConcreteFormFactory();
        try {
            boolean isManager = User_Manager.getInstance().getLoginUser().getIsManager();
            Form form = ff.create(isManager);  // 팩토리메서드로 객체 생성
            form.perform_Main(); // 전략에 따른 실행
        } catch (NullPointerException a) {
            System.out.println("널포인트 에러!! 프로그램을 종료합니다.");
            System.out.println("에러 사유 : 해당되는 이용자 또는 도서가 없습니다.");
        }
    }

    @Override
    public void logout(UserContext context) {
        System.out.println("로그아웃 되었습니다.");
        User_Manager.getInstance().userLogout();
        context.setState(new LoggedOutState());
        context.login();
    }
}
