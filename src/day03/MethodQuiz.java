package day03;

import java.util.Arrays;

import static day03.ArraySearch.indexOf;


public class MethodQuiz {

    static String[] foods = {"떡볶이", "치킨", "파스타"};

    public static void main(String[] args) {
        printFoods();
        push("라면");
        push("김치찌개");
        printFoods();



        int idx = indexOf("파스타");
        int idx2 = indexOf("김치찌개");
        int idx3 = indexOf("짜장면");

        remove("김치찌개");
        remove("망고");

        printFoods();

        boolean flag = include("파스타");
        boolean flag2 = include("양념치킨");

        insert(3, "파인애플");
        modify(2, "닭갈비");

        clear(); // foods 배열 모든 데이터 삭제


    }

    private static void push(String food) {
        String temp[] = new String[foods.length+1];

        for (int i = 0; i < foods.length; i++) {
            temp[i] = foods[i];
        }
        temp[temp.length-1] = food;
        foods = temp;
        temp = null;
    }

    private static void insert(int idx, String food){

        String[] temp = new String[foods.length+1];
        for (int i = 0; i < food.length(); i++) {
            temp[i+1] = temp[i];
        }
        temp[idx] = food;
        foods

    }
    private static void modify(int idx, String food){
        foods[idx] = food;
    }

    public static void clear(){
        foods = null;
    }

    private static boolean include(String food) {
        for (int i = 0; i < foods.length; i++) {
            if(foods[i].equals(food))
                return true;
        }
        return false;
    }

    private static void remove(String food) {

    }

    private static void printFoods() {
        System.out.println(Arrays.toString(foods));
    }

}
