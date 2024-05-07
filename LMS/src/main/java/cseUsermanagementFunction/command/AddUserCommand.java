/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.command;

import cseUsermanagementFunction.UserManagement;

/**
 *
 * @author jasuj
 */
public class AddUserCommand implements Command {
    private UserManagement userManager = UserManagement.getInstance();

    public AddUserCommand(UserManagement userManager) {
        this.userManager = userManager;
    }

    @Override
    public void execute() {
        userManager.AddUser();
    }
}