/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 이승환
 */
public class Menu extends MenuComponent { // 컴포지트 노드

    List<MenuComponent> menuComponents = new ArrayList<>();
    private String name;

    public Menu() {
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printMenu() {
        for (MenuComponent Menu_Component : menuComponents) {
            Menu_Component.printMenu();
        }
    }
}
