/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.ModifyFunction.Unit;

import cseUsermanagementFunction.ModifyFunction.Strategy.ModifyBehavior;

/**
 *
 * @author jasuj
 */
public abstract class ModifyUnit {
    ModifyBehavior modifyBehavior;
    public void setModifyBehavior(ModifyBehavior mB){
        modifyBehavior = mB;
    }
    
    public ModifyBehavior getModifyBehavior() {
        return modifyBehavior;
    }
    
    public void performModify() {
        modifyBehavior.excute();
    }

}
