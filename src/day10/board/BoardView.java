package day10.board;

import day07.util.Utility;

import java.util.Map;
import java.util.Scanner;

public class BoardView {

    static Map<Integer, BoardVO> map = BoardRepository.map;
    static int lastPage = BoardVO.getNo();  // 마지막 페이지를 알 수 있음
    static int page = lastPage;
    static int endPage = lastPage%10==0 ? lastPage/10 : lastPage/10+1;
    static int currentPage = 1;
    // 제목 30글자 (숫자+영어),
    static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    public static String input(String s){
        System.out.print(s);
        return sc.nextLine();
    }


    public static void menu(){

        System.out.println("No                제목             글쓴이    작성시간   좋아요");
        System.out.println("============================================================");
        page -= (currentPage-1)*10;
        for (int i = page; i > page-10 ; i--) {
            BoardVO vo = map.get(i);
            if(vo==null) break;
            System.out.printf("%-4d%-30s%-8s%10s%5d\n", vo.getNum(), vo.getTitle(), vo.getWriter(), vo.getDate(), vo.getLike());
        }
        System.out.println("============================================================");
        System.out.printf("[ < 이전 ] |");
        for (int i = 1; i < 6; i++) {
            if(i>endPage) break;
            if(currentPage<=2)
                System.out.printf(" %d |", i);
            else if(currentPage<=endPage-5){
                System.out.printf(" %d |", (currentPage+i-2) );
            } else {
                System.out.printf(" %d |", (endPage+i-5) );
            }
        }
        System.out.printf(" [ 다음 > ]  ");
        System.out.printf("현재 페이지 : %d\n", currentPage);
        System.out.println("[ < ] 이전 페이지");
        System.out.println("[ > ] 다음 페이지");
        System.out.println("[ Q ] 종료하기");
        System.out.printf("[1~%d] 해당 게시물 보기\n", lastPage);

        System.out.println("총 페이지 수 : " + lastPage);
    }

    public static void run(){
        while (true) {
            menu();
            String userInput = input(">> ");
            boardLosic(userInput);
        }

    }

    /** 보드 로직 작성
     * 
     * @param userInput 사용자 입력에 따른 분기점
     */
    private static void boardLosic(String userInput) {
        switch (userInput.toLowerCase()){
            case "<":
                prevPage();
                break;
            case ">":
                nextPage();
                break;
            case "quit":
                System.out.println("게시판 프로그램을 종료합니다.");
                System.exit(0);
            default:
                break;
        }
    
    }
    private static void prevPage(){
        currentPage-=1;
    }
    
    private static void nextPage() {
        currentPage+=1;
    }
}
