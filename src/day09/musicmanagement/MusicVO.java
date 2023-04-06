package day09.musicmanagement;

import day06.modi.pac1.A;

import java.util.ArrayList;
import java.util.List;

public class MusicVO {
    private String artist;
    private List<String> song;
    private List<String> lyrics;
    public MusicVO() {

    }


    public List<String> getSong() {
        return song;
    }

    public void setSong(ArrayList<String> song) {
        this.song = song;
    }

    public MusicVO(String artist, String song) {
        this.artist = artist;
        this.song = new ArrayList<>();
        this.song.add(song);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
