/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.SearchFunction.Unit;

import cseUsermanagementFunction.SearchFunction.Strategy.SearchBehavior;

/**
 *
 * @author jasuj
 */
public abstract class SearchUnit {
    SearchBehavior searchBehavior;
    public void setSearchBehavior(SearchBehavior sB){
        searchBehavior = sB;
    }
    
    public SearchBehavior getSearchBehavior() {
        return searchBehavior;
    }
    
    public void performSearch() {
        searchBehavior.Search();
    }

}
