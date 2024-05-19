/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.BookManagement.AddDelete;

import cseProject.BookManagement.Search.BookListPrint;
import cseProject.BookManagement.Search.BookSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

/**
 *
 * @author Lenovo
 */
public class BookMainUI {
    private final BookList booklist = new BookList();
    private final BookListPrint bookprint = new BookListPrint();
    private final AddBook add = new AddBook();
    private final DeleteBook delete = new DeleteBook();
    private final BookListPrint print = new BookListPrint();
    private final BookSearch search = new BookSearch(booklist);

    public BookMainUI() {
        ObserverAdd(booklist);
    }

    public void mainUI() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = "";
            System.out.println("1. 책 추가하기\n2. 책 삭제하기\n3. 책 목록보기\n4. 책 검색하기\n5. 이전으로\n");
            System.out.print("▶ 번호를 입력하시오: ");

            try {
                line = br.readLine();
                if (line.isEmpty()) {
                    System.out.println("입력이 없습니다. 다시 시도해주세요.1");
                    continue;
                }

                switch (line) {
                    case "1":
                        add.AddUI(booklist);
                        return;
                    case "2":
                        delete.DeleteUI(booklist);
                        return;
                    case "3":
                        bookprint.printBooks();
                        return;
                    case "4":
                        search.searchByTitle();
                        return;
                    case "5":
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


    private void ObserverAdd(BookList booklist) {
        BookFileWriter a = new BookFileWriter();
        booklist.registerObserver(a);
    }
}
