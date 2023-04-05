package day08.poly.book;

import day04.array.StringList;
import day07.protec.pac1.A;
import day07.protec.pac1.B;

import java.lang.reflect.Array;
import java.util.ArrayList;

// 도서관리 시스템 데이터 처리
public class LibraryRepository {

    // 회원 1명
    private static BookUser bookUser;

    // 도서들의 정보
    private static Book[] bookList;

    // 대여 상태

    // initializer static, 자동 실행 됨
    static {
        bookList = new Book[]{
                new CookBook("기적의 집밥책", "김해진", "청림라이프", true),
                new CartoonBook("떨어지면 끝장맨", "스에노부 케이코", "대원씨아이", 18),
                new CartoonBook("원펀맨", "One", "대원씨아이", 15),
                new CookBook("삐뽀삐뽀 119 이유식", "하정훈", "유니책방", false),
                new CookBook("오늘은 아무래도 덮밥", "이마이 료", "참돌", true),
                new CartoonBook("이세계로 전이했으니 치트를 살려 마법검사가 되기로 했다", "Shinkoshoto", "대원씨아이", 12),
        };
    }
    // 유저를 등록하는 기능
    public void register(BookUser userInfo) {
        bookUser = userInfo;
    }

    // 마이페이지 기능
    /*
        여기에 있는 bookUser 정보 리턴
     */
    BookUser findBookUser() {
        return bookUser;
    }

    // 모든 책의 정보를 알려주는 메서드
    public String[] getBookInfoList(){
        String[] infoList = new String[bookList.length];
        for (int i = 0; i < infoList.length; i++) {
            infoList[i] = bookList[i].info();
        }
        return infoList;
    }

    // 검색어를 받으면 해당 검색어를 포함하는 제목을 가진 책 정보들을 반환
    public String[] searchBookInfoList(String keyword){
        // bookList를 뒤져야 됨.
        StringList list = new StringList();
        for (Book book : bookList) {
            String title = book.getTitle(); // 책 제목
            if(title.contains(keyword)){
                //검색어에 걸린 책의 정보 문자열
                String info = book.info();
                list.push(info);
            }
        }
        return list.getsArr();
    }

    public ArrayList<Book> searchAuthorInfoList(String keyword) {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        for (Book book : bookList) {
            if(keyword.equals(book.getAuthor())){
                bookArrayList.add(book);
            }
        }
        return bookArrayList;
    }

    public void rentShowBook() {
        System.out.println("======== 대여 도서 목록 ========");
        for (int i = 0; i < bookList.length; i++) {
            System.out.println((i+1)+"번째 도서: " + bookList[i].info());
        }
    }

    public String rentBook(int userNum) {
        if(userNum>bookList.length || userNum < 1) return "잘못된 번호입니다";
        Book rentBook = bookList[userNum-1];
        if(rentBook!=null) {
            if (rentBook instanceof CartoonBook) {
                if(((CartoonBook)rentBook).getAccessAge() <= bookUser.getAge()){
                    return  "# [만화] 성공적으로 대여되었습니다. 만화 잘보세요!!!!";
                } else{
                    return String.format("# 나이가 안됩니다! %d <= %d \n",((CartoonBook)rentBook).getAccessAge() , bookUser.getAge());
                }
            } else if (rentBook instanceof CookBook) {
                if(((CookBook)rentBook).isCoupon()){
                    bookUser.setCouponCount(bookUser.getCouponCount()+1);
                    return "# [요리] 성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요";
                } else{
                    return "# [요리] 성공적으로 대여되었습니다.";
                }
            }
        }
        return "ㅎㅇㅎㅇ";
    }

    // 도서 대여 처리
    public RentStatus rentBook1(int rentNum){
        // 대여를 원하는 책 추출
        Book wishBook = bookList[rentNum - 1];

        // 책의 분류에 따라 다른 처리
        if (wishBook instanceof CookBook){
            CookBook cookBook = (CookBook) wishBook;
            // 쿠폰 유무를 확인
            if(cookBook.isCoupon()){
                bookUser.setCouponCount(bookUser.getCouponCount()+1);
                return RentStatus.RENT_SUCCESS_WITH_COUPON;
            } else {
                return RentStatus.RENT_SUCCESS;
            }
            // 쿠폰 유무를 확인
        } else if (wishBook instanceof CartoonBook){
            // 연령 제한을 확인
            CartoonBook cartoonBook= (CartoonBook) wishBook;
            if(bookUser.getAge() >= cartoonBook.getAccessAge()){
                // 빌릴 수 있는 경우
                return RentStatus.RENT_SUCCESS;
            } else {
                return RentStatus.RENT_FAIL;
            }
        }
        return RentStatus.RENT_FAIL;
    }

}
