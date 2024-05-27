/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cseProject.Menu;

import java.util.ArrayList;

/**
 *
 * @author 이승환
 */
public abstract class MenuComponent { // 리프노드

    private ArrayList<MenuComponent> menuComponents = new ArrayList<>();

    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public void printMenu() {
        for (MenuComponent MenuComponent : menuComponents) {
            MenuComponent.printMenu();
        }
    }
}
