/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.LoginState;

import cseProject.Forms.Admin_Form;
import cseProject.Forms.Form;
import cseProject.Forms.General_Form;
import cseProject.Login.User_Manager;

/**
 *
 * @author 이승환
 */
public class LoggedInState implements LoginState {

    @Override
    public void login(UserContext context) {
        System.out.println("이미 로그인 상태 입니다");
        Form form;
        try{
        if (User_Manager.getInstance().getLoginUser().getIsManager() == false) {
            form = new General_Form();
        } else {
            form = new Admin_Form();
        }
        form.perform_Main();
        } catch(NullPointerException a){
            System.out.println("널포인트");
        }
    }

    @Override
    public void logout(UserContext context) {
        System.out.println("로그아웃 되었습니다.");
        User_Manager.getInstance().userLogout();
        context.setState(new LoggedOutState());
    }   
}
