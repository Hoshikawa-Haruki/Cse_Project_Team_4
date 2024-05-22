/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.ModifyFunction.Unit;

import cseUsermanagementFunction.ModifyFunction.Strategy.Add;

/**
 *
 * @author jasuj
 */
public class AddUnit extends ModifyUnit {
    
    public AddUnit(){
    setModifyBehavior(new Add());
    }
}
