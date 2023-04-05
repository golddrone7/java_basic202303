package day08.poly.mybook;

import java.util.List;
import java.util.Scanner;

public class BookStoreView {
    Scanner sc;
    BookStoreController biz;
    BookStoreRepository dao;
    public BookStoreView() {
        biz = new BookStoreController();
        dao = new BookStoreRepository();
        sc = new Scanner(System.in);
    }
    public void menu(){
        System.out.println("====== 도서 메뉴 ======");
        System.out.println("# 1. 마이페이지");
        System.out.println("# 2. 도서 전체 조회");
        System.out.println("# 3. 도서 검색");
        System.out.println("# 4. 도서 대여하기");
        System.out.println("# 9. 프로그램 종료하기");
    }

    public void stop(){
        System.out.println("# enter를 누르면 실행됩니다.");
        sc.nextLine();
    }
    public int inputMenu(){
        int userNum = Integer.parseInt(input("- 메뉴 번호 : "));
        return userNum;
    }

    public void pageAllShow(Book[] books){
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public void viewMyPage(BookUser bookUser){
        System.out.println(bookUser);
    }
    public boolean selectMenu(){
        int menuNum = inputMenu();
        switch (menuNum) {
            case 1:
                BookUser bookUser = biz.myPage();
                viewMyPage(bookUser);
                stop();
                break;
            case 2:
                Book[] books = biz.pageAll();
                pageAllShow(books);
                stop();
                break;
            case 3:
                String search = input("# 검색어 : ");
                List<Book> bookList = biz.selectBook(search);
                showSearch(bookList, search);
                break;
            case 4:
                Book book =biz.rentalBook();
                System.out.print("# 성공적으로 대여되었습니다.");
                if(book instanceof CookBook){
                    System.out.println("요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요");
                } else if(book instanceof CartoonBook){
                    System.out.println("만화책을 발급했습니다");
                }
                stop();
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("잘못된 번호입니다!");
                return true;
        }
        return false;
    }

    private void showSearch(List<Book> bookList, String search) {
        System.out.println("====== 검색 결과 (검색어:"+search+") ======");
        for (Book book : bookList) {
            System.out.println(book);
        }
        stop();
    }


    public String input(String s){
        System.out.print(s);
        return sc.nextLine();
    }
    public void register(){
        String name = input("이름 : ");
        String age = input("나이 : ");
        String gender = input("성별 : ");
        biz.register(name, age, gender);
    }

    public void run(){
        register();
        while (true) {
            menu();
            if(selectMenu()) continue;

        }
    }











}
