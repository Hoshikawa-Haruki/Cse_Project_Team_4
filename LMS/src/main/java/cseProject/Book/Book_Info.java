/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Book;

import cseProject.Rental.Observer;
import java.util.ArrayList;

/**
 *
 * @author 이승환
 */
public class Book_Info extends Subject {

    private String title;
    private String author;
    private String publisher;
    private String genre;
    private String ISBN;
    private boolean isBorrorwed;

    // 무조건 생성 순서는 타 - 아 - 장 - 퍼 - i
    public Book_Info(String title, String author, String genre, String publisher, String ISBN, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.ISBN = ISBN;
        this.isBorrorwed = isBorrowed;
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        System.out.println("변 " + ISBN);

        observers.forEach((observer) -> {
            observer.update(this.title);
        });
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyObserver();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
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

    public boolean getIsBorrorwed() {
        return isBorrorwed;
    }

    public void setIsBorrorwed(boolean isBorrorwed) {
        this.isBorrorwed = isBorrorwed;
    }

}
