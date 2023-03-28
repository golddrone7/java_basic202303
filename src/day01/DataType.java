package day01;

public class DataType {
    public static void main(String[] args) {

        // 0011 1110 1000, 1000
        // 8bit == 1byte
        // 1024byte == 1kb
        long money = 21474836470L;   // short 는 2byte, int는 21억, 4byte  long은 8byte

//        100; // 100을 메모리에 저장, 16진수 주소 저장 (정수리터럴 4바이트 할당)
//        int a;  // 4바이트공간 할당 이름을 a부여
//        a= 100; // 미리 저장된 100을 a에 복사

        // L을 써줘야하는 이유는 정수 리터럴은 4바이트까지만 할당하기 때문임!!!
        // L은 정수리터럴 4바이트를 8바이트로 늘리는 역할을 함

        // 실수리터럴은 기본 8바이트 할당
        // float 4바이트 : 다운캐스팅 F를 붙여주자
        float f1 = 1.23456789F;
        System.out.println("f1 = " + f1); // soutv

        double d1 = 1.23445333848753784;
        System.out.println("d1 = " + d1); // 컨트롤 + shift + f10 실행하기
        // 8바이트 더 늘릴려면 객체를 써야함

        boolean TRUE = true;

        // 논리타입
        boolean b1 = true;
        boolean b2 = false;

        boolean b3 = TRUE;

        // 문자 타입 : 한글자
        char c1 = 'A';
        System.out.println((char)(c1 + 1));

        char c2 = 44032;
        System.out.println("c2 = " + c2);

        // 기본타입이 아니라 객체다
        String s = "Hello";


    }

}
