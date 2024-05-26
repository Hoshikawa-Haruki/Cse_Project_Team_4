/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseProject;

//import cseProject.Login.LoginSystem;
import cseProject.FileManagerTemplate.FileManagerTemplate;
import cseProject.UsermanagementFunction.UserManagementFunction;
import cseProject.UsermanagementFunction.command.UserManagementInvoker;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 이승환
 *
 */
public class TestDrive {

    private UserManagementFunction user = UserManagementFunction.getInstance();

    public static void main(String[] args) throws IOException {
//        LoginSystem loginSystem = LoginSystem.getInstance();
//        loginSystem.runLoginSystem();

        UserManagementInvoker invoker = new UserManagementInvoker();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        FileManagerTemplate.getInstance("User").createDBFile("User_Info.txt");
        FileManagerTemplate.getInstance("User").createDB("User_Info.txt");

        while (true) {
            String command = br.readLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            invoker.executeCommand(command.toLowerCase());
        }

        //위의 주석은 유저 추가, 삭제, 수정 관련 기능을 사용하기 위하여 작성된 구문임
        //add, delete, modify의 커맨드를 입력하면 해당 기능이 작동되고 변경된 사항은 UserData.txt에 저장되며 기존의 내용은'
        //UserData.txt_old 폴더에 현재 시간을 파일명으로 하여 자동저장됨
    }
}
