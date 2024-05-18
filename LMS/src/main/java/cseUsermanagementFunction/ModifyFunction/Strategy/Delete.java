/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.ModifyFunction.Strategy;

/**
 *
 * @author jasuj
 */
public class Delete extends ModifyBehaviorTemplet {

    public void modify() {
        manager.getUserDB().remove(selNum);
        System.out.println("asdasd");
    }

}
