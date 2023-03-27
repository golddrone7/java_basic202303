package day01;

public class Scope {
    public static void main(String[] args) {

        int userNumber = 1000;
        // 자바는 블록단위 스코프를 가짐
        int n1 = 10; // main 블록에서 생성된 변수
        int n2 = 10; // 컨트롤 + D    한줄 복사

        if(true){
            int n3 = n1 + n2;
            System.out.println(n3);
        } // end if
//        System.out.println(n3);
        int i;
        for (i = 0; i<10; i++){
            System.out.println(i);
        } // end for

        int n4 = i + 10;


    } // end main
}
