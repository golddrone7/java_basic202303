package day03;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int korScore = 10;
        int mathScore = 20;
        int engScore = 30;

        int[] kimScores = {korScore, mathScore, engScore};
        int[] parkScores = {100, 34, 99};
        int[] hongScores = {10, 100, 11};

        int[][] classScores = {kimScores, parkScores, hongScores};

        System.out.println(Arrays.toString(classScores));
        System.out.println(classScores[1]);
        System.out.println(parkScores);

        System.out.println(Arrays.deepToString(classScores));

        // 2차원 배열의 값 초기화
        int[][] arr2d = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90},
                {100, 200, 300}
        };
        System.out.println("========================");
        System.out.println(arr2d[1][2]);

        int[] arr3 = arr2d[2];

        // 2차원 배열의 순회
        for (int[] arr : arr2d){
            for(int n : arr){
                System.out.printf("%5d ", n);
            }
            System.out.println();
        }
    }

}
