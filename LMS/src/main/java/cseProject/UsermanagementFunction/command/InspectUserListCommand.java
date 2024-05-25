/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.UsermanagementFunction.command;

import cseProject.UsermanagementFunction.UserManagementFunction;

/**
 *
 * @author jasuj
 */
public class InspectUserListCommand implements Command {
    private UserManagementFunction userManager = UserManagementFunction.getInstance();

    public InspectUserListCommand(UserManagementFunction userManager) {
        this.userManager = userManager;
    }

    @Override
    public void execute() {
        userManager.InspectUserList();
    }
}