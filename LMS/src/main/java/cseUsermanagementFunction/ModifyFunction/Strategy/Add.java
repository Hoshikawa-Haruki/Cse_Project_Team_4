/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.ModifyFunction.Strategy;

import cseProject.FileManager;
import cseProject.Login.User_Info;



/**
 *
 * @author jasuj
 */
public class Add extends ModifyBehaviorTemplet {

    public void modify() {
        String[] UserTemp = new String[4];
        System.out.println("아이디: ");
        UserTemp[0] = helper.getUserInput();
        System.out.println("비밀번호: ");
        UserTemp[1] = helper.getUserInput();
        System.out.println("이름: ");
        UserTemp[2] = helper.getUserInput();
        System.out.println("관리자 여부(true or false): ");
        UserTemp[3] = helper.getUserInput();

        manager.getUserDB().add(new User_Info(
                UserTemp[0],
                UserTemp[1],
                UserTemp[2],
                Boolean.parseBoolean(UserTemp[3])
        ));

        FileManager.getInstance().writeDBFile("User_Info.txt");
    }
    
     @Override
    public boolean chkModifyType() {
        return false;
    }

}

