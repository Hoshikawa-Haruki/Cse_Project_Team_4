/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseUsermanagementFunction;

import cseProject.FileManager;
import cseUsermanagementFunction.command.Command.*;
import cseUsermanagementFunction.command.UserManagementInvoker;
import java.util.Scanner;

/**
 *
 * @author jasuj
 */
public class UserManagement_TestDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UserManagementInvoker invoker = new UserManagementInvoker();
        Scanner sc = new Scanner(System.in);
        
        FileManager.getInstance().createDBFile("User_Info.txt");
        FileManager.getInstance().createDB("User_Info.txt");

        invoker.setCommand("inspect",new InspectUserListCommand());
        invoker.setCommand("search",new SearchUserCommand());
        invoker.setCommand("modify",new ModifyUserCommand());
                
        while (true) {
            String command = sc.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            invoker.executeCommand(command.toLowerCase());
        }

        sc.close();

    }
}
