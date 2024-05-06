/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Login;

/**
 *
 * @author 이승환
 */
public class User_Factory {

    public static User_Info createUser(User_Info userInfo) {
        return new User_Info(userInfo.getUserID(), userInfo.getUserPW(), userInfo.getUserName(), userInfo.getIsManager());
    }
}
