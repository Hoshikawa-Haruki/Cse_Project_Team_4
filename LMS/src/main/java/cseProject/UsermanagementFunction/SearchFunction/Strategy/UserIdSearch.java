/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.UsermanagementFunction.SearchFunction.Strategy;

import cseProject.Helper.SystemHelper;
import cseProject.Login.User_Manager;
import java.util.ArrayList;

/**
 *
 * @author jasuj
 */
public class UserIdSearch implements SearchBehavior {

    private static final SystemHelper helper = SystemHelper.getInstance();
    private static final User_Manager manager = User_Manager.getInstance();

    @Override
    public void Search() {

        ArrayList<Integer> index = new ArrayList<>();
        int indexNumber = 0;

        System.out.println("검색할 아이디를 입력하세요: ");
        String str = helper.getUserInput();

        for (int i = 0; i < manager.getUserDB().size(); i++) {
            if (str.equals(manager.getUserDB().get(i).getUserID())) {
                index.add(i);
            }
        }

        System.out.println(
                String.format("%-6s", " ")
                + String.format("%-16s", "아이디")
                + String.format("%-16s", "패스워드")
                + String.format("%-16s", "이름")
                + String.format("%-16s", "관리자여부")
                + String.format("%-16s", "가입일")
        );

        for (int num : index) {

            String temp = manager.getUserDB().get(num).getRegisteredDate();
            String registeredDate = temp.substring(0, 4)
                    + "-"
                    + temp.substring(4, 6)
                    + "-"
                    + temp.substring(6, 8);

            System.out.println(
                    String.format("%-6s", indexNumber + 1 + ".")
                    + String.format("%-18s", manager.getUserDB().get(num).getUserID())
                    + String.format("%-18s", manager.getUserDB().get(num).getUserPW())
                    + String.format("%-18s", manager.getUserDB().get(num).getUserName())
                    + String.format("%-18s", String.valueOf(manager.getUserDB().get(num).getIsManager()))
                    + String.format("%-18s", registeredDate)
            );
            indexNumber++;
        }

    }

}
