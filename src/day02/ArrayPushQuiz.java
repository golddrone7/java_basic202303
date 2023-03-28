package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class ArrayPushQuiz {
    static String[] foodList = new String[0];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        음식명을 입력받아서 배열에 순서대로 저장하는 코드
        1. 음식명을 입력받는다
        2. 음식명에 '그만'
            (1) 입력을 누르면 입력받고
            (2) 누르면 삭제하는
            (3) 현재 상태 조회
            (4) 프로그램 종료
        3. 배열의 크기를 1증가 시킴
         */
        outer: while (true){
            System.out.println("#원하는 메뉴가 무엇인가요?");
            int menu=0;
            try{
                System.out.print("[1,2,3,4 입력,삭제,조회,종료] >>");
                menu = Integer.parseInt(br.readLine());
            } catch (Exception e){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                continue;
            }
            switch (menu){
                case 1:
                    System.out.println("추가할 음식을 입력하세요!");
                    push(br.readLine());
                    break;
                case 2:
                    String food = pop();
                    if(!(food == null))
                        System.out.println(food + "를 삭제했습니다.");
                    break;
                case 3:
                    if(foodList.length>0) {
                        System.out.println("조회한 음식입니다!!");
                        System.out.println(Arrays.toString(foodList));
                    } else {
                        System.out.println("조회할 음식이 없습니다.");
                    }
                    break;
                case 4:
                    System.out.println("시스템 종료!!");
                    break outer;
                default:
                    System.out.println("1,2,3,4번을 입력하세요");
            }
        }
    }
    private static void push(String food) {
        String[] temp = new String[foodList.length+1];
        for (int i = 0; i < foodList.length; i++) {
            temp[i] = foodList[i];
        }
        temp[temp.length-1] = food;
        foodList = temp;
        temp = null;

        System.out.println("추가 완료했습니다!");
    }

    private static String pop() {

        if(foodList.length>0) {
            String deltaData = foodList[foodList.length - 1];
            String temp[] = new String[foodList.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = foodList[i];
            }
            foodList = temp;
            temp = null;
            System.out.println();
            return deltaData;
        }
        System.out.println("삭제할 데이터가 없습니다");
        return null;
    }
}
