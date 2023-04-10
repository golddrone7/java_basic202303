package day11.api.obj;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Pen p1 = new Pen(123, "빨강", 1000);
        p1.company = new Company("모나미", "서울");

        Pen p2 = new Pen(123, "빨강", 1000);
        //day11.api.obj.Pen@1554909b 패키지 포함 클래스명, 해시코드(주소값)
        System.out.println("p1 = " + p1.toString());

        System.out.println(p1.equals(new Object()));
        System.out.println(p1.equals(p2));

        // 16진수 값으로 hashCode를 알수 있음
        System.out.println(Integer.toHexString(p1.hashCode()));
        System.out.println(Integer.toHexString(p2.hashCode()));


        // 주소값을 완벽하게 동일하게 생성하지 않음, 그래서 Set은 2개가 됨
        Set<Pen> penSet = new HashSet<>();
        penSet.add(p1);
        penSet.add(p2);
        System.out.println(penSet.size());

    }
}
