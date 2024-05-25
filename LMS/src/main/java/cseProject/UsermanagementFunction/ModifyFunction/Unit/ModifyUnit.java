/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.UsermanagementFunction.ModifyFunction.Unit;

import cseProject.UsermanagementFunction.ModifyFunction.Strategy.ModifyBehavior;

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
