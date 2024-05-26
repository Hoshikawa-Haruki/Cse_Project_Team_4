/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Forms.Factory;

import cseProject.Forms.Admin_Form;
import cseProject.Forms.Form;
import cseProject.Forms.General_Form;

/**
 *
 * @author 이승환
 */
public class ConcreteFormFactory extends FormFactory {

    @Override
    public Form createForm(Boolean isManager) {
        Form form;
        if (!isManager) {
            form = new General_Form();
        } else {
            form = new Admin_Form();
        }

        return form;
    }
}
