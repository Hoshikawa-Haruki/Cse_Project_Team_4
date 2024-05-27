/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cseUsermanagementFunction.command;

import cseUsermanagementFunction.UserManagementFunction;

/**
 *
 * @author jasuj
 */
public interface Command {
      void execute();
      
      
      
      
      public class InspectUserListCommand implements Command {
    private UserManagementFunction userManager = UserManagementFunction.getInstance();

    public InspectUserListCommand() {
    }

    @Override
    public void execute() {
        userManager.InspectUserList();
    }
}
      
      
      public class ModifyUserCommand implements Command {
    private UserManagementFunction userManager = UserManagementFunction.getInstance();

    public ModifyUserCommand() {
    }

    @Override
    public void execute() {
        userManager.ModifyUser();
    }
}
      
      
      public class SearchUserCommand implements Command {
    private UserManagementFunction userManager = UserManagementFunction.getInstance();

    public SearchUserCommand() {
    }

    @Override
    public void execute() {
        userManager.SearchUserList();
    }
}
      
      
      
      
      
}
