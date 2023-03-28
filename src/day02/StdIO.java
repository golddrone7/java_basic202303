package day02;

import java.io.IOException;
import java.util.Scanner;

public class StdIO {

    public static void main(String[] args) throws IOException {

        String dog = "멍멍이", cat = "야옹이";

        System.out.print(dog + "\n"); // 컨트롤 + shift + f10
        System.out.println(cat);

        int month = 10;
        int day = 3;
        String anni = "개천절";
        // %d 정수, %s 문자열, %f 실수
        System.out.printf(month + "월 " + day + "일은 " + anni + "입니다.\n", month, day, anni);
        double rate = 25.4567;
        System.out.printf("%d", 10); // souf 엔터
        // %f : 무조건 자리수 6자리로 표현
        System.out.printf("오늘의 할인율은 %.4f입니다.\n", rate);
        System.out.printf("오늘의 할인율은 %.2f입니다.\n", rate);
        System.out.printf("오늘의 할인율은 %.8f입니다.\n", rate);
        System.out.printf("오늘의 할인율은 %.1f입니다.\n", rate);

        // 표준 입력
//        int result = System.in.read(); // alt + enter 예외처리, 컨트롤 alt + v
        var sc = new Scanner(System.in); // 자바가 훔쳐온 동적 변수 var

//        int result = sc.nextInt();

        String str = sc.nextLine();
        int result = 0;
        try {
            // str을 정수변환
            result = Integer.parseInt(str);
        } catch (Exception e) {
            System.out.println("정수로 입력하거라~");
        }
                                            // 와리가리 컨트롤 + 쉬프트 + 위 || 아래
        System.out.println("result = " + result); // 줄맞춤 CTRL+ALT+L

    }
}

