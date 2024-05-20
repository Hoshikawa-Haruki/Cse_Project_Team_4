/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.testtest;

/**
 *
 * @author 이승환
 */
public class MenuItem extends MenuComponent {

    private String name;
    private String description;

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
        System.out.println(" " + getName() + " -- " + getDescription());
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + getName() + " -- " + getDescription());
    }

    @Override
    public void print(String indent, String condition) {
        if (name.contains(condition) || description.contains(condition)) {
            print(indent);
        }
    }
}
