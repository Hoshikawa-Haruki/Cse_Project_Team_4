/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.FileManagerTemplate;

/**
 *
 * @author 이승환
 */
import cseProject.Book.Book_Manager;
import cseProject.Login.User_Manager;
import cseProject.Rental.Rental_Manager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FileManagerTemplate {

    private static String basePath = System.getProperty("user.dir") + "\\data"; // 파일 저장 경로

    protected static User_Manager userManager = User_Manager.getInstance();
    protected static Book_Manager bookManager = Book_Manager.getInstance();
    protected static Rental_Manager rentalManager = Rental_Manager.getInstance();

    private static FileManagerTemplate userFileManagerInstance;
    private static FileManagerTemplate bookFileManagerInstance;
    private static FileManagerTemplate rentalFileManagerInstance;

    protected FileManagerTemplate() {
    }

    public static String getBasePath() {
        return basePath;
    }

    public static FileManagerTemplate getInstance(String fileType) {
        File createFolder = new File(basePath);
        if (!createFolder.exists()) {
            createFolder.mkdir();
        }

        switch (fileType) {
            case "User" -> {
                if (userFileManagerInstance == null) {
                    userFileManagerInstance = new UserFileManager();
                }
                return userFileManagerInstance;
            }
            case "Book" -> {
                if (bookFileManagerInstance == null) {
                    bookFileManagerInstance = new BookFileManager();
                }
                return bookFileManagerInstance;
            }
            case "Rental" -> {
                if (rentalFileManagerInstance == null) {
                    rentalFileManagerInstance = new RentalFileManager();
                }
                return rentalFileManagerInstance;
            }
            default ->
                throw new IllegalArgumentException("Invalid file type");
        }
    }

    public final void createDBFile(String fileName) {
        String createFilePath = basePath + File.separator + fileName;
        File createFile = new File(createFilePath);

        if (!createFile.exists()) {
            try {
                createFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileManagerTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
// 템플릿 메서드 부분. parseLine 부분을 추상으로 놓아서 클래스 별 파일 읽기 방법을 규정

    public final void createDB(String fileName) {
        try {
            ArrayList<String> fileContents = readDBFile(fileName);
            for (String fileContent : fileContents) {
                parseLine(fileContent); // (파일 종류에 따라 쓰는 형식이 다르므로)
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManagerTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// 템플릿 메서드 부분. writeData 부분을 추상으로 놓아서 클래스 별 파일 쓰기 방법을 규정
    public final void writeDBFile(String fileName) {
        try {
            String writeFilePath = basePath + File.separator + fileName;
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(writeFilePath, false), StandardCharsets.UTF_8);
            BufferedWriter out = new BufferedWriter(writer);

            writeData(out); //(파일 종류에 따라 쓰는 형식이 다르므로)

            out.flush();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManagerTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final ArrayList<String> readDBFile(String fileName) throws IOException {
        String readFilePath = basePath + File.separator + fileName;
        ArrayList<String> fileContents = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(readFilePath), StandardCharsets.UTF_8))) {
            String fileContent;
            while ((fileContent = br.readLine()) != null) {
                fileContents.add(fileContent);
                System.out.println(fileContent);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManagerTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fileContents;
    }

    protected abstract void parseLine(String line); // 한줄씩 읽기

    protected abstract void writeData(BufferedWriter out) throws IOException; // 파일에 쓰기
}
