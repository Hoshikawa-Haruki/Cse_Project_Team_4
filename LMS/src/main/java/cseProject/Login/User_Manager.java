/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Login;


import cseProject.FileManagerTemplate.FileManagerTemplate;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 이승환
 */
public class User_Manager {

    private static User_Manager instance; // 싱글턴
    private ArrayList<User_Info> userDB = new ArrayList<>(); // 유저DB
    private User_Info loginUser; // 현재 로그인 유저

    private User_Manager() {
    }

    public static User_Manager getInstance() {
        if (instance == null) {
            instance = new User_Manager();
        }
        return instance;
    }

    // user_MemberShip : 로그인시스템에서 정보 받음 -> 전략패턴 실행 -> 전략패턴에서 addUser 실행 -> 생성한 객체를 add_userDB에 넘겨줌, 여기 매개변수 이름이 user_MemberShip
    public void add_userDB(User_Info user_MemberShip) throws IOException {
        userDB.add(user_MemberShip);
        FileManagerTemplate.getInstance("User").writeDBFile("User_Info.txt");
    }

    public void setUserDB(ArrayList<User_Info> userDB) {
        this.userDB = userDB;
    }

    public void setLoginUser(User_Info loginUser) {
        this.loginUser = loginUser;
    }

    public User_Info getLoginUser() {
        return loginUser;
    }

    public ArrayList<User_Info> getUserDB() {
        return userDB;
    }

    public void userLogout() {
        loginUser = null;

    }
}
