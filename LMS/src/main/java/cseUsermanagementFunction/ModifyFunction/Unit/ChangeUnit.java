/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.ModifyFunction.Unit;

import cseUsermanagementFunction.ModifyFunction.Strategy.Change;

/**
 *
 * @author jasuj
 */
public class ChangeUnit extends ModifyUnit {
    
    public ChangeUnit(){
    setModifyBehavior(new Change());
    }
}