package cseProject.BookManagement.Search;

import cseProject.BookManagement.AddDelete.BookList;
import cseProject.BookManagement.AddDelete.Observer;
import cseProject.BookManagement.Book;

import java.util.Iterator;
import java.util.List;

public class BookListPrint extends BookList implements Observer {

    public void printBooks() {
        Iterator<Book> iterator = this.createIterator();
        System.out.println("---------------<<List>>-------------------------------------------------");
        System.out.printf("%-5s %-30s %-20s %-20s %-15s\n", "No.", "Title", "Author", "Publisher", "ISBN");

        int count = 1;
        while(iterator.hasNext()) {
            Book book = iterator.next();
            System.out.printf("%-5d %-30s %-20s %-20s %-15s\n",
                    count++,
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPublisher(),
                    book.getIsbn());
        }
        System.out.println("-------------------------------------------------------------------------");
    }


    public void update(List<Book> books) {
        System.out.println("*업데이트 된 책 리스트*");
        printBooks();
    }
}
