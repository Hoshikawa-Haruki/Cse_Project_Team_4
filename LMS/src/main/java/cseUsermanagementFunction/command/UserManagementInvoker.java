/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.command;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jasuj
 */
public class UserManagementInvoker {
 private Map<String, Command> commandMap = new HashMap<>();

    public UserManagementInvoker() {
    }
    
    public void setCommand(String commandName, Command command) {
        commandMap.put(commandName, command);
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