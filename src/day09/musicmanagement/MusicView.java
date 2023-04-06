package day09.musicmanagement;

import java.util.List;
import java.util.Scanner;

public class MusicView {
    static Scanner sc;
    static MusicRepository instance;

    static {
        sc = new Scanner(System.in);
        instance = MusicRepository.musicRepository.getInstance();
    }
    public MusicView() {
//        instance = MusicRepository.musicRepository.getInstance();
    }
    public static String input(String s){
        System.out.print(s);
        return sc.nextLine();
    }
    public static void menu(){
        System.out.println("**** 음악 관리 프로그램 ****");
        System.out.printf("# 현재 등록된 가수 : %d명\n", instance.getListSize());
        System.out.println("# 1. 노래 등록하기");
        System.out.println("# 2. 노래 정보 검색");
        System.out.println("# 3. 프로그램 종료");
        System.out.println("# 4. 가사 등록하기");
        System.out.println("=========================");
    }
    public static void run(){
        outer:while (true) {
            int userNum;
            menu();
            try {
                userNum = Integer.parseInt(input(">>"));
                if(userNum<1 || 4 < userNum) throw new Exception();
            } catch (Exception e) {
                System.out.println("유효한 숫자가 아닙니다.");
                continue;
            }

            switch (userNum){
                case 1:
                    System.out.println("# 노래 등록을 시작합니다.");
                    String artist = input("- 가수명: ");
                    String song = input("- 곡명: ");
                    Register rs= instance.register(artist, song);
                    if(rs==Register.NEW_REGISTER){
                        System.out.printf("#아티스트 %s님이 신규 등록되었습니다.\n", artist);
                    } else if(rs==Register.ALREADY_SONG){
                        System.out.printf("# [%s]은(는) 이미 등록된 노래입니다\n", song);
                    } else{
                        System.out.printf("# %s님의 노래목록에 '%s'곡이 추가되었습니다.\n", artist, song);
                    }
                    break;
                case 2:
                    String searchArtist = input("# 검색할 가수명을 입력하세요.\n - 가수명 : ");
                    List<String> list = instance.searchArtist(searchArtist);
                    if(list==null){
                        System.out.println("# 해당 가수는 등록되지 않았습니다.");
                    }else {
                        System.out.printf("# %s님의 노래목록\n\n", searchArtist);
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println("* " + (i+1) +"."+ list.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
                case 4:
                    String sing= input("# 가사를 등록하고자 하는 곡명을 입력하세요\n - 곡명 : ");
                    instance.inputLyrics(sing);

            }



        }

    }

}
