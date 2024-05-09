/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Login.UserCreation;

import cseProject.Login.User_Info;
import cseProject.Login.User_Manager;

/**
 *
 * @author 이승환
 */

public class General_UserCreation_Behavior implements UserCreation_Behavior {

    @Override
    public void make_User(String newuserID, String newuserPW, String newuserName, boolean newisManager) {
        User_Info newGeneral = new User_Info(newuserID, newuserPW, newuserName, false); // 로그인 시스템에서 받은 정보를 객체로 생성
        User_Manager.getInstance().add_userDB(newGeneral);
        System.out.println("일반 이용자 회원가입이 완료되었습니다.");
    }

}
