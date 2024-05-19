/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.BookManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class AddRemoveUI {
    private final BookList booklist = new BookList();

    public AddRemoveUI() {       
        ObserverAdd(booklist);
    }

    public void mainUI() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = "";
            System.out.println("1. 책 추가하기\n2. 책 삭제하기\n3. 이전으로");
            System.out.print("▶ 번호를 입력하시오: ");

            try {
                line = br.readLine();
                if (line.isEmpty()) {
                    System.out.println("입력이 없습니다. 다시 시도해주세요.1");
                    continue;
                }

                switch (line) {
                    case "1":
                        add(booklist);
                        return;
                    case "2":
                        remove(booklist);
                        return;
                    case "3":
                        return;
                    default:
                        System.out.println("다시 입력해주세요.");
                        break;
                }
            } catch (NoSuchElementException | IOException e) {
                System.out.println("입력이 없습니다. 다시 시도해주세요.2");
            }
        }
    }

    private void add(BookList books) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String title;
            String author;
            String publisher;
            String isbn;

            while(true) {
                System.out.print("▶ 책 제목을 입력하세요: ");
                title = br.readLine();

                System.out.print("▶ 저자를 입력하세요: ");
                author = br.readLine();

                System.out.print("▶ 출판사를 입력하세요: ");
                publisher = br.readLine();

                System.out.print("▶ ISBN을 입력하세요: ");
                isbn = br.readLine();

                if(title.isEmpty() || author.isEmpty() || publisher.isEmpty() || isbn.isEmpty()){
                    System.out.println("다시 입력하시기 바랍니다.");
                    continue;
                }
                else {
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

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void remove(BookList books) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("▶ 삭제하고 싶은 책의 ISBN을 입력하시오: ");
                String isbn = scanner.nextLine();

                // ISBN으로 Book 객체 찾기
                Book foundBook = null;
                for (Book book : books.getBooks()) {
                    if (book.getIsbn().equals(isbn)) {
                        foundBook = book;
                        break;
                    }
                }

                if (foundBook != null) {
                    // ISBN이 일치하는 Book 객체를 찾았을 때의 처리
                    System.out.println("제목: " + foundBook.getTitle());
                    System.out.println("저자: " + foundBook.getAuthor());
                    System.out.println("출판사: " + foundBook.getPublisher());
                    System.out.println("ISBN: " + foundBook.getIsbn());

                    while (true) {
                        System.out.print("▶ 삭제하시겠습니까? (y/n): ");
                        String confirm = scanner.nextLine();

                        switch (confirm) {
                            case "y":
                                books.removeBook(isbn);
                                System.out.println("책이 삭제되었습니다.");
                                System.out.println("------------------------------------");
                                return;
                            case "n":
                                System.out.println("삭제가 취소되었습니다.");
                                System.out.println("------------------------------------");
                                return;
                            default:
                                System.out.println("다시 입력해주세요.");
                                break;

                        }
                    }

                } else {
                    // ISBN이 일치하는 Book 객체를 찾지 못했을 때의 처리
                    System.out.println("책을 찾을 수 없습니다. 다시 입력해주세요.");
                    continue;
                }
            }
        }
    }

    private void ObserverAdd(BookList booklist) {
        BookFileWriter a = new BookFileWriter();
        booklist.registerObserver(a);
    }
}
