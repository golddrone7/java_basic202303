package day02;

import java.util.Arrays;

// 1. 원본 배열보다 1개 사이즈가 더 큰 새 배열 생성
// 2. 원본 배열 데이터 새 배열로 복사
// 3. 새로운 데이터를 새 배열의 끝 인덱스에 추가
// 4. 주소값 이전
public class ArrayPush {

    public static void push(int newData){
        // 1. 원본 배열보다 1개 사이즈가 더 큰 새 배열 생성
        int[] temp = new int[arr.length + 1];

        // 2. 원본 배열 데이터 새 배열로 복사
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        // 3. 새로운 데이터를 새 배열의 끝 인덱스에 추가
        temp[temp.length-1] = newData;
        // 4. 주소값 이전
        arr = temp;
        temp = null;

    }

        // 새로운 데이터를 배열에 맨 끝에 추가
    static int[] arr = {10, 20, 30};
    public static void main(String[] args) {
        int newData = 40;
        push(newData);
        push(40);
        push(100);
        push(1500);
        push(3000);
        push(4500);
        push(6000);
        System.out.println(Arrays.toString(arr));



    }

}
