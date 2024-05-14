/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Forms;

import cseProject.Forms.MainForm.Admin_Form_Behavior;
import cseProject.Login.UserCreation.Admin_UserCreation_Behavior;

/**
 *
 * @author 이승환
 */
public class Admin_Form extends Form { // 관리자 폼

    public Admin_Form() {
        this.form_Behavior = new Admin_Form_Behavior();
        this.register_Behavior = new Admin_UserCreation_Behavior();
    }
    

}
