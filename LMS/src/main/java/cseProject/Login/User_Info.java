/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Login;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 이승환
 */
public class User_Info {

    private String userID;
    private String userPW;
    private String userName;
    private boolean isManager;
    private String registeredDate;
    
    LocalDateTime now;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  

    public User_Info(String userID, String userPW, String userName, boolean isManager) { // 회원가입 시 사용
        this.userID = userID;
        this.userPW = userPW;
        this.userName = userName;
        this.isManager = isManager;
        now = LocalDateTime.now(); 
        this.registeredDate = now.format(formatter);
    }
    
    public User_Info(String userID, String userPW, String userName, boolean isManager, String time) { // 파일 읽어올때 사용
        this.userID = userID;
        this.userPW = userPW;
        this.userName = userName;
        this.isManager = isManager;
        this.registeredDate = time;
    }

    public User_Info(String userID, String userPW, String userName) { // 안쓰임
        this(userID, userPW, userName, false);
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPW() {
        return userPW;
    }

    public String getUserName() {
        return userName;
    }

    public boolean getIsManager() {
        return isManager;
    }
    
    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserPW(String userPW) {
        this.userPW = userPW;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }
}
