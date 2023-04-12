package day12.inner;

public class Main {

    // 내부 클래스 (inner class) 메인에서만 사용 가능
    private static class SubCalculator implements Calculator {
        public int operate(int a, int b){
            return a-b;
        }
    }


    public static void main(String[] args) {

        // 덧셈 계산을 하는 계산기를 만들어서 쓰고 싶다.
        Calculator addCal = new AddCalculator();
        System.out.println(addCal.operate(30, 50));

        // 뺄셈 계산을 하는 계산기가 필요
        Calculator subCal = new SubCalculator();
        System.out.println(subCal.operate(100, 40));

        // 곱셈 계산을 하는 계산기가 필요 (익명 클래스)
        Calculator multiCal = new Calculator() {

            //필드 선언
            private String name;


            @Override
            public int operate(int n1, int n2) {
                return n1 * n2;
            }
        };
        System.out.println(multiCal.operate(10, 20));

        // 나눗셈을 하는 계산기 (람다) : 인터페이스의 추상메서드 딱 1개일때만

        Calculator divCal = (n1, n2) ->   n1 / n2;
        System.out.println(divCal.operate(50, 10));


        // 1회용 강아지
        Pet dog = new Pet() {
            @Override
            public void eat() {
                System.out.println("강아지는 개사료를 먹어요");
            }
            @Override
            public void play() {
                System.out.println("강아지는 마당에서 놀아요");
            }
        };


    }
}
