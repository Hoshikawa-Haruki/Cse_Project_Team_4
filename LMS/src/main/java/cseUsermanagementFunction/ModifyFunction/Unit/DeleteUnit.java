/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.ModifyFunction.Unit;

import cseUsermanagementFunction.ModifyFunction.Strategy.Delete;

/**
 *
 * @author jasuj
 */
public class DeleteUnit extends ModifyUnit {
    
    public DeleteUnit(){
    setModifyBehavior(new Delete());
    }
}
