/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.command;

import cseUsermanagementFunction.UserManagementFunction;

/**
 *
 * @author jasuj
 */
public class AddUserCommand implements Command {
    private UserManagementFunction userManager = UserManagementFunction.getInstance();

    public AddUserCommand(UserManagementFunction userManager) {
        this.userManager = userManager;
    }

    @Override
    public void execute() {
        userManager.AddUser();
    }
}