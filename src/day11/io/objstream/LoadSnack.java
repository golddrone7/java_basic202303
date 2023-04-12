package day11.io.objstream;

import day06.modi.pac1.A;
import day11.io.RootPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class LoadSnack {

    private static List<Snack> snackList = new ArrayList<>();

    public static void main(String[] args) {

        loadFile();


        for (Snack s : snackList) {
            System.out.println(s);
        }
    }

    private static void loadFile(){
        try(FileInputStream fis = new FileInputStream(RootPath.ROOT_PATH + "/snack.sav");){
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Snack> object = (List<Snack>) ois.readObject();
            snackList = object;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


}
