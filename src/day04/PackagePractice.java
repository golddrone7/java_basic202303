package day04;


//import fruit.Banana;
import fruit.*; // *은 class자리에만 쓸 수 있음
import fruit.warm.PineApple;

// 패키지 이름 룰 (절대 안겹치게 하기 위해)
// 개인의 도메인 주소, 웹 도메인 주소를 패키지로 씀
// com.naver.warm (거꾸로 씀)
// kr.co.samsung.warm


public class PackagePractice {
    public static void main(String[] args) {
        new juice.Apple();
        Banana banana = new Banana();
        new Grape();
        new java.util.Scanner(System.in);
        new fruit.warm.PineApple();


    }

}
