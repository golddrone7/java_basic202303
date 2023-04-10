package day11.api.system;

import java.util.Arrays;

public class SystemExample {

    public static void main(String[] args) {

        // 운영체제의 현재 시간 읽기, 밀리초로 반환 1/1000초
        // 1970년 1월 1일 자정을 영국 기준으로 측정한 시간
        // 2023년 4월 10일 기준으로 16억초..(스톱워치)
        // 역산해서 년원일 시분초 시간을 만듬

        long time = System.currentTimeMillis();
        System.out.println("time = " + time);

        // 코드

        long time2 = System.currentTimeMillis();
        System.out.println("time2 = " + time2);


        System.out.println("실행 시간 : " + (time2 - time));

        // 배열 카피
        // 속도가 빠름, 정확하게 복사
        int[] arr = {10,20,30};
        int[] copyArr = new int[arr.length];
        // arr의 0번부터 copyArr 0번부터 arr.length만큼 복제할 것임
        System.arraycopy(arr, 0, copyArr, 0, arr.length);

        System.out.println(Arrays.toString(copyArr));
    }

}
