/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cseProject.Login.UserCreation;

import java.io.IOException;

/**
 *
 * @author 이승환
 */
public interface UserCreation_Behavior {

    void make_User(String newuserID, String newuserPW, String newuserName, boolean newisManager) throws IOException;
}
