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
public class Delete implements ModifyBehavior {

    private static final SystemHelper helper = SystemHelper.getInstance();
    private static User_Manager manager = User_Manager.getInstance();
    private int selNum;

    @Override
    public void selModifyIndex() {
        boolean valid = false;
        while (!valid) {
            System.out.print("▶ 삭제할 대상의 번호를 입력하세요: ");
            String input = helper.getUserInput();
            try {
                selNum = Integer.parseInt(input) - 1;
                if (selNum >= 0 && selNum < manager.getUserDB().size()) {
                    valid = true;
                } else {
                    System.out.println("잘못된 번호입니다. 다시 입력하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력하세요.");
            }
        }
    }

    @Override
    public void modify() {
        manager.getUserDB().remove(selNum);
    }

    @Override
    public void excute() {
        selModifyIndex();
        modify();
    }

}
