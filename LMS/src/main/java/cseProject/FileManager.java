/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject;

import cseProject.Book.Book_Info;
import cseProject.Book.Book_Manager;
import cseProject.Login.User_Info;
import cseProject.Login.User_Manager;
import cseProject.RentalFunction.Rental_Manager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
                else if (fileName.equals("Book_Info.txt")) {
                    String[] params = fileContent.split(";");
                    Book_Info newBook = new Book_Info(params[0], params[1], params[2], params[3], params[4]);
                    bookManager.add_BookDB(newBook);
                } //대여 목록 파일 읽기
                else if (fileName.equals("Rental_Info.txt")) {
                    String[] params = fileContent.split(";");
                    Book_Info newBook = new Book_Info(params[1], params[2], params[3], params[4], params[5]);
                    bookManager.add_BookDB(newBook);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> readDBFile(String fileName) throws IOException {
        String readFilePath = basePath + File.separator + fileName;
        File readFile;
        String fileContent;
        ArrayList<String> fileContents = new ArrayList<>();

        readFile = new File(readFilePath);
        BufferedReader br = new BufferedReader(new FileReader(readFile));
        while ((fileContent = br.readLine()) != null) {
            fileContents.add(fileContent);
            System.out.println(fileContent);
        }

        return fileContents;
    }

    public void writeDBFile(String fileName) {
        try {
            String writeFilePath = basePath + File.separator + fileName;
            FileWriter write;
            write = new FileWriter(writeFilePath, false);

            //유저 데이터 파일 작성
            if (fileName.equals("User_Info.txt")) {
                for (User_Info user : userManager.getUserDB()) {
                    String context = user.getUserID() + ';' + user.getUserPW() + ';' + user.getUserName() + ';' + String.valueOf(user.getIsManager()) + ';' + user.getRegisteredDate() + '\n';
                    write.write(context);
                }
                write.flush();
                write.close();
            }//도서 목록 데이터 파일 작성
            else if (fileName.equals("Book_Info.txt")) {
                for (Book_Info book : bookManager.getBookDB()) {
                    String context = book.getTitle() + ';' + book.getAuthor() + ';' + book.getGenre() + ';' + book.getPublihser() + ';' + book.getISBN() + '\n';
                    write.write(context);
                }
                write.flush();
                write.close();
            } //대여 목록 데이터 파일 작성
            else if (fileName.equals("Rental_Info.txt")) {

            }
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
