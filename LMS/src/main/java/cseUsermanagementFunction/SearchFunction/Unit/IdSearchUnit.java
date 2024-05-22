/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.SearchFunction.Unit;

import cseUsermanagementFunction.SearchFunction.Strategy.UserIdSearch;
import cseUsermanagementFunction.SearchFunction.Strategy.SearchBehavior;

/**
 *
 * @author jasuj
 */
public class IdSearchUnit extends SearchUnit {
    
    public IdSearchUnit(){
    setSearchBehavior(new UserIdSearch());
}
}
