/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.ModifyFunction.Strategy;

import cseProject.Helper.ProxyHelper;
import cseProject.Login.User_Manager;

/**
 *
 * @author jasuj
 */
public class ModifyBehaviorTemplet implements ModifyBehavior{
    
    private static final ProxyHelper helper = ProxyHelper.getInstance();
    protected static final User_Manager manager = User_Manager.getInstance();
    
    protected static int selNum;
    
    @Override
    public void selModifyIndex() { 
        System.out.println("수정할 대상의 번호를 입력하세요: ");
        String input = helper.getUserInput();
        selNum = Integer.parseInt(input)-1;
    }
    
    @Override
    public void modify() { 
    }
    
    @Override
    public void excute() {
        selModifyIndex();
        modify();
    }
}
