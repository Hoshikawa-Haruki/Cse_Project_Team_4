/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.UsermanagementFunction.ModifyFunction.Strategy;

import cseProject.Helper.SystemHelper;
import cseProject.Login.User_Manager;

/**
 *
 * @author jasuj
 */
public class Change implements ModifyBehavior {

    private static final SystemHelper helper = SystemHelper.getInstance();
    private static User_Manager manager = User_Manager.getInstance();
    private int selNum;

    @Override
    public void selModifyIndex() {
        System.out.print("▶ 수정할 대상의 번호를 입력하세요: ");
        String input = helper.getUserInput();
        selNum = Integer.parseInt(input) - 1;
    }

    public void modify() {
        System.out.println("- 회원정보를 수정 합니다. 수정할 내용이 없으면 enter을 입력하세요");

        System.out.print("▶ 아이디: ");
        String userID = helper.getUserInput();

        System.out.print("▶ 비밀번호: ");
        String userPW = helper.getUserInput();

        System.out.print("▶ 이름: ");
        String userName = helper.getUserInput();

//        System.out.print("▶ 관리자 여부 (true or false): ");
//        String isManager = helper.getUserInput();
        if (!userID.isBlank()) {
            manager.getUserDB().get(selNum).setUserID(userID);
        }

        if (!userPW.isBlank()) {
            manager.getUserDB().get(selNum).setUserPW(userPW);
        }

        if (!userName.isBlank()) {
            manager.getUserDB().get(selNum).setUserName(userName);
        }

//        if (!isManager.isBlank()) {
//            manager.getUserDB().get(selNum).setIsManager(Boolean.valueOf(isManager));
//        }
    }

    @Override
    public void excute() {
        selModifyIndex();
        modify();
    }
}
