/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Book;

/**
 *
 * @author 이승환
 */
public class Book_Info {

    private String title;
    private String author;
    private String publihser;
    private String genre;
    private String ISBN;
    private boolean isBorrorwed;

    public Book_Info(String title, String author, String publihser, String genre, String ISBN, boolean isBorrorwed) {
        this.title = title;
        this.author = author;
        this.publihser = publihser;
        this.genre = genre;
        this.ISBN = ISBN;
        this.isBorrorwed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublihser() {
        return publihser;
    }

    public void setPublihser(String publihser) {
        this.publihser = publihser;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isIsBorrorwed() {
        return isBorrorwed;
    }

    public void setIsBorrorwed(boolean isBorrorwed) {
        this.isBorrorwed = isBorrorwed;
    }

}
