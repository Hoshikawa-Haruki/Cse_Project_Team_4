/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.BookManagement.AddDelete;

import cseProject.BookManagement.Book;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface Observer {
    void update(List<Book> books);
}
