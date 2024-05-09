/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseUsermanagementFunction;

import cseProject.Login.User_Info;
import cseProject.Login.User_Manager;
import cseProject.SystemHelper;
import cseUsermanagementFunction.SearchFunction.SearchUserListStrategy;
import cseUsermanagementFunction.SearchFunction.UserIdSearchStrategy;
import cseUsermanagementFunction.SearchFunction.UserNameSearchStrategy;
import cseUsermanagementFunction.SearchFunction.UserTypeSearchStrategy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jasuj
 */



public class UserManagementFunction {
    private String username;
    
    private static SystemHelper helper = SystemHelper.getInstance();
    
    ArrayList<String> Name = new ArrayList<>();
    ArrayList<String> Id = new ArrayList<>();
    ArrayList<String> Pw = new ArrayList<>();
    ArrayList<Boolean> IsManager = new ArrayList<>();
    
     private static final UserManagementFunction instance = new UserManagementFunction();
     private static User_Manager manager = User_Manager.getInstance();
    
        private UserManagementFunction(){    //처음 생성될때 유저데이터를 파일에서 불러와 저장
        }
        
        
        public static UserManagementFunction getInstance(){
            return instance;
        }
        
        
        public void InspectUserList(){ //사용자 목록 출력
           
        for(int i=0;i<manager.getUserDB().size();i++){
             System.out.println(
             i+1
               +
             "."        
               +
             String.format("%15s",manager.getUserDB().get(i).getUserID())
               +
             String.format("%15s",manager.getUserDB().get(i).getUserPW())
               +
             String.format("%15s",manager.getUserDB().get(i).getUserName())  
               +
             String.format("%15b",manager.getUserDB().get(i).getIsManager())
            
             );
            
          }
            
        }
        
          /*
        public void SearchUserList(){ //사용자 검색
            
           String str="";
           ArrayList<Integer> index = new ArrayList<>();
            System.out.println("검색방식을 입력하세요(name, id, pw, type): ");
            str = helper.getUserInput();
            int indexNumber=0;
            switch(str){
                case "name":
                    System.out.println("검색할 이름을 입력하세요: ");
                    str = helper.getUserInput();
                    for(int i=0;i<Name.size();i++){
                        if(str.equals(Name.get(i))){
                            index.add(i);
                        }
                    }
                    
                    for(int num:index){
                         System.out.println(
                          indexNumber+1
                            +
                          "."        
                            +
                          String.format("%15s",Name.get(num))
                            +
                          String.format("%15s",Id.get(num))
                            +
                          String.format("%15s",Pw.get(num))
                            +
                          String.format("%15b",IsManager.get(num))

             );
                         indexNumber++;
            
                    }
                    break;
                case "id":
                    System.out.println("검색할 아이디를 입력하세요: ");
                    str = helper.getUserInput();
                    for(int i=0;i<Id.size();i++){
                        if(str.equals(Id.get(i))){
                            index.add(i);
                        }
                    }
                    
                    for(int num:index){
                         System.out.println(
                          indexNumber+1
                            +
                          "."        
                            +
                          String.format("%15s",Name.get(num))
                            +
                          String.format("%15s",Id.get(num))
                            +
                          String.format("%15s",Pw.get(num))
                            +
                          String.format("%15b",IsManager.get(num))

             );
                        indexNumber++;
            
                    }
                    break;
                case "pw":
                     System.out.println("검색할 비밀번호를 입력하세요: ");
                    str = helper.getUserInput();
                    for(int i=0;i<Pw.size();i++){
                        if(str.equals(Pw.get(i))){
                            index.add(i);
                        }
                    }
                    
                    for(int num:index){
                         System.out.println(
                          indexNumber+1
                            +
                          "."        
                            +
                          String.format("%15s",Name.get(num))
                            +
                          String.format("%15s",Id.get(num))
                            +
                          String.format("%15s",Pw.get(num))
                            +
                          String.format("%15b",IsManager.get(num))

             );
                        indexNumber++;
            
                    }
                    break;
                case "type":
                 System.out.println("관리자 여부를 입력하세요(true, false): ");
                    str = helper.getUserInput();
                    for(int i=0;i<IsManager.size();i++){
                        
                        if(Boolean.parseBoolean(str) == IsManager.get(i)){
                            index.add(i);
                        }
                    }
                    
                    for(int num:index){
                         System.out.println(
                          indexNumber+1
                            +
                          "."        
                            +
                          String.format("%15s",Name.get(num))
                            +
                          String.format("%15s",Id.get(num))
                            +
                          String.format("%15s",Pw.get(num))
                            +
                          String.format("%15b",IsManager.get(num))

             );
                        indexNumber++;
            
                    }
                    break;
            }
               
        }*/
       
            
    public void SearchUserList() {
         System.out.println("검색방식을 입력하세요(id, name,, type): ");
         String input = helper.getUserInput();

        SearchUserListStrategy SearchUserStrategy = getLoginStrategy(input);
        if (SearchUserStrategy != null) {
            SearchUserStrategy.Search();
        }
    }

    private SearchUserListStrategy getLoginStrategy(String input) {
        switch (input) {
            case "id":
                return new UserIdSearchStrategy();
            case "name":
                return new UserNameSearchStrategy();
            case "type":
                return new UserTypeSearchStrategy();
            default:
                System.out.println("유효하지 않은 검색방식 입니다. ");
                return null;
        }
    }

    
       

        public void AddUser(){ //사용자정보 등록
           InspectUserList();
           
           String[] UserTemp = new String[4];
           System.out.println("아이디: ");
           UserTemp[0] = helper.getUserInput();
           System.out.println("비밀번호: ");
           UserTemp[1] = helper.getUserInput();
           System.out.println("이름: ");
           UserTemp[2] = helper.getUserInput();
           System.out.println("관리자 여부(true or false): ");
           UserTemp[3] = helper.getUserInput();
           
           manager.getUserDB().add(new User_Info(
                      UserTemp[0],
                      UserTemp[1],
                      UserTemp[2],
                      Boolean.parseBoolean(UserTemp[3])
              )); 
           
           Regenerate("UserData");
           
           InspectUserList();
        }
        
        public void DeleteUser(){ //사용자정보 삭제
            InspectUserList();
            
            System.out.println("삭제할 대상의 번호를 입력하세요: ");
           
            String input = helper.getUserInput();
            
            int selNum = Integer.parseInt(input)-1;
            
             manager.getUserDB().remove(selNum); 
            
            Regenerate("UserData");
            
            InspectUserList();
        }
        
        public void ModifyUser(){ //사용자정보 수정
           InspectUserList();
           System.out.println("수정할 사용자의 번호를 입력하세요."); 
           
           String input = helper.getUserInput();
            
           int selNum = Integer.parseInt(input)-1;
           

           System.out.println("아이디: ");
           input = helper.getUserInput();
           manager.getUserDB().get(selNum).setUserID(input);
           
           System.out.println("비밀번호: ");
           input = helper.getUserInput();
           manager.getUserDB().get(selNum).setUserPW(input);
           
            System.out.println("이름: ");
           input = helper.getUserInput();
           manager.getUserDB().get(selNum).setUserName(input);
           
           System.out.println("관리자 여부(true or false): ");
           input = helper.getUserInput();
           manager.getUserDB().get(selNum).setIsManager(Boolean.valueOf(input));
          
           Regenerate("UserData");
           
           InspectUserList();

        }
        
                           
        public void Regenerate(String str){ //변경된 파일을 백업 후 재성성
            helper.BackUpTextFile("./"+str+".txt");
       
        try{
             File f = new File("./UserData.txt");
        if(f.exists()){
            System.out.println("파일이 이미 존재합니다."); 
        }else if(f.createNewFile()){
             System.out.println("파일을 생성합니다.");
        }
        } catch (IOException ex) {
            Logger.getLogger(User_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
       
        try(FileOutputStream output = new FileOutputStream("./"+str+".txt",true);
            OutputStreamWriter writer=new OutputStreamWriter(output,"UTF-8");
            BufferedWriter out=new BufferedWriter(writer); )
        {
            for(int i=0;i<manager.getUserDB().size();i++){ //이름,아이디,비밀번호,관리자여부 형식으로 저장
                 out.append(
                 manager.getUserDB().get(i).getUserID()
                 +
                 ","        
                 +         
                manager.getUserDB().get(i).getUserPW()
                 +
                 ","        
                 +      
                 manager.getUserDB().get(i).getUserName()
                 +
                 ","        
                 +     
                 String.valueOf(manager.getUserDB().get(i).getIsManager())
                 +
                 "/"                      // '/'문자로 사용자와 다른 사용자의 정보를 구분지음
                 );
                 out.append("\n");
            }
            out.append("*");          //시스템에 저장된 사용자데이터의 끝을 나타냄
           
           
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User_Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(User_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
        
        
        
        
        }
    
    
        
  

}
