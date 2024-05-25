/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.FileManagerTemplate;

/**
 *
 * @author 이승환
 */

import cseProject.Book.Book_Info;

import java.io.BufferedWriter;
import java.io.IOException;

public class BookFileManager extends FileManagerTemplate {

    @Override
    protected void parseLine(String line) {
        String[] params = line.split(";");
        Book_Info newBook = new Book_Info(params[0], params[1], params[2], params[3], params[4], Boolean.parseBoolean(params[5]));

        bookManager.add_BookDB(newBook);
    }

    @Override
    protected void writeData(BufferedWriter out) throws IOException {
        for (Book_Info book : bookManager.getBookDB()) {
            String context = book.getTitle() + ';' + book.getAuthor() + ';' + book.getGenre() + ';' + book.getPublisher() + ';' + book.getISBN() + ';' + book.getIsBorrorwed() + '\n';
            out.write(context);
        }
    }
}
