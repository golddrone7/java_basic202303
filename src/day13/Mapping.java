package day13;

import day07.util.Utility;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static day07.util.Utility.makeLine;
import static day13.Menu.menuList;

public class Mapping {
    public static void main(String[] args) {

        // stream의 map : 리스트에서 원하는 정보만 추출

        // 메뉴 목록에서 요리의 이름들만 목록으로 추출
        List<String> dishNames = menuList.stream()
                .map(dish -> dish.getName())
                .collect(Collectors.toList());
        System.out.println("dishNames = " + dishNames);

        makeLine();
        List<String> words = List.of(
                "safari", "chrome", "ms edge",
                "opera", "firefox"
        );

        List<Integer> wordLengths = words.stream()
                .map(w -> w.length())
                .collect(Collectors.toList());

        // 메뉴 목록에서 메뉴 이름과 칼로리를 추출하는데
        // 칼로리를 정수가 아닌 문자열로 kcal을 뒤에 붙여서 추출 후
        // 메뉴이름: xxxkcal 로 반복 출력하고 싶음

        List<SimpleDish> simpleDishList = menuList.stream()
                .map(SimpleDish::new)
                .collect(Collectors.toList());

        simpleDishList.forEach(System.out::println);

        makeLine();
        /*
            메뉴 목록에서 칼로리가 500칼로리보다 큰
            음식들을 필터링한 다음에 음식의 이름과 타입만
            추출해서 출력해주세요.
         */
        List<SimpleDish2> simpleDish2 = menuList.stream()
                .filter(d -> d.getCalorise() > 500)
                .limit(3) // 가독성 좋음
                .map(SimpleDish2::new)
                .collect(Collectors.toList());
        simpleDish2
                .forEach(System.out::println);

        makeLine();

        // 메뉴 목록에 있는 요리들의 총 칼로리 수 구하기
        int totalCal = menuList.stream()
                .mapToInt(d -> d.getCalorise()) // int 전용만 mapping
                .sum();

        System.out.println("totalCal = " + totalCal);


        // 육류 메뉴의 평균 칼로리
        double averageCal = menuList.stream()
                .filter(d -> d.getType()== Dish.Type.MEAT)
                .mapToInt(d -> d.getCalorise())
                .average()
                .getAsDouble();
        // Optional 평균 구하다가 터질 수도 있음, length가 0이면 에러남, 방지하기 위해 등장


    }

}
