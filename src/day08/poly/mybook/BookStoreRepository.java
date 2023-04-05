package day08.poly.mybook;


import java.util.ArrayList;
import java.util.List;

// 도서관리 시스템 데이터 처리
public class BookStoreRepository {
    // 회원 1명
    private static BookUser bookUser;
    // 도서들의 정보
    private static Book[] books;

   // 마이페이지 기능
    /*
     여기에 있는 bookUser 정보 리턴
     */
    BookUser myPage(){
        return bookUser;
    }




    // 유저를 등록하는 기능
    void register(BookUser userInfo){
        bookUser = userInfo;
    }

    public BookStoreRepository() {
        books = new Book[]{
                new CookBook("백종원의 집밥", "백종원", "tvN", true),
                new CartoonBook("한번 더 해요", "미티", "원모어", 19),
                new CartoonBook("루피의 원피스", "루피", "japan", 12),
                new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false),
                new CookBook("최현석 날 따라해봐", "최현석", "소금책", true),
        };
    }
    public Book[] pageAll() {
        return books;
    }

    public List<Book> selectBook(String search) {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < books.length; i++) {
            if(books[i].getTitle().contains(search)){
                bookList.add(books[i]);
            }
        }
        return bookList;

    }
}
