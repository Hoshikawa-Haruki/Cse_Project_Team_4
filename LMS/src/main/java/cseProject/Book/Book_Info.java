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
    private String publisher;
    private String genre;
    private String ISBN;
    private boolean isBorrorwed;

    public Book_Info(String title, String author, String publisher, String genre, String ISBN) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
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
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
