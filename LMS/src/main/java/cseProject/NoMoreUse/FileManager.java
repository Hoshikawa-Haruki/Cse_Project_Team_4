/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.NoMoreUse;

import cseProject.Book.Book_Info;
import cseProject.Book.Book_Manager;
import cseProject.Login.User_Info;
import cseProject.Login.User_Manager;
import cseProject.Rental.Rental_Info;
import cseProject.Rental.Rental_Manager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 이승환
 */
public class FileManager {

    private static FileManager instance;
    private static String basePath = System.getProperty("user.dir") + "\\data"; //파일 저장 경로
    private static User_Manager userManager = User_Manager.getInstance();
    private static Book_Manager bookManager = Book_Manager.getInstance();
    private static Rental_Manager rentalManager = Rental_Manager.getInstance();

    private FileManager() {
    }

    public static String getBasePath() {
        return basePath;
    }

    public static FileManager getInstance() {
        File createFolder = new File(basePath);
        if (instance == null) {
            if (!createFolder.exists()) {
                createFolder.mkdir();
            }
            instance = new FileManager();
        }
        return instance;
    }

    public void createDBFile(String fileName) {
        String createFilePath = basePath + File.separator + fileName;
        File createFile = new File(createFilePath); // File 객체 생성

        // 파일이 존재하지 않으면 파일 생성
        if (!createFile.exists()) {
            try {
                createFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void createDB(String fileName) {
        try {
            ArrayList<String> fileContents = readDBFile(fileName);
            for (String fileContent : fileContents) {
                if (fileName.equals("User_Info.txt")) { //사용자 데이터 파일 읽기
                    String[] params = fileContent.split(";");
                    User_Info newUser = new User_Info(params[0], params[1], params[2], Boolean.parseBoolean(params[3]), params[4]);
                    userManager.add_userDB(newUser);
                } //도서 데이터 파일 읽기
                else if (fileName.equals("Book_Info.txt")) { // 도서 데이터 파일 읽기
                    String[] params = fileContent.split(";");
                    Book_Info newBook = new Book_Info(params[0], params[1], params[2], params[3], params[4], Boolean.parseBoolean(params[5]));

                    // 옵저버 등록
                    //RentalObserver ro = new RentalObserver(newBook);
                    bookManager.add_BookDB(newBook);
                } //대여 목록 파일 읽기
                else if (fileName.equals("Rental_Info.txt")) {
                    String[] params = fileContent.split(";");
                    Rental_Info newRental = new Rental_Info(params[0], params[1], params[2], params[3]);
                    rentalManager.add_rentalDB(newRental);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> readDBFile(String fileName) throws IOException {
        String readFilePath = basePath + File.separator + fileName;
        ArrayList<String> fileContents = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(readFilePath), StandardCharsets.UTF_8))) {
            String fileContent;
            while ((fileContent = br.readLine()) != null) {
                fileContents.add(fileContent);
                System.out.println(fileContent);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return fileContents;
    }

    public void writeDBFile(String fileName) {
        try {
            String writeFilePath = basePath + File.separator + fileName;
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(writeFilePath, false), StandardCharsets.UTF_8);
            BufferedWriter out = new BufferedWriter(writer);

            // 유저 데이터 파일 작성
            if (fileName.equals("User_Info.txt")) {
                for (User_Info user : userManager.getUserDB()) {
                    String context = user.getUserID() + ';' + user.getUserPW() + ';' + user.getUserName() + ';' + String.valueOf(user.getIsManager()) + ';' + user.getRegisteredDate() + '\n';
                    out.write(context);
                }
                out.flush();
                out.close();
            } // 도서 목록 데이터 파일 작성
            else if (fileName.equals("Book_Info.txt")) {
                for (Book_Info book : bookManager.getBookDB()) {
                    String context = book.getTitle() + ';' + book.getAuthor() + ';' + book.getGenre() + ';' + book.getPublisher() + ';' + book.getISBN() + ';' + book.getIsBorrorwed() + '\n';
                    out.write(context);
                }
                out.flush();
                out.close();
            } // 대여 목록 데이터 파일 작성
            else if (fileName.equals("Rental_Info.txt")) {
                for (Rental_Info rental : rentalManager.getRentalDB()) {
                    String context = rental.getUserID() + ';' + rental.getUserName() + ';' + rental.getTitle() + ';' + rental.getISBN() + '\n';
                    out.write(context);
                }
                out.flush();
                out.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
