/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.command;

/**
 *
 * @author jasuj
 */
import cseUsermanagementFunction.UserManagement;

public class ModifyUserCommand implements Command {
    private UserManagement userManager = UserManagement.getInstance();

    public ModifyUserCommand(UserManagement userManager) {
        this.userManager = userManager;
    }

    @Override
    public void execute() {
        userManager.ModifyUser();
    }
}