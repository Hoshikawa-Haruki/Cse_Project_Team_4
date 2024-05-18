/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Helper;

import java.util.ArrayList;

/**
 *
 * @author jasuj
 */
public class ProxyHelper implements InterfaceSystemHelper{
    
    RealSystemHelper realHelper;
    private static ProxyHelper instance;
    
    StackTraceElement[] stackTrace = null;
    
    private ProxyHelper(){
    realHelper = RealSystemHelper.getInstance();
    }
    
    public static ProxyHelper getInstance() {
        if (instance == null) {
            instance = new ProxyHelper();
        }
        return instance;
    }

    @Override
    public String getUserInput() { //realHelper의 getUserInput()호출
        rogging();
        return realHelper.getUserInput();
    }

    @Override
    public ArrayList<String[]> getTextedData(String parameter) { //realHelper의 getUserInput()호출
         return realHelper.getTextedData(parameter);
    }

    @Override
    public void BackUpTextFile(String paramater) { //realHelper의 BackUpTextFile()호출
         realHelper.BackUpTextFile(paramater);
    }
    
     @Override
    public void fileMake(String str) { //realHelper의 fileMake()호출
         realHelper.fileMake(str);
    }
    
    public void rogging(){ //현재 실행중인 메서드를 반환, 임시로 작성한 코드로 추후 프록시 패턴을 이용하여 추가할 기능이 있으면 추가할 예정
       // stackTrace = Thread.currentThread().getStackTrace();
       // System.out.println(stackTrace[2]);
    }

 
}
