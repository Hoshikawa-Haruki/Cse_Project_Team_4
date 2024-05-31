package cseProject.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 이승환
 */
public class SystemHelper {

    private static SystemHelper instance;

    // 외부에서 인스턴스화 방지하기 위해 private 생성자 선언
    private SystemHelper() {
    }

    // 인스턴스를 반환하는 정적 메서드
    public static SystemHelper getInstance() {
        if (instance == null) {
            instance = new SystemHelper();
        }
        return instance;
    }

    public String getUserInput() {       //유저의 입력을 받는 메서드
        String inputLine = null;
        try {
            InputStreamReader reader = new InputStreamReader(System.in, "EUC-KR");
            BufferedReader is = new BufferedReader(reader);
            inputLine = is.readLine();
        } catch (IOException e) {
            System.out.println("IOException" + e);
        }
        return inputLine;
    }
}
