package day13;

import day07.util.Utility;

import static day07.util.Utility.makeLine;
import static day13.Dish.Type.MEAT;
import static day13.Menu.*;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filtering {
    public static void main(String[] args) {

        // stream의 filter
        // 필터조건에 맞는 데이터들을 필터링

        // 메뉴목록중에 채식주의자가 먹을 수 있는 요리를 알려주세요
        List<Dish> filteredList = menuList.stream()
                .filter(Dish::isVegeterian)
                .collect(toList());// 수집한다

        System.out.println("====== 채식주의자 식용 요리 목록 ======");
//        for (Dish dish : filteredList) {
//            System.out.println(dish);
//        }
        filteredList.forEach(System.out::println);

        // 메뉴 목록중에 육류이면서 600칼로리 미만인 요리 필터링해서 출력
        makeLine();

        menuList.stream()
                .filter(d -> d.getType() == MEAT && d.getCalorise() < 600)
                .collect(toList())
                .forEach(d -> System.out.println(d));

        String greeting = "hello world!";
        String upperCase = greeting.toUpperCase();
        String substring = upperCase.substring(0, 5);
        char c = substring.charAt(3);

        char c1 = greeting.toUpperCase().substring(0, 5).charAt(3);

        makeLine();
        makeLine();
        // 메뉴 목록에서 요리의 이름이 4글자인 요리들만 필터링해서 출력

        menuList.stream().filter(m -> m.getName().length() == 4)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        makeLine();

        // 원하는 개수만 필터링하기
        // 칼로리가 300칼로리보다 큰 요리 중 앞에서 3개만 필터링
        menuList.stream()
                .filter(d -> d.getCalorise() > 300)
                .limit(3) // 앞에서부터 3개 출력, 먼저 정렬부터 하고 상위 3개를 하면 게시판 좋아요 순으로 호출 가능
                .collect(toList())
                .forEach(d -> System.out.println(d));
        makeLine();
        // 칼로리가 300칼로리보다 높은 요리 중 처음 2개는 제끼고 필터링
        menuList.stream()
                .filter(d -> d.getCalorise() > 300)
                .skip(2) // 맨앞 2개 제외
//                .limit(3)
                .collect(toList())
                .forEach(d -> System.out.println(d));
        makeLine();
        // 메뉴 목록에서 처음 등장하는 2개의 고기요리를 필터링해서 리스트에 반환
        List<Dish> meatDishList = menuList.stream()
                .filter(d -> d.getType() == MEAT)
                .limit(2)
                .collect(toList());
//                .forEach(System.out::println);

        System.out.println(meatDishList.size());
        System.out.println(meatDishList);

        makeLine();
        // 리스트에서 짝수만 걸러낸 뒤 중복제거하기
        List<Integer> numbers = List.of(1, 2, 1, 3, 3, 2, 4, 4, 5, 6);
        List<Integer> distinctedList = numbers.stream()
                .filter(d -> d%2==0)
                .distinct()         // 중복 제거
                .collect(toList());
        System.out.println("distinctedList = " + distinctedList);
    }
}
