/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.LoginState;

/**
 *
 * @author 이승환
 */
public class UserContext {

    private static UserContext instance;
    public LoginState state;

    // 외부에서 인스턴스를 생성하지 못하도록 private 생성자를 사용
    private UserContext() {
        state = new LoggedOutState();
    }

    // 인스턴스에 접근할 수 있는 public static 메서드
    public static UserContext getInstance() {
        if (instance == null) {
            instance = new UserContext();
        }
        return instance;
    }

    public void setState(LoginState state) {
        this.state = state;
    }

    public void login() {
        state.login(this); // 현재 상태 객체의 login 메서드 호출
        
    }

    public void logout() {
        state.logout(this); // 현재 상태 객체의 logout 메서드 호출
    }
}
