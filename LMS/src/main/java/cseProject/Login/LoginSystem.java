package cseProject.Login;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import cseProject.Forms.Admin_Form;
import cseProject.Forms.Form;
import cseProject.Forms.General_Form;
import cseProject.Login.UserCreation.General_UserCreation_Behavior;
import cseProject.Login.UserCreation.Admin_UserCreation_Behavior;
import cseProject.SystemHelper;
import java.io.IOException;

/**
 *
 * @author 이승환
 */
public class LoginSystem {

    private static LoginSystem instance;
    private static SystemHelper helper = SystemHelper.getInstance();
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

    public void make_ID() throws IOException {
        String newID;
        boolean isExist;
        do {
            isExist = false;
            System.out.println("생성 할 ID를 입력하세요");
            System.out.print("ID : ");
            newID = helper.getUserInput();
            if (newID.length() < 4) {
                System.out.println("ID는 4자리 이상 입력해주세요.");
                System.out.println("다시 입력해주세요.");
                isExist = true;
            } else {
                for (User_Info check_user_ID : manager.getUserDB()) {
                    if (check_user_ID.getUserID().equals(newID)) {
                        System.out.println("이미 존재하는 아이디 입니다. 다른 아이디를 입력하세요");
                        isExist = true;
                        break;
                    }
                }
            }
        } while (isExist);

        String newPW;
        do {
            System.out.println("생성 할 PW를 입력하세요");
            System.out.print("PW : ");
            newPW = helper.getUserInput();
            if (newPW.length() < 4) {
                System.out.println("PW는 4자리 이상 입력해주세요.");
                System.out.println("다시 입력해주세요.");
            }
        } while (newPW.length() < 4);

        System.out.println("이름을 입력하세요");
        System.out.print("이름 : ");
        String newName = helper.getUserInput();

        // 관리자로 가입하는 기능 추가
        System.out.println("관리자로 가입하시겠습니까? (y/n)");
        String isManagerChoice = helper.getUserInput();
        boolean newisManager = isManagerChoice.equalsIgnoreCase("y");

        if (newisManager) {
            // 관리자 전략을 사용하여 가입 처리
            Admin_UserCreation_Behavior adminStrategy = new Admin_UserCreation_Behavior();
            adminStrategy.make_User(newID, newPW, newName, newisManager);
        } else {
            // 일반 사용자 전략을 사용하여 가입 처리
            General_UserCreation_Behavior generalStrategy = new General_UserCreation_Behavior();
            generalStrategy.make_User(newID, newPW, newName, newisManager);
        }

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
            if (manager.getLoginUser() == null) {
                System.out.println("로그인 정보를 찾을 수 없습니다.");
            }
        } while (manager.getLoginUser() == null);
    }

    public User_Info runLoginSystem() throws IOException {
        //init();
        while (true) {
            //System.out.println("1. 회원가입, 2. 로그인");
            System.out.println("1. 관리자, 2. 사용자");
            String choice = helper.getUserInput();
            Form form = null;

            switch (choice) {
                case "1" -> {
                    //System.out.println("회원가입을 시작합니다.");
                    //make_ID();
                    form = new Admin_Form();
                }
                case "2" -> {
                    //System.out.println("로그인을 시도합니다.");
                    //try_Login();
                    form = new General_Form();
                }
                default ->
                    System.out.println("잘못된 입력입니다.");
            }
            if(form != null)
                form.perform_Main();
            // 회원가입 또는 로그인 후에도 다시 while 루프를 돌기 위해 루프 조건을 유지
            // 로그인에 성공했을 때만 루프를 빠져나옴
            if (manager.getLoginUser() != null) {
                break;
            }
        }
        return manager.getLoginUser();
    }
}
