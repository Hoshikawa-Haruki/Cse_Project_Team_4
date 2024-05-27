/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Menu;

import cseProject.Book.Book_Info;
import cseProject.Book.Book_Manager;
import cseProject.Helper.SystemHelper;
import cseProject.Rental.Rental_Info;
import cseProject.Rental.Rental_Manager;

/**
 *
 * @author 이승환
 */
public class GeneralBook extends MenuItem {

    private MenuComponent allMenus;

    public GeneralBook(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    @Override
    public void printMenu() {
        System.out.println("┌────────────────────────┐");
        System.out.println("│ 1. 도서 현황                                   │");
        System.out.println("│ 2. 도서 검색                                   │");
        System.out.println("│ 3. 도서 대출                                   │");
        System.out.println("│ 4. 도서 반납                                   │");
        System.out.println("│ 5. 돌아가기                                    │");
        System.out.println("└────────────────────────┘");
        String choice = SystemHelper.getInstance().getUserInput();
        switch (choice) {
            case "1" -> {
                System.out.println("도서 현황");
                Book_Manager.getInstance().displayBooks();
                this.printMenu();
            }
            case "2" -> {
                System.out.println("도서 검색");
                Book_Manager.getInstance().showBooks(Book_Manager.getInstance().findBooksByAll());
                this.printMenu();
            }
            case "3" -> {
                System.out.println("도서 대출");
                Book_Info targetBook;
                while (true) {
                    targetBook = Book_Manager.getInstance().findBookByISBN();
                    if (targetBook != null) { // 널포인트 해결 코드
                        // 대여 메서드
                        Rental_Manager.getInstance().doRental(targetBook); //rentalDB 만드는 과정
                        break;
                    } else {
                        System.out.println("- 해당 도서를 찾을 수 없습니다.");
                    }
                }
                this.printMenu();
            }

            case "4" -> {
                System.out.println("도서 반납");
                Rental_Info targetRentalBook;
                targetRentalBook = Rental_Manager.getInstance().findMyBookByISBN();
                Rental_Manager.getInstance().doReturn(targetRentalBook);
                this.printMenu();
            }
            case "5" -> {
                System.out.println("이전 화면으로 돌아갑니다");
                allMenus.getChild(1).printMenu();
            }
            default -> {
                System.out.println("- 잘못된 입력입니다.");
            }
        }
    }

}
