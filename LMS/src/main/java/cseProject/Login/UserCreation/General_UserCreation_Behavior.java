/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Login.UserCreation;

import cseProject.Login.User_Info;
import cseProject.Login.User_Manager;
import cseProject.SystemHelper;

/**
 *
 * @author 이승환
 */
public class General_UserCreation_Behavior implements UserCreation_Behavior {

    private static SystemHelper helper = SystemHelper.getInstance();
    private static User_Manager manager = User_Manager.getInstance();

    @Override
    public void make_User() {
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

        User_Info newGeneral = new User_Info(newID, newPW, newName, false); // 로그인 시스템에서 받은 정보를 객체로 생성

        User_Manager.getInstance().add_userDB(newGeneral);
        System.out.println("일반 이용자 회원가입이 완료되었습니다.");

    }
}
