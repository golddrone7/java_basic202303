package day13;

import java.util.Comparator;

import static day13.Menu.menuList;

public class Finding {
    public static void main(String[] args) {
        // 메뉴 목록에서 채식주의가 먹을 수 있는 요리가
        // 하나라도 존재하는가?
        boolean flag1 = menuList.stream()
                .anyMatch(d -> d.isVegeterian());
        System.out.println("flag1 = " + flag1);

        boolean flag2 = menuList.stream()
                .anyMatch(d -> d.getCalorise() < 100);
        System.out.println("flag2 = " + flag2);

        // 메뉴 목록의 모든 요리가 1000칼로리 미만인가?
        boolean flag3 = menuList.stream().allMatch(d -> d.getCalorise() < 1000);
        System.out.println("flag3 = " + flag3);

        // nonMatch : allMatch의 반대연산
        boolean flag4 = menuList.stream().noneMatch(d -> d.getCalorise() < 1000);
        System.out.println("flag4 = " + flag4);


        Dish dish = menuList.stream()
                .min(Comparator.comparing(d -> d.getCalorise()))
                .get();
        System.out.println("dish = " + dish);



    }
}
