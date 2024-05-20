package cseProject.BookManagement.Search;

import cseProject.BookManagement.AddDelete.BookList;
import cseProject.BookManagement.AddDelete.Observer;
import cseProject.BookManagement.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookSearch extends BookList{
    private final BookList bookList;

    public BookSearch(BookList bookList) {
        this.bookList = bookList;
    }

    public void searchByTitle() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String title = null;

        while (true) {
            try {
                System.out.print("▶ 검색할 책 제목을 입력하시오: ");
                title = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (!Objects.equals(title, "") && title != null) { break; }
        }

        Iterator<Book> iterator = new BookIterator(books);

        bookList.createIterator();

        ArrayList<Book> foundBooks = new ArrayList<>();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();

            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        if (foundBooks.isEmpty()) {
            System.out.println("제목에 '" + title + "'가(이) 포함된 책을 찾을 수 없습니다.");
        } else {
            System.out.println("<<제목에 '" + title + "'가(이) 포함된 책 목록>>");
            for (Book book : foundBooks) {
                System.out.println(   "제목: " + book.getTitle()
                                    + "\n저자: " + book.getAuthor()
                                    + "\n출판사: " + book.getPublisher()
                                    + "\nISBN: " + book.getIsbn()
                                    + "\n--------------------------------");
            }
        }
    }
}

