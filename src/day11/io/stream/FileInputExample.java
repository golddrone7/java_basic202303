package day11.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputExample {

    public static void main(String[] args) {

        // 윈도우는 정슬래시, 백슬래시 다 됨
        String path = "D:\\java_basic\\src\\day01\\Scope.java";
        try(FileInputStream fis = new FileInputStream(path);){
            int data = 0;
            while(data!=-1) {
                // 아스키코드
                data = fis.read();
                System.out.write(data); // 아스키를 문자로 출력
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}
