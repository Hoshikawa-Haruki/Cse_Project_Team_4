/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Forms;

import cseProject.Login.LoginSystem;
import cseProject.LoginState.UserContext;
import cseProject.Helper.ProxyHelper;
import cseProject.Login.UserCreation.UserCreation_Behavior;
import java.io.IOException;

/**
 *
 * @author 이승환
 */
public class Landing_Form { // 초기화면

    private static final ProxyHelper helper = ProxyHelper.getInstance();

    public void show_LandingForm() throws IOException {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 로그인                                      │");
        System.out.println("│ 2. 회원가입                                    │ ");
        System.out.println("│ 3. 종료                                        │ ");
        System.out.println("└────────────────────────┘");

        String choice = helper.getUserInput();
        UserContext ctx = UserContext.getInstance();
        switch (choice) {
            case "1" -> {
                LoginSystem.getInstance().try_Login();

                ctx.login();
            }
            case "2" -> {
                LoginSystem.getInstance().runLoginSystem();
                show_LandingForm();
            }
        }
    }
}
