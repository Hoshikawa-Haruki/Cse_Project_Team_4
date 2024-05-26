/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Forms.Factory;

import cseProject.Forms.Form;


/**
 *
 * @author 이승환
 */
public abstract class FormFactory {
    public Form create(Boolean isManager){  // 유형에 관계없이 form 객체 생성
        Form form;
        
        form = createForm(isManager);
        
        return form;
    }
    public abstract Form createForm(Boolean isManager); // abstract 메서드
}
