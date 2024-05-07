package cseProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static String getUserInput() {       //유저의 입력을 받는 메서드
        String inputLine = null;
        try{
            InputStreamReader reader=new InputStreamReader(System.in,"EUC-KR");     
            BufferedReader is = new BufferedReader(reader);                                    
            inputLine = is.readLine();
           
            while(inputLine.length() == 0){
                System.out.println("공백입력은 허용되지 않습니다.");
                 inputLine = is.readLine();
            }
            
            
        } catch (IOException e){
        System.out.println("IOException"+ e);
        }
        return inputLine;
}
    
    
            public static ArrayList<String[]> getTextedData(String parameter){    //파일에 저장된 데이터를 리스트에 읽어드림
                
                ArrayList<String[]> list = new ArrayList<>();
                
            try{           
                File f = new File(parameter);
        if(f.exists()){
        }else if(f.createNewFile()){ 
        }
                
        FileInputStream input=new FileInputStream(parameter);
        InputStreamReader reader=new InputStreamReader(input,"UTF-8");
        BufferedReader in=new BufferedReader(reader);
  
         
            String str0="";
            while(true)
            {
                if(str0.contains("*")){ //*는 데이터의 끝을 나타냄
                str0 = str0.substring(0, str0.length() - 1); //끝에 붙은 * 제거
                break;
                }
                str0 += in.readLine();   
            }


            
           // System.out.println(str0);
            
            String[] str1 = str0.split("/"); 
            for(String temp:str1){
                list.add(temp.split(",")); 
                //System.out.println(temp);
            }
            
            for(String[] temp:list){
                for(String str:temp){
                    //System.out.println(str);
                }
            }
           
             
            in.close();
         
                 return list;
        } catch (NullPointerException | IOException e){
            e.getStackTrace();
             String[] str = new String[0]; 
            return list; 
        }   
    }
        
   
    public static void BackUpTextFile(String paramater){   //기존 파일을 파일이름_old폴더에 현재시간을 이름으로 백업하고 기존파일은 삭제
        
         LocalDateTime now = LocalDateTime.now(); 
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
         String formatedNow = now.format(formatter);
        
           File folder = new File( paramater+"_old");

           if (!folder.exists()) {
		try{
		    folder.mkdir();
	        } 
	        catch(Exception e){
		    e.getStackTrace();
		}             
         }
         
           String patch = paramater+"_old/"+formatedNow+".txt";
          
           File file = new File( paramater);
           File newFile = new File(patch);
           
        try {    
            Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(SystemHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            
                file.delete();          
    }
        

    
}
