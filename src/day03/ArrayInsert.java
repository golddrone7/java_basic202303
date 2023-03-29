package day03;

import java.util.Arrays;

public class ArrayInsert {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("원본 배열 : "+Arrays.toString(arr));

        // 20이랑 30사이에 넣고 싶음
        int targetIndex = 0;
        int newData = 99; // 2번 인덱스에 넣어야 함

        // 1. 배열의 사이즈를 먼저 1 늘려놓음
        // 2. 원본배열을 다 복사해놓음
        // 3. 맨 뒤부터 타겟 인덱스까지 한칸씩 뒤로 민다.
        // 4. 타겟 인덱스 자리에 새 데이터를 넣는다.
        // 5. 주소를 바꾼다.

        int[] temp = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        for (int i = temp.length-1; i > targetIndex; i--) {
            temp[i] = temp[i-1];
        }
        temp[targetIndex] = newData;
        arr = temp;
        temp = null;

        System.out.println("변경된 배열 : "+Arrays.toString(arr));









    }

}
