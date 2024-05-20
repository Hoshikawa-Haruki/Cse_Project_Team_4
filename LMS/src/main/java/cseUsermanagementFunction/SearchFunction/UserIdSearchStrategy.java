/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.SearchFunction;

import cseProject.Helper.ProxyHelper;
import cseProject.Login.User_Manager;
import java.util.ArrayList;

/**
 *
 * @author jasuj
 */
public class UserIdSearchStrategy implements SearchUserListStrategy {

    private static final ProxyHelper helper = ProxyHelper.getInstance();
    private static final User_Manager manager = User_Manager.getInstance();

    public void Search() {

        String str = "";
        ArrayList<Integer> index = new ArrayList<>();
        int indexNumber = 0;

        System.out.println("검색할 아이디를 입력하세요: ");
        str = helper.getUserInput();

        for (int i = 0; i < manager.getUserDB().size(); i++) {
            if (str.equals(manager.getUserDB().get(i).getUserID())) {
                index.add(i);
            }
        }

        for (int num : index) {
            System.out.println(
                    indexNumber + 1
                    + "."
                    + String.format("%15s", manager.getUserDB().get(num).getUserID())
                    + String.format("%15s", manager.getUserDB().get(num).getUserPW())
                    + String.format("%15s", manager.getUserDB().get(num).getUserName())
                    + String.format("%15s", String.valueOf(manager.getUserDB().get(num).getIsManager()))
            );
            indexNumber++;

        }

    }

}
