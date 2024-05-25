/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.UsermanagementFunction.command;

import cseProject.UsermanagementFunction.UserManagementFunction;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jasuj
 */
public class UserManagementInvoker {
 private Map<String, Command> commandMap = new HashMap<>();

    public UserManagementInvoker() {
        // 여기에 사용할 명령어와 해당 명령어에 해당하는 커맨드 객체를 추가합니다.
        commandMap.put("modify", new ModifyUserCommand(UserManagementFunction.getInstance()));
        commandMap.put("search", new SearchUserCommand(UserManagementFunction.getInstance()));
        commandMap.put("inspect", new InspectUserListCommand(UserManagementFunction.getInstance()));
    }

    public void executeCommand(String commandName) {
        Command command = commandMap.get(commandName);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid command.");
        }
    }
}