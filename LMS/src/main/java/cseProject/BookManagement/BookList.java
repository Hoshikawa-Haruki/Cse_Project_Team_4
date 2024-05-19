/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.BookManagement;

/**
 *
 * @author Lenovo
 */
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class BookList implements Subject {

    private List<Observer> observers;
    private List<Book> books;

    public BookList() {
        observers = new ArrayList<>();
        books = new ArrayList<>();
        localFile();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(books);
        }
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
        notifyObservers();
    }

    @Override
    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        notifyObservers();
    }

    private void localFile() {

        String paths = System.getProperty("user.dir");
        File projectPath = new File(paths + "/DB/BookList.txt");
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(projectPath), StandardCharsets.UTF_8))) {
           String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");

                String title = data[0];
                String author = data[1];
                String publisher = data[2];
                String isbn = data[3];

                Book book = new Book(title, author, publisher, isbn);
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
