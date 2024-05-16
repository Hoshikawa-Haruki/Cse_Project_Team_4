/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.LoginState;

import cseProject.Forms.Landing_Form;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 이승환
 */
public class LoggedOutState implements LoginState {

    @Override
    public void login(UserContext context) {
        Landing_Form form = new Landing_Form();
        try {
            form.show_LandingForm();
        } catch (IOException ex) {
            System.out.println("잘못된 입력입니다");
        }
        context.setState(new LoggedInState());
    }

    @Override
    public void logout(UserContext context) {
        System.out.println("이미 로그아웃 상태입니다.");
    }
}
