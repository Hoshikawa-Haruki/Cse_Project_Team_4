/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.testtest;

/**
 *
 * @author 이승환
 */
import java.util.ArrayList;

class Menu extends MenuComponent {

    private ArrayList<MenuComponent> menuComponents = new ArrayList<>();
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
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
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + getName());
        System.out.println(indent + ", " + getDescription());
        System.out.println(indent + "---------------------");

        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print(indent + "  ");
        }
    }

    @Override
    public void print(String indent, String condition) {
        if (name.contains(condition) || description.contains(condition)) {
            print(indent);
        } else {
            for (MenuComponent menuComponent : menuComponents) {
                menuComponent.print(indent + "  ", condition);
            }
        }
    }
}
