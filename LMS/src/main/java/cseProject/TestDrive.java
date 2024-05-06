/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseProject;

import cseProject.Login.LoginSystem;
import java.io.IOException;

/**
 *
 * @author 이승환
 *
 */
public class TestDrive {

    public static void main(String[] args) throws IOException {
        LoginSystem loginSystem = LoginSystem.getInstance();
        loginSystem.runLoginSystem();
    }
}
