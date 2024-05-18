/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.ModifyFunction;

import cseProject.Helper.ProxyHelper;

/**
 *
 * @author jasuj
 */
public class changeStrategy extends StrategyTemplet {

    public void modify() {
        ProxyHelper helper = ProxyHelper.getInstance();
        String input = "";

        System.out.println("아이디: ");
        input = helper.getUserInput();
        manager.getUserDB().get(selNum).setUserID(input);

        System.out.println("비밀번호: ");
        input = helper.getUserInput();
        manager.getUserDB().get(selNum).setUserPW(input);

        System.out.println("이름: ");
        input = helper.getUserInput();
        manager.getUserDB().get(selNum).setUserName(input);

        System.out.println("관리자 여부(true or false): ");
        input = helper.getUserInput();
        manager.getUserDB().get(selNum).setIsManager(Boolean.valueOf(input));
    }

}
