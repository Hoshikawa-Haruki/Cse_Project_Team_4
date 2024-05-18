/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction.SearchFunction;

import cseProject.Helper.ProxyHelper;
import cseProject.Login.User_Manager;
import java.util.ArrayList;

/**
 *
 * @author jasuj
 */
public class UserNameSearchStrategy implements SearchUserListStrategy{
    
     private static final ProxyHelper helper = ProxyHelper.getInstance();
     private static final User_Manager manager = User_Manager.getInstance();
    
     public void Search(){
        
            String str="";
            ArrayList<Integer> index = new ArrayList<>();
            int indexNumber=0;
         
      
            
                    System.out.println("검색할 이름을 입력하세요: ");
                    str = helper.getUserInput();
                    
                    for(int i=0;i<manager.getUserDB().size();i++){
                        if(str.equals(manager.getUserDB().get(i).getUserName())){
                            index.add(i);
                        }
                    }
                    
        System.out.println(
                  String.format("%-6s"," ")
                + String.format("%-16s", "아이디" )
                + String.format("%-16s", "패스워드" )
                + String.format("%-16s", "이름" )
                + String.format("%-16s", "관리자여부" )
                + String.format("%-16s", "가입일" )
        );
                    
                    for(int num:index){
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
                          String.format("%-18s",manager.getUserDB().get(num).getRegisteredDate()) 
             );
                        indexNumber++;
            
                    }
    }
}
