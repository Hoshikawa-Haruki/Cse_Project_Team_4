/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Login;

/**
 *
 * @author 이승환
 */
public class User_Info {

    private String userID;
    private String userPW;
    private String userName;
    private boolean isManager;

    public User_Info(String userID, String userPW, String userName, boolean isManager) {
        this.userID = userID;
        this.userPW = userPW;
        this.userName = userName;
        this.isManager = isManager;
    }

    public User_Info(String userID, String userPW, String userName) {
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
