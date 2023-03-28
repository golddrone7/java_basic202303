package day02;

public class StdIO {

    public static void main(String[] args) {

        String dog = "멍멍이", cat = "야옹이";

        System.out.print(dog + "\n"); // 컨트롤 + shift + f10
        System.out.println(cat);

        int month = 10;
        int day = 3;
        String anni = "개천절";
        // %d 정수, %s 문자열, %f 실수
        System.out.printf(month + "월 " + day + "일은 " + anni + "입니다.\n", month, day, anni);
        double rate = 25.4567;
        // %f : 무조건 자리수 6자리로 표현
        System.out.printf("오늘의 할인율은 %.4f입니다.\n", rate);

        System.out.printf("%d", 10); // souf 엔터
    }
}

