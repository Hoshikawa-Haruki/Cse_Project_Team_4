package cseProject.Login;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import cseProject.Forms.Admin_Form;
import cseProject.Forms.Form;
import cseProject.Forms.General_Form;
import cseProject.Helper.ProxyHelper;
import cseProject.LoginState.LoggedInState;
import cseProject.LoginState.UserContext;
import java.io.IOException;

/**
 *
 * @author 이승환
 */
public class LoginSystem {

    private static LoginSystem instance;
    private static final ProxyHelper helper = ProxyHelper.getInstance();
    private static User_Manager manager = User_Manager.getInstance();

    // 생성자를 private으로 선언하여 외부에서 인스턴스화 방지
    private LoginSystem() {
        // Private 생성자
    }

    public static LoginSystem getInstance() {
        if (instance == null) {
            instance = new LoginSystem();
        }
        return instance;
    }

    public void try_Login() throws IOException {
        do {
            System.out.print("ID : ");
            String ID = helper.getUserInput();
            System.out.print("PW : ");
            String PW = helper.getUserInput();

            for (User_Info check_user : manager.getUserDB()) {
                if (check_user.getUserID().equals(ID) && check_user.getUserPW().equals(PW)) {
                    manager.setLoginUser(check_user); // 현재 로그인 객체 유저로 반환
                    System.out.println("로그인 성공.");
                    if (check_user.getIsManager()) {
                        System.out.println("안녕하세요 " + manager.getLoginUser().getUserName() + " 관리자님");
                    } else {
                        System.out.println("안녕하세요 " + manager.getLoginUser().getUserName() + " 님");
                    }
                    break;
                }
            }
            UserContext ctx = UserContext.getInstance();
            ctx.setState(new LoggedInState()); // 여기서 로그인 상태로 변경해줌 (상태패턴)

            if (manager.getLoginUser() == null) {
                System.out.println("로그인 정보를 찾을 수 없습니다.");
            }
        } while (manager.getLoginUser() == null);
    }

    public void runLoginSystem() throws IOException {

        System.out.println("1. 관리자 가입, 2. 이용자 가입");
        String choice = helper.getUserInput();
        Form form = null;
        switch (choice) {
            case "1" -> {
                System.out.println("관리자 회원가입을 시작합니다.");
                form = new Admin_Form();
            }
            case "2" -> {
                System.out.println("이용자 회원가입을 시작합니다.");
                form = new General_Form();
            }
            default ->
                System.out.println("잘못된 입력입니다.");
        }
        if (form != null) {
            form.perform_Register();
        }
    }
}
