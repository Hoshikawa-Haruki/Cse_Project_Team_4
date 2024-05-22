/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction;

import cseProject.FileManager;
import cseProject.Login.User_Info;
import cseProject.Login.User_Manager;
import cseProject.Helper.ProxyHelper;

import cseUsermanagementFunction.ModifyFunction.Unit.DeleteUnit;
import cseUsermanagementFunction.ModifyFunction.Unit.ChangeUnit;
import cseUsermanagementFunction.ModifyFunction.Unit.ModifyUnit;
import cseUsermanagementFunction.SearchFunction.Unit.IdSearchUnit;
import cseUsermanagementFunction.SearchFunction.Unit.NameSearchUnit;
import cseUsermanagementFunction.SearchFunction.Unit.SearchUnit;

import cseUsermanagementFunction.SearchFunction.Unit.TypeSearchUnit;


/**
 *
 * @author jasuj
 */
public class UserManagementFunction {

    private static final ProxyHelper helper = ProxyHelper.getInstance();
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
                  String.format("%-6s"," ")
                + String.format("%-16s", "아이디" )
                + String.format("%-16s", "패스워드" )
                + String.format("%-16s", "이름" )
                + String.format("%-16s", "관리자여부" )
                + String.format("%-16s", "가입일" )
        );

        for (int i = 0; i < manager.getUserDB().size(); i++) {
            String temp = manager.getUserDB().get(i).getRegisteredDate();
            String registeredDate="";
            registeredDate = temp.substring(0, 4)
                    + "-"
                    + temp.substring(4,6)
                    + "-"
                    + temp.substring(6, 8); 
            
            System.out.println(
                      String.format("%-6s" , i+1 + ".")
                    + String.format("%-18s", manager.getUserDB().get(i).getUserID())
                    + String.format("%-18s", manager.getUserDB().get(i).getUserPW())
                    + String.format("%-18s", manager.getUserDB().get(i).getUserName())
                    + String.format("%-18b", manager.getUserDB().get(i).getIsManager())
                    + String.format("%-18s",registeredDate)
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

    public void AddUser() { //사용자정보 등록
        InspectUserList();

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
        InspectUserList();
    }

    public void ModifyUser() { //사용자 정보 수정전략(삭제, 변경)에 따라 적절한 메세드 실행
        ModifyUnit mu = null;
        
        System.out.println("수행할 수정명령을 입력하세요(delete, change): ");
        String input = helper.getUserInput();
        
        switch (input) {
            case "delete":
                mu = new DeleteUnit();
                break;
            case "change":
                mu = new ChangeUnit();
                break;
            default:
                System.out.println("유효하지 않은 수정명령 입니다. ");
                break;        
        }

        if (mu.getModifyBehavior() != null) {
            System.out.println(input);
            mu.performModify();

        }
        
        FileManager.getInstance().writeDBFile("User_Info.txt");
        InspectUserList();
    }

}
