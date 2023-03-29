package day03;

import java.util.Arrays;

public class MethodBasic {

    // 함수 : 코드블록의 기능적 표현
    // ex ) add(10, 20)
    // 메서드 : 객체의 동작 표현
    // ex ) 샤프계산기.add(10, 20)
    //      카시오계산기.add(20, 30)

    // 자바는 모든것을 객체로 표현하고, 함수마저도 모두
    // 메서드로 처리한다.
    // 자바의 메서드는 클래스 내부에만 선언이 가능

    // 다른 메서드 안에서 선언할 수 없음.

    // 2개의 정수를 더해서 리턴하는 메서드
    int add(int n1, int n2){
        return n1 + n2;
    }

    static void makeLine(){
        System.out.println("================================");
    }

    // 여러값을 리턴하고 싶은 경우
    // 2개 정수 전달하면 덧셈, 뺄셈, 곱셈 결과 리턴
    static int[] operateAll(int number1, int number2){ // shift + f6 변수 전체 바꾸기

        return new int[]{
                number1 + number2,
                number1 - number2,
                number1 * number2
        };  // 컨트롤 + alt + n (리턴 인라인)   // 컨트롤 + alt + v (리턴에 뺄 때)
    }

    // n개의 정수를 전달받아 총합을 리턴
    static int addAll(int... numbers){
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }


    // 2개의 정수배열을 전달받아
    // 들어있는 숫자의 개수가 더 많은 배열을 리턴하는 메서드

    static int[] compareNumbers(int[] arr1, int... arr2){
        return arr1.length > arr2.length ? arr1 : arr2;
    }

    public static void main(String... args) {
        MethodBasic mb = new MethodBasic();
        mb.add(10, 20);

        makeLine();
        int r1 = addAll(new int[]{10, 20, 30});
        System.out.println("r1 = " + r1);
        int r2 = addAll(10, 20, 30, 100, 200);
        System.out.println("r2 = " + r2);

        System.out.println(Arrays.toString(compareNumbers(new int[]{10,20,30}, 10, 20, 30, 40)));


    }


}
