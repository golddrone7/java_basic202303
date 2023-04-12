package day11.io.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputExample {

    public static void main(String[] args) {
        FileOutputStream fos = null;
        String msg = "멍멍이는~~~ 왈왈~\n하하호호";

        // 데이터를 외부로 내보낼때 출력스트림
        // try with resource 문법
        // try안에 해제해줘야할 객체 생성을 해줌

        try(FileOutputStream s
                    = new FileOutputStream("D:/exercise/dog.txt");) {
            // string을 byte로 풀어줘야함
            fos.write(msg.getBytes());
            System.out.println("파일 저장에 성공!");
        } catch (FileNotFoundException e) {
            System.out.println("파일 저장 처리에 실패했습니다.");
        } catch (IOException e) {
            System.out.println("출력 시스템에 문제가 생겼습니다.");
        }

        /*finally {
            // 자원을 다 쓰고 나면 스트림을 닫는 처리를 함
            // null이 아닐때만 닫는 처리
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/


    }

}
