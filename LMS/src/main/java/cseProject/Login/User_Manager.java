/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Login;

import cseProject.FileManagerTemplate.FileManagerTemplate;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 이승환
 */
public class User_Manager {

    private static User_Manager instance; // 싱글턴
    private ArrayList<User_Info> userDB = new ArrayList<>(); // 유저DB
    private User_Info loginUser; // 현재 로그인 유저
    //private static RealSystemHelper helper = RealSystemHelper.getInstance();

    private User_Manager() {
    }

    public static User_Manager getInstance() {
        if (instance == null) {
            instance = new User_Manager();
        }
        return instance;
    }

    // user_MemberShip : 로그인시스템에서 정보 받음 -> 전략패턴 실행 -> 전략패턴에서 addUser 실행 -> 생성한 객체를 add_userDB에 넘겨줌, 여기 매개변수 이름이 user_MemberShip
    public void add_userDB(User_Info user_MemberShip) throws IOException {
        userDB.add(user_MemberShip);
        FileManagerTemplate.getInstance("User").writeDBFile("User_Info.txt");
    }

    public void setUserDB(ArrayList<User_Info> userDB) {
        this.userDB = userDB;
    }

    public void setLoginUser(User_Info loginUser) {
        this.loginUser = loginUser;
    }

    public User_Info getLoginUser() {
        return loginUser;
    }

    public ArrayList<User_Info> getUserDB() {
        return userDB;
    }

    public void userLogout() {
        loginUser = null;

    }

//    public void userLogin(String inputID, String inputPW) { // 안쓰이고있음
//        for (User_Info user : userDB) {
//            if (user.getUserID().equals(inputID) && user.getUserPW().equals(inputPW)) {
//                loginUser = user;
//            }
//        }
//    }
//    public void Regenerate(String str) { //변경된 파일을 백업 후 재성성
//        helper.BackUpTextFile("./" + str + ".txt");
//
//        try {
//            File f = new File("./UserData.txt");
//            if (f.exists()) {
//                System.out.println("파일이 이미 존재합니다.");
//            } else if (f.createNewFile()) {
//                System.out.println("파일을 생성합니다.");
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(User_Manager.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        try (FileOutputStream output = new FileOutputStream("./" + str + ".txt", true); OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8"); BufferedWriter out = new BufferedWriter(writer);) {
//            for (int i = 0; i < userDB.size(); i++) { //아이디,비밀번호,이름,관리자여부 형식으로 저장
//                out.append(
//                        userDB.get(i).getUserID()
//                        + ","
//                        + userDB.get(i).getUserPW()
//                        + ","
//                        + userDB.get(i).getUserName()
//                        + ","
//                        + String.valueOf(userDB.get(i).getIsManager())
//                        + ","
//                        + userDB.get(i).getRegisteredDate()
//                        + "/" // '/'문자로 사용자와 다른 사용자의 정보를 구분지음
//                );
//                out.append("\n");
//            }
//            out.append("*");          //시스템에 저장된 사용자데이터의 끝을 나타냄
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(User_Manager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(User_Manager.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
}
