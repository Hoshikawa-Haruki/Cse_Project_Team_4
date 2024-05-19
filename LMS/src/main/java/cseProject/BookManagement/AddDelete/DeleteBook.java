package cseProject.BookManagement.AddDelete;

import cseProject.BookManagement.Book;

import java.util.Scanner;

public class DeleteBook {

    protected void DeleteUI(BookList books) {
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
}
