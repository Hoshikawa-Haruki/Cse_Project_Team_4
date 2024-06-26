/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.UsermanagementFunction.command;

/**
 *
 * @author jasuj
 */
import cseProject.UsermanagementFunction.UserManagementFunction;

public class ModifyUserCommand implements Command {
    private UserManagementFunction userManager = UserManagementFunction.getInstance();

    public ModifyUserCommand(UserManagementFunction userManager) {
        this.userManager = userManager;
    }

    @Override
    public void execute() {
        userManager.ModifyUser();
    }
}