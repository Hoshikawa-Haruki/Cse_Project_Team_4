/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Menu;

/**
 *
 * @author 이승환
 */
public class MenuItem extends MenuComponent {

    private String name; // 메뉴 이름
    private String description; // 메뉴 설명

    public MenuItem(String name, String description) {
        this.name = name;
        this.description = description;
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
        System.out.println(getName() + " -- " + getDescription());
    }

}
