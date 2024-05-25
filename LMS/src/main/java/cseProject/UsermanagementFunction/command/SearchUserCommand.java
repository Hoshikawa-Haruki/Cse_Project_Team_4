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
public class SearchUserCommand implements Command {
    private UserManagementFunction userManager = UserManagementFunction.getInstance();

    public SearchUserCommand(UserManagementFunction userManager) {
        this.userManager = userManager;
    }

    @Override
    public void execute() {
        userManager.SearchUserList();
    }
}