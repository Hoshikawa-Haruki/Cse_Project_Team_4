/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseUsermanagementFunction.SearchFunction.Strategy;

import cseProject.Helper.ProxyHelper;
import cseProject.Login.User_Manager;
import java.util.ArrayList;

/**
 *
 * @author jasuj
 */
public class UserTypeSearch implements SearchBehavior{
    
     private static final ProxyHelper helper = ProxyHelper.getInstance();
     private static final User_Manager manager = User_Manager.getInstance();
    
     public void Search(){
      
            Boolean chkType=null;
            ArrayList<Integer> index = new ArrayList<>();
            int indexNumber=0;
            String str=null;
         
      
            
                    System.out.println("검색할 유저타입을 입력하세요: ");
                    str = helper.getUserInput();
                    
                    if(str.equals("관리자")){
                        chkType = true;
                    }else if(str.equals("일반사용자")){
                        chkType = false;
                    }
                    
        System.out.println(
                  String.format("%-6s"," ")
                + String.format("%-16s", "아이디" )
                + String.format("%-16s", "패스워드" )
                + String.format("%-16s", "이름" )
                + String.format("%-16s", "관리자여부" )
                + String.format("%-16s", "가입일" )
        );
                    
                    
                    for(int i=0;i<manager.getUserDB().size();i++){
                         if(chkType == null){
                            break;
                        }
                        if(chkType == manager.getUserDB().get(i).getIsManager()){
                            index.add(i);
                        }
                    }
                    
                    for(int num:index){
                         if(chkType == null){
                            break;
                        }
                         
                        String temp = manager.getUserDB().get(num).getRegisteredDate();
                        String registeredDate="";
                        registeredDate = temp.substring(0, 4)
                        + "-"
                        + temp.substring(4,6)
                        + "-"
                        + temp.substring(6, 8); 
                         
                         
                         System.out.println(
                          String.format("%-6s" , indexNumber+1 + ".")
                            +
                          String.format("%-18s",manager.getUserDB().get(num).getUserID())
                            +
                          String.format("%-18s",manager.getUserDB().get(num).getUserPW())
                            +
                          String.format("%-18s",manager.getUserDB().get(num).getUserName())
                            +
                          String.format("%-18s",String.valueOf(manager.getUserDB().get(num).getIsManager()))
                            +     
                          String.format("%-18s",registeredDate)                                 
             );
                        indexNumber++;
            
                    }
    }
}