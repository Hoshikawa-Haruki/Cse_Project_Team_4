/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Forms;

import cseProject.Forms.MainForm.Main_Form_Behavior;
import cseProject.Login.UserCreation.UserCreation_Behavior;
import java.io.IOException;

/**
 *
 * @author 이승환
 */
public abstract class Form { // 폼 인터페이스

    protected UserCreation_Behavior register_Behavior;
    protected Main_Form_Behavior form_Behavior;

    public void perform_Main() {
        form_Behavior.show_MainForm();
    }

    public void perform_Register() throws IOException {
        register_Behavior.make_User();
    }
}
