package cseProject.BookManagement.Search;

import cseProject.BookManagement.Book;

import java.util.Iterator;
import java.util.List;

public class BookIterator implements Iterator<Book> {
    private final List<Book> books;
    private int position = 0;

    public BookIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public Book next() {
        if(this.hasNext()) {
            return books.get(position++);
        }
        return null;
    }
}