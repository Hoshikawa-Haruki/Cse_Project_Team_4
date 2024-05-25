/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.ModifyFunction.Strategy;

import cseProject.Helper.SystemHelper;
import cseProject.Login.User_Manager;

/**
 *
 * @author jasuj
 */
public class Change implements ModifyBehavior{
      
    private static final SystemHelper helper = SystemHelper.getInstance();
    private static User_Manager manager = User_Manager.getInstance();
    private int selNum;
    
    @Override
    public void selModifyIndex() {
        System.out.println("수정할 대상의 번호를 입력하세요: ");
        String input = helper.getUserInput();
        selNum = Integer.parseInt(input) - 1;
    }
  
    public void modify() {
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
    
    
        @Override
    public void excute() {
        selModifyIndex();
        modify();
    }


}
