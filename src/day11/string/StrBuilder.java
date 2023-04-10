package day11.string;

public class StrBuilder {


    // 50만번 반복할 경우 9084밀리초
    private static void makeString(){
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 500000; i++) {
            s += "A";
        }
        long end = System.currentTimeMillis();
        System.out.println("총 소요 시간: " + (end - start) + "밀리초");
    }
    // 50만번 반복할 경우 16밀리초
    private static void makeStringBuilder(){
        long start = System.currentTimeMillis();
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < 500000; i++) {
            s.append("A");
        }
        long end = System.currentTimeMillis();
        System.out.println("빌더 총 소요 시간: " + (end - start) + "밀리초");
    }
    public static void main(String[] args) {
        makeStringBuilder();
        makeString();

        // 래퍼 클래스
        Integer a = 10; // 오토 박싱
        Character c = 'A';
        Byte b = 1;
        Double d =  11.1;
        // 래퍼 클래스들은 Object를 상속 관계가 생김


    }

}
