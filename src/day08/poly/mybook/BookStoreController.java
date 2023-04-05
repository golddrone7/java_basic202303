package day08.poly.mybook;

import day05.member.Gender;

import java.util.List;
import java.util.Scanner;

public class BookStoreController {
    Scanner sc;
    BookStoreRepository dao;
    public BookStoreController() {
        dao = new BookStoreRepository();
        sc = new Scanner(System.in);
    }


    public BookUser myPage() {
        BookUser bookUser = dao.myPage();
        return bookUser;
    }

    public Book[] pageAll() {
        Book[] books = dao.pageAll();
        return books;
    }

    public List<Book> selectBook(String search) {
        List<Book> bookList = dao.selectBook(search);
        return bookList;
    }


    public Book rentalBook() {
        Book[] books = dao.pageAll();
        System.out.println("====== 대여 도서 목록 ======");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i+1)+"번째 도서 : " + books[i].toString());
        }
        System.out.print("# 대여할 도서 번호 입력 : ");
        int idx = sc.nextInt();
        if(books[idx-1] instanceof CookBook) {
            BookUser user = myPage();
            if(((CookBook) books[idx - 1]).isCoupon()) {
                user.setCouponCount(user.getCouponCount() + 1);
            }
        }
        return books[idx-1];
    }

    public void register(String name, String age, String gender) {
        int userAge = 0;
        Gender gender1 = null;
        try{
            userAge = Integer.parseInt(age);
        } catch (Exception e) {
            System.out.println("나이 오류!");
        }
        if(gender.toUpperCase().charAt(0)=='M'){
            gender1 = Gender.MALE;
        }
        if(gender.toUpperCase().charAt(0)=='F') {
            gender1 = Gender.FEMALE;
        }

        BookUser user = new BookUser(name, userAge, gender1,0);
        dao.register(user);


    }
}
