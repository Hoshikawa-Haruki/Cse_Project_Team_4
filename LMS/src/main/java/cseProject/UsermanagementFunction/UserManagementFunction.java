/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.UsermanagementFunction;

import cseProject.FileManagerTemplate.FileManagerTemplate;
import cseProject.Login.User_Manager;
import cseProject.Helper.SystemHelper;
import cseProject.UsermanagementFunction.ModifyFunction.Unit.DeleteUnit;
import cseProject.UsermanagementFunction.ModifyFunction.Unit.ChangeUnit;
import cseProject.UsermanagementFunction.ModifyFunction.Unit.ModifyUnit;
import cseProject.UsermanagementFunction.SearchFunction.Unit.IdSearchUnit;
import cseProject.UsermanagementFunction.SearchFunction.Unit.NameSearchUnit;
import cseProject.UsermanagementFunction.SearchFunction.Unit.SearchUnit;
import cseProject.UsermanagementFunction.SearchFunction.Unit.TypeSearchUnit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jasuj
 */
public class UserManagementFunction {

    private static final SystemHelper helper = SystemHelper.getInstance();
    private static UserManagementFunction instance;
    private static final User_Manager manager = User_Manager.getInstance();

    private UserManagementFunction() {
    }

    public static UserManagementFunction getInstance() {
        if (instance == null) {
            instance = new UserManagementFunction();
        }
        return instance;
    }

    public void InspectUserList() { //사용자 목록 출력 
        System.out.println(
                String.format("%-6s", " ")
                + String.format("%-16s", "아이디")
                + String.format("%-16s", "패스워드")
                + String.format("%-16s", "이름")
                + String.format("%-16s", "관리자여부")
                + String.format("%-16s", "가입일")
        );

        for (int i = 0; i < manager.getUserDB().size(); i++) {
            String temp = manager.getUserDB().get(i).getRegisteredDate();
            String registeredDate = temp.substring(0, 4)
                    + "-"
                    + temp.substring(4, 6)
                    + "-"
                    + temp.substring(6, 8);

            System.out.println(
                    String.format("%-6s", i + 1 + ".")
                    + String.format("%-18s", manager.getUserDB().get(i).getUserID())
                    + String.format("%-18s", manager.getUserDB().get(i).getUserPW())
                    + String.format("%-18s", manager.getUserDB().get(i).getUserName())
                    + String.format("%-18b", manager.getUserDB().get(i).getIsManager())
                    + String.format("%-18s", registeredDate)
            );

        }

    }

    public void SearchUserList() { //검색 전략에 따라 검색 메서드 호출
        SearchUnit su = null;
        System.out.println("검색방식을 입력하세요(id, name, type): ");
        String input = helper.getUserInput();

        switch (input) {
            case "id":
                su = new IdSearchUnit();
                break;
            case "name":
                su = new NameSearchUnit();
                break;
            case "type":
                su = new TypeSearchUnit();
                break;
            default:
                System.out.println("유효하지 않은 검색방식 입니다. ");
        }

        if (su.getSearchBehavior() != null) {
            su.performSearch();
        }
    }

    public void ModifyUser() { //사용자 정보 수정전략(삭제, 변경, 추가)에 따라 적절한 메세드 실행
        ModifyUnit mu = null;

        System.out.println("수행할 수정명령을 입력하세요(delete, change): ");
        String input = helper.getUserInput();

        InspectUserList();

        switch (input) {
            case "delete" -> {
                mu = new DeleteUnit();
                if (mu.getModifyBehavior() != null) {
                    System.out.println(input);
                    mu.performModify();
                }
            }
            case "change" -> {
                mu = new ChangeUnit();
                if (mu.getModifyBehavior() != null) {
                    System.out.println(input);
                    mu.performModify();
                }
            }
            default ->
                System.out.println("유효하지 않은 수정명령 입니다. ");
        }

        try {
            FileManagerTemplate.getInstance("User").writeDBFile("User_Info.txt");
        } catch (IOException ex) {
            Logger.getLogger(UserManagementFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        InspectUserList();
    }

}
