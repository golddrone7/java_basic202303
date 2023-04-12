package day12.lambda;

import day05.member.Gender;
import day05.member.Member;
import day06.modi.pac1.A;
import day07.util.Utility;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static day12.lambda.FilterApple.*;
import static day12.lambda.MappingApple.map;
import static day12.lambda.MappingApple.mappingAppleByColor;

public class Main {
    public static void main(String[] args) {

        // 사과 바구니 생성
        List<Apple> appleBasket = List.of(
            new Apple(80, Color.GREEN)
                , new Apple(155 , Color.GREEN)
                , new Apple(120, Color.RED)
                , new Apple(97, Color.RED)
                , new Apple(200, Color.GREEN)
                , new Apple(50, Color.RED)
                , new Apple(85, Color.YELLOW)
                , new Apple(75, Color.YELLOW)
        );
        System.out.println("======= 녹색 사과 필터링 =======");
        List<Apple> greenApples = filterGreenApples(appleBasket);
        for (Apple greenApple : greenApples) {
            System.out.println(greenApple);
        }

        System.out.println("====== 노랑 사과 필터링 ======");
        List<Apple> colorApples = filterApplesByColor(appleBasket, Color.YELLOW);
        for (Apple ca : colorApples) {
            System.out.println(ca);
        }

        // 100kg 이하 사과들
        System.out.println("====== 원하는 조건으로 필터링======");
        List<Apple> filterApples = filterApples(appleBasket, new LightApplePredicate()); // 다형성의 원리에 의해서 자식 객체는 부모 타입에 저장될 수 있음 상
        for (Apple filterApple : filterApples) {
            System.out.println(filterApple);
        }
        Utility.makeLine();
        System.out.println("====== 빨강 사과 필터링 ======");
        // 빨강 사과 필터링
        List<Apple> filterApples1 = filterApples(appleBasket, apple -> apple.getColor() == Color.RED
        );

        for (Apple apple : filterApples1) {
            System.out.println(apple);
        }
        Utility.makeLine();

        // 녹색이면서 100g보다 큰 사과들만 필터링 (익명)
        List<Apple> filterApples2 = filterApples(appleBasket, a -> a.getColor() == Color.GREEN && a.getWeight() > 100);

        for (Apple apple : filterApples2) {
            System.out.println(apple);
        }

        Utility.makeLine();

        filter(appleBasket, apple-> apple.getWeight()>= 100
                            && apple.getWeight() <= 150);


        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8);

        List<Integer> kkk = filter(numbers, n -> n % 2 == 0);
        for (Integer integer : kkk) {
            System.out.println(integer);
        }

        List<String> wordList = List.of(
                "moments", "hello", "apple", "banana", "ace"
                , "base", "zebra"
        );

        List<String> filter1= filter(wordList, w->w.length() == 5);
        System.out.println("filter1 = " + filter1);

        System.out.println();
        List<String> filter3 =
                wordList.stream().filter(w -> w.length() <= 5)
                        .collect(Collectors.toList());
        System.out.println(filter3);

        Utility.makeLine();

        List<Color> colors = mappingAppleByColor(appleBasket);

        // 회원정보에서 회원의 닉네임만 추출
        List<Member> memberList = List.of(
                new Member(1, "abc@ddd.com", "1234", "홍길동", Gender.MALE, 33),
                new Member(2, "abc@ddd.com", "4444", "김길동", Gender.MALE, 33),
                new Member(3, "abc@ddd.com", "3333", "이길동", Gender.MALE, 33),
                new Member(4, "abc@ddd.com", "5555", "박길동", Gender.FEMALE, 33),
                new Member(5, "abc@ddd.com", "1111", "송길동", Gender.MALE, 33)
        );

        List<String> nameList = map(memberList, new GenericFunction<Member, String>() {
            @Override
            public String apply(Member m) {
                return m.memberName;
            }
        });
        System.out.println("nameList = " + nameList);
    }

}
