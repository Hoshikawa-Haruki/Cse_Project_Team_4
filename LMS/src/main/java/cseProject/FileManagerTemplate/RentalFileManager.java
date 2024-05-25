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
import cseProject.Rental.Rental_Info;

import java.io.BufferedWriter;
import java.io.IOException;

public class RentalFileManager extends FileManagerTemplate {

    @Override
    protected void parseLine(String line) {
        String[] params = line.split(";");
        Book_Info book = bookManager.findBookByISBN(params[3]);
        Rental_Info newRental = new Rental_Info(params[0], params[1], params[2], params[3]);
        newRental.setSubject(book);
        rentalManager.add_rentalDB(newRental);
    }

    @Override
    protected void writeData(BufferedWriter out) throws IOException {
        for (Rental_Info rental : rentalManager.getRentalDB()) {
            String context = rental.getUserID() + ';' + rental.getUserName() + ';' + rental.getTitle() + ';' + rental.getISBN() + '\n';
            out.write(context);
        }
    }
}
