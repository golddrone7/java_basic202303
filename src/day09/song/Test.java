package day09.song;

import day04.array.StringList;

public class Test {
    public static void main(String[] args) {

        ArtistRepository ar = new ArtistRepository();
//        ar.addFirstArtist("아이유", "분홍신");
//        ar.addFirstArtist("동방신기", "wrong number");

        Artist foundArtist = ar.findArtistByName("아이율");
        System.out.println(foundArtist);
        System.out.println(ar.isRegistered("아이율"));

        ar.addNewSong("동방신기", "주문");
        ar.addNewSong("동방신기", "풍선");
        ar.addNewSong("동방신기", "Bolero");
        ar.addNewSong("동방신기", "순수 Rising Sun");
        ar.addNewSong("동방신고", "report");

        for (Artist artist : ArtistRepository.artistList) {
            artist.info();
        }

//        ArtistRepository.artistList[0].info();
//        ArtistRepository.artistList[1].info();
        System.out.println("=========================");
        for (String str : ar.getSongList("동방신기")){
            System.out.println(str);
        }
    }
}
