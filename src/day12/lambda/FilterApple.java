package day12.lambda;

import day06.modi.pac1.A;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// 사과를 여러 방법으로 필터링
public class FilterApple {
    /**
     * @solution - try1: 사과바구니에서 녹색사과만 필터링해야 한다
     *
     * @problem
     * - 만약에 다른 색깔의 사과를 필터링해야한다면?
     * - 새로운 메서드가 필요하다
     *
     * @param1 basket : 여러 사과가 모여있는 바구니
     * @return : 녹색사과들만 모여있는 바구니
     *
     */
    public static List<Apple> filterGreenApples(List<Apple> basket){
        // 녹색사과만 담을 바구니
        List<Apple> greenApples = basket.stream().filter(apple -> apple.getColor() == Color.GREEN).collect(Collectors.toList());
        // 반복문을 통해 필터링
        return greenApples;
    }

    /**
     * @solution - try 2 : 색상을 파라미터화 한다.
     * @problem - 만약에 필터기준이 색상이 아니라 무게라면
     */
    public static List<Apple> filterApplesByColor(List<Apple> basket, Color color){
        return basket.stream().filter(apple -> apple.getColor() == color).collect(Collectors.toList());
    }

    public static List<Apple> filterApplesByWeight(List<Apple> basket, int weight){
        return basket.stream().filter(apple -> apple.getWeight() == weight).collect(Collectors.toList());
    }

    /**
     * @solution - try 3 : 동작을 파라미터화 한다. - 추상적 조건으로 필터링
     *
     * @problem
     * - 오렌지바구니를 필터링해야한다면?
     * - 전자제품바구니를 필터링해야된다면?
     */
    public static List<Apple> filterApples(List<Apple> basket, ApplePredicate p){
        List<Apple> filteredApples = new ArrayList<>();
        for(Apple apple : basket){
            if(p.test(apple)){
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }

    /**
     * @solution - try 4 : 제네릭 필터 메서드 생성
     *
     */
    // 제네릭 타입을 쓸 거면 리턴 타입앞에 한번 더 명시를 하자
    public static <T> List<T> filter(List<T> basket, GenericPredicate<T> p){
        List<T> filterList = new ArrayList<>();
        for (T t : basket) {
            if(p.test(t)){
                filterList.add(t);
            }
        }
        return filterList;
    }


}
