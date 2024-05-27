/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseUsermanagementFunction;

import cseProject.FileManager;
import cseUsermanagementFunction.command.InspectUserListCommand;
import cseUsermanagementFunction.command.ModifyUserCommand;
import cseUsermanagementFunction.command.SearchUserCommand;
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

        //위의 주석은 유저 추가, 삭제, 수정 관련 기능을 사용하기 위하여 작성된 구문임
        //add, delete, modify의 커맨드를 입력하면 해당 기능이 작동되고 변경된 사항은 UserData.txt에 저장되며 기존의 내용은'
        //UserData.txt_old 폴더에 현재 시간을 파일명으로 하여 자동저장됨
    }
    
}
