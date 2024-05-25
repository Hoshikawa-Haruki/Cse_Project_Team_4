/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Forms.MainForm;

import cseProject.Book.Book_Info;
import cseProject.Book.Book_Manager;
import cseProject.Login.User_Manager;
import cseProject.Helper.ProxyHelper;
import cseProject.LoginState.UserContext;
import cseProject.Rental.Rental_Info;
import cseProject.Rental.Rental_Manager;

/**
 *
 * @author 이승환
 */
public class General_Form_Behavior implements Main_Form_Behavior {

    private static final ProxyHelper helper = ProxyHelper.getInstance();

    @Override
    public void show_MainForm() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 도서 검색/대출/반납                         │");
        System.out.println("│ 2. 희망도서 신청                               │");
        System.out.println("│ 3. 내 정보 조회                                │");
        System.out.println("│ 4. 로그아웃                                    │");
        System.out.println("└────────────────────────┘");
        String choice = helper.getUserInput();
        switch (choice) {
            case "1" -> {
                System.out.println("도서 검색/대출/반납");
                showBookGeneralForm();
            }
            case "2" -> {
                System.out.println("희망도서 신청 탭.");
                showRequestingBook();
            }
            case "3" -> {
                System.out.println("내 정보 조회");
                showMyInformation();
            }
            case "4" -> {
                System.out.println("로그아웃을 실행합니다");
                UserContext.getInstance().logout();
            }
            default -> {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public void showBookGeneralForm() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 도서 현황                                   │");
        System.out.println("│ 2. 도서 검색                                   │");
        System.out.println("│ 3. 도서 대출                                   │");
        System.out.println("│ 4. 도서 반납                                   │");
        System.out.println("│ 5. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");
        String choice = helper.getUserInput();
        switch (choice) {
            case "1" -> {
                System.out.println("도서 현황");
                Book_Manager.getInstance().displayBooks();
                showBookGeneralForm();
            }
            case "2" -> {
                System.out.println("도서 검색");
                // todo
                Book_Manager.getInstance().showBooks(Book_Manager.getInstance().findBooksByAll());
                showBookGeneralForm();
            }
            case "3" -> {
                System.out.println("도서 대출");
                //Book_Info targetBook = Book_Manager.getInstance().findBookByISBN(); // 기존코드
                //targetBook.realRent(); // 옵저버 실행
                Book_Info targetBook;
                while (true) {
                    targetBook = Book_Manager.getInstance().findBookByISBN();
                    if (targetBook != null) { // 널포인트 해결 코드
                        // 대여 옵저버 실행 (책 객체 상태 변경 알림) < 상태 변경 메서드만 넣으면 됨
                        Rental_Manager.getInstance().doRental(targetBook); // 옵저버와 관계 X rentalDB 만드는 과정
                        break;
                    } else {
                        System.out.println("- 해당 도서를 찾을 수 없습니다.");
                    }
                }
                showBookGeneralForm();
            }

            case "4" -> {
                System.out.println("도서 반납");
                Book_Info targetBook;
                while (true) {
                    targetBook = Book_Manager.getInstance().findBookByISBN();
                    if (targetBook != null) { // 널포인트 해결 코드
                        // 반납 옵저버 실행 (책 객체 상태 변경 알림) <- 반납 메서드만 주셈
                        break;
                    } else {
                        System.out.println("- 해당 도서를 찾을 수 없습니다.");
                    }
                }
                Rental_Info targetRentalBook;
                targetRentalBook = Rental_Manager.getInstance().findMyBookByISBN();
                Rental_Manager.getInstance().doReturn(targetRentalBook);
                showBookGeneralForm();
            }
            case "5" -> {
                System.out.println("- 이전 화면으로 돌아갑니다");
                show_MainForm();
            }
            default -> {
                System.out.println("- 잘못된 입력입니다.");
            }
        }
    }

    public void showRequestingBook() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 희망도서 신청                               │");
        System.out.println("│ 2. 희망도서 신청 현황                          │");
        System.out.println("│ 3. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");
        String choice = helper.getUserInput();
        if ("3".equals(choice)) {
            System.out.println("- 메인 화면으로 돌아갑니다");
            show_MainForm();
        }
    }

    public void showMyInformation() {

    }
}
