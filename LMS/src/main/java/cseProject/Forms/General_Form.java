/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Forms;

import cseProject.Forms.MainForm.General_Form_Behavior;
import cseProject.Login.UserCreation.General_UserCreation_Behavior;

/**
 *
 * @author 이승환
 */
public class General_Form extends Form { // 이용자 폼

    public General_Form() {
        this.form_Behavior = new General_Form_Behavior();
        this.register_Behavior = new General_UserCreation_Behavior();
    }
}
