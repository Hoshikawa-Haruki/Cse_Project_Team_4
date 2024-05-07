/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseProject;

import cseProject.Login.LoginSystem;
import cseUsermanagementFunction.UserManagementFunction;
import cseUsermanagementFunction.command.UserManagementInvoker;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 이승환
 *
 */
public class TestDrive {
    private UserManagementFunction user = UserManagementFunction.getInstance();

    public static void main(String[] args) throws IOException {
        //LoginSystem loginSystem = LoginSystem.getInstance();
       // loginSystem.runLoginSystem();
        
        
       
        UserManagementInvoker invoker = new UserManagementInvoker();
        Scanner sc = new Scanner(System.in);
        
        while (true){
            String command = sc.nextLine();
            
            if (command.equalsIgnoreCase("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            
            invoker.executeCommand(command.toLowerCase());
        }
        
          sc.close();

    }
}
