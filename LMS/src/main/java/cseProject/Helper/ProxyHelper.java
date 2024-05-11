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
    public String getUserInput() {
        rogging();
        return realHelper.getUserInput();
    }

    @Override
    public ArrayList<String[]> getTextedData(String parameter) {
         return realHelper.getTextedData(parameter);
    }

    @Override
    public void BackUpTextFile(String paramater) {
         realHelper.getUserInput();
    }
    
    public void rogging(){ //현재 실행중인 메서드를 반환
        stackTrace = Thread.currentThread().getStackTrace();
        System.out.println(stackTrace[2]);
    }

    
}
