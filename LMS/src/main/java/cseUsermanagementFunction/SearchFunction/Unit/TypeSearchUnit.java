/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.SearchFunction.Unit;

import cseUsermanagementFunction.SearchFunction.Strategy.UserTypeSearch;

/**
 *
 * @author jasuj
 */
public class TypeSearchUnit extends SearchUnit {
    
    public TypeSearchUnit(){
    setSearchBehavior(new UserTypeSearch());
}
}
