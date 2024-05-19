package cseProject.BookManagement.AddDelete;

import cseProject.BookManagement.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddBook {

    protected void AddUI(BookList books) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String title;
            String author;
            String publisher;
            String isbn;

            while (true) {
                System.out.print("▶ 책 제목을 입력하세요: ");
                title = br.readLine();

                System.out.print("▶ 저자를 입력하세요: ");
                author = br.readLine();

                System.out.print("▶ 출판사를 입력하세요: ");
                publisher = br.readLine();

                System.out.print("▶ ISBN을 입력하세요: ");
                isbn = br.readLine();

                if (title.isEmpty() || author.isEmpty() || publisher.isEmpty() || isbn.isEmpty()) {
                    System.out.println("다시 입력하시기 바랍니다.");
                    continue;
                } else {
                    break;
                }
            }


            Book book = new Book(title, author, publisher, isbn);

            System.out.println("제목: " + title);
            System.out.println("저자: " + author);
            System.out.println("출판사: " + publisher);
            System.out.println("ISBN: " + isbn);

            while (true) {
                System.out.print("▶ 해당 내용이 맞습니까? (y/n) : ");
                String check = br.readLine();

                if (check.equalsIgnoreCase("y")) {
                    books.addBook(book);
                    System.out.println("책이 성공적으로 추가되었습니다.");
                    System.out.println("------------------------------------");
                    break;
                } else if (check.equalsIgnoreCase("n")) {
                    System.out.println("취소되었습니다.");
                    System.out.println("------------------------------------");
                    break;
                } else {
                    System.out.println("다시 입력해주세요.");
                }
            }

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}