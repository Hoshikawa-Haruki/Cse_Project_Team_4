/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction;

import cseProject.Login.User_Info;
import cseProject.Login.User_Manager;
import cseProject.Helper.ProxyHelper;
import cseProject.Helper.RealSystemHelper;
import cseUsermanagementFunction.ModifyFunction.StrategyTemplet;
import cseUsermanagementFunction.ModifyFunction.changeStrategy;
import cseUsermanagementFunction.ModifyFunction.deleteStrategy;
import cseUsermanagementFunction.SearchFunction.SearchUserListStrategy;
import cseUsermanagementFunction.SearchFunction.UserIdSearchStrategy;
import cseUsermanagementFunction.SearchFunction.UserNameSearchStrategy;
import cseUsermanagementFunction.SearchFunction.UserTypeSearchStrategy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jasuj
 */
public class UserManagementFunction {

    private static final ProxyHelper helper = ProxyHelper.getInstance();
    private static UserManagementFunction instance;
    private static final User_Manager manager = User_Manager.getInstance();

    private UserManagementFunction() {    //처음 생성될때 유저데이터를 파일에서 불러와 저장
    }

    public static UserManagementFunction getInstance() {
        if (instance == null) {
            instance = new UserManagementFunction();
        }
        return instance;
    }

    public void InspectUserList() { //사용자 목록 출력

        for (int i = 0; i < manager.getUserDB().size(); i++) {
            System.out.println(
                    i + 1
                    + "."
                    + String.format("%15s", manager.getUserDB().get(i).getUserID())
                    + String.format("%15s", manager.getUserDB().get(i).getUserPW())
                    + String.format("%15s", manager.getUserDB().get(i).getUserName())
                    + String.format("%15b", manager.getUserDB().get(i).getIsManager())
            );

        }

    }

    public void SearchUserList() { //검색 전략에 따라 검색 메서드 호출
        System.out.println("검색방식을 입력하세요(id, name,, type): ");
        String input = helper.getUserInput();

        SearchUserListStrategy SearchUserStrategy = getLoginStrategy(input);
        if (SearchUserStrategy != null) {
            SearchUserStrategy.Search();
        }
    }

    private SearchUserListStrategy getLoginStrategy(String input) { //사용자의 입력을 받아 적절한 검색 전략 반환
        switch (input) {
            case "id":
                return new UserIdSearchStrategy();
            case "name":
                return new UserNameSearchStrategy();
            case "type":
                return new UserTypeSearchStrategy();
            default:
                System.out.println("유효하지 않은 검색방식 입니다. ");
                return null;
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

        Regenerate("UserData");

        InspectUserList();
    }

    public void ModifyUser() { //사용자 정보 수정전략(삭제, 변경)에 따라 적절한 메세드 실행
        System.out.println("수행할 수정명령을 입력하세요(delete, change): ");
        String input = helper.getUserInput();

        StrategyTemplet modifyStrategy = getModifyUserStrategy(input);

        if (modifyStrategy != null) {
            System.out.println(input);
            modifyStrategy.excute();

        }
        Regenerate("UserData");
        InspectUserList();

    }

    public StrategyTemplet getModifyUserStrategy(String input) { //사용자 입력에 따라 적절한 전략 반환
        switch (input) {
            case "delete":
                return new deleteStrategy();
            case "change":
                return new changeStrategy();
            default:
                System.out.println("유효하지 않은 수정명령 입니다. ");
                return null;
        }

    }

    public void Regenerate(String str) { //변경된 파일을 백업 후 재성성
        helper.BackUpTextFile("./" + str + ".txt");
        helper.fileMake(str);

        try (FileOutputStream output = new FileOutputStream("./" + str + ".txt", true); OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8"); BufferedWriter out = new BufferedWriter(writer);) {
            for (int i = 0; i < manager.getUserDB().size(); i++) { //이름,아이디,비밀번호,관리자여부 형식으로 저장
                out.append(
                        manager.getUserDB().get(i).getUserID()
                        + ","
                        + manager.getUserDB().get(i).getUserPW()
                        + ","
                        + manager.getUserDB().get(i).getUserName()
                        + ","
                        + String.valueOf(manager.getUserDB().get(i).getIsManager())
                        + ","
                        + manager.getUserDB().get(i).getRegisteredDate()
                        + "/" // '/'문자로 사용자와 다른 사용자의 정보를 구분지음
                );
                out.append("\n");
            }
            out.append("*");          //시스템에 저장된 사용자데이터의 끝을 나타냄

        } catch (FileNotFoundException ex) {
            Logger.getLogger(User_Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(User_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
