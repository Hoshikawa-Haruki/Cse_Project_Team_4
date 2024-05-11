/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseUsermanagementFunction.SearchFunction;

import cseProject.Helper.ProxyHelper;
import cseProject.Login.User_Manager;
import java.util.ArrayList;

/**
 *
 * @author jasuj
 */
public class UserTypeSearchStrategy implements SearchUserListStrategy{
    
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
                         System.out.println(
                          indexNumber+1
                            +
                          "."        
                            +
                          String.format("%15s",manager.getUserDB().get(num).getUserID())
                            +
                          String.format("%15s",manager.getUserDB().get(num).getUserPW())
                            +
                          String.format("%15s",manager.getUserDB().get(num).getUserName())
                            +
                          String.format("%15s",String.valueOf(manager.getUserDB().get(num).getIsManager()))

             );
                        indexNumber++;
            
                    }
    }
}
