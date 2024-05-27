/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.UsermanagementFunction.SearchFunction.Unit;

import cseProject.UsermanagementFunction.SearchFunction.Strategy.UserTypeSearch;

/**
 *
 * @author jasuj
 */
public class TypeSearchUnit extends SearchUnit {

    public TypeSearchUnit() {
        setSearchBehavior(new UserTypeSearch());
    }
}
