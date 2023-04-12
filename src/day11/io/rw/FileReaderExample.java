package day11.io.rw;

import day05.member.Member;
import day11.io.RootPath;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderExample {
    public static void main(String[] args) {

        try(FileReader fr = new FileReader(RootPath.ROOT_PATH + "/member.txt")){
            // 유니코드 범위
            // 버퍼 스트림
            BufferedReader br = new BufferedReader(fr);
//            String s = null;
//            while((s = br.readLine())!= null){
//                System.out.println("s = " + s);
//            }

            String s = br.readLine();
            System.out.println("s = " + s);

            String[] split = s.split(",");
            System.out.println(Arrays.toString(split));

//            Member member = new Member(Integer.parseInt(split[0]));

//            int read = fr.read();
//            System.out.println((char)read);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
