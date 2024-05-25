/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.UsermanagementFunction.ModifyFunction.Unit;

import cseProject.UsermanagementFunction.ModifyFunction.Strategy.Change;

/**
 *
 * @author jasuj
 */
public class ChangeUnit extends ModifyUnit {
    
    public ChangeUnit(){
    setModifyBehavior(new Change());
    }
}