/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.FileManagerTemplate;

/**
 *
 * @author 이승환
 */
import cseProject.Login.User_Info;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserFileManager extends FileManagerTemplate {

    @Override
    protected void parseLine(String line) {
        String[] params = line.split(";");
        User_Info newUser = new User_Info(params[0], params[1], params[2], Boolean.parseBoolean(params[3]), params[4]);
        try {
            userManager.add_userDB(newUser);
        } catch (IOException ex) {
            Logger.getLogger(UserFileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void writeData(BufferedWriter out) throws IOException {
        for (User_Info user : userManager.getUserDB()) {
            String context = user.getUserID() + ';' + user.getUserPW() + ';' + user.getUserName() + ';' + String.valueOf(user.getIsManager()) + ';' + user.getRegisteredDate() + '\n';
            out.write(context);
        }
    }
}
