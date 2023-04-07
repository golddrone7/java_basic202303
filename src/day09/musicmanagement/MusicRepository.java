package day09.musicmanagement;

import day06.modi.pac1.A;

import java.util.*;

public class MusicRepository {
    static List<MusicVO> list;

    public static MusicRepository musicRepository = new MusicRepository();

    static {
        list = new ArrayList<>();
    }

    private MusicRepository() {
        list = new ArrayList<>();
    }
    public MusicRepository getInstance(){
        return musicRepository;
    }

    public List<MusicVO> getMusicVOList() {
        return list;
    }

    public int getListSize(){
        return getMusicVOList().size();
    }
    // 노래정보에 작곡가 정보 가사

    public Register register(String artist, String song) {
        for (MusicVO musicVO : list) {
            if(musicVO.getArtist().equals(artist)){
                for (String so : musicVO.getSong()) {
                    if(so.equals(song)){
                        return Register.ALREADY_SONG;
                    }
                }

                musicVO.getSong().add(song);
                return Register.PLUS_SONG;
            }
        }
        list.add(new MusicVO(artist, song));
        return Register.NEW_REGISTER;
    }

    public List<String> searchArtist(String searchArtist) {
        for (MusicVO musicVO : list) {
            if(musicVO.getArtist().equals(searchArtist)){
                return musicVO.getSong();
            }
        }
        return null;
    }

    public void inputLyrics(String sing) {
        ArrayList<MusicVO> arrayList = new ArrayList<>();
        for (MusicVO musicVO : list) {
            for (String song : musicVO.getSong()) {
                if(song.equals(song)){
                    arrayList.add(musicVO);
                    break;
                }
            }
        }
        System.out.printf("# [%s] 곡의 정보 \n", sing);
        System.out.println("==========================");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf("* %d. %s\n", (i+1), arrayList.get(i).getArtist());
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("# 번호를 입력하세요 >> ");
        int num = Integer.parseInt(sc.nextLine());
        MusicVO musicVO = arrayList.get(num-1);
        System.out.printf("# [ %s - %s ] 가사를 입력합니다\n>> ", musicVO.getArtist(), sing);
        String lyrics = sc.nextLine();

        System.out.println("# 가사 등록을 했습니다.");









    }
}
