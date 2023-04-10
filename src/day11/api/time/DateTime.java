package day11.api.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateTime {

    public static void main(String[] args) {

//        Date date = new Date();
        // 싱글톤, 하나의 객체를 반환
//        Calendar calendar = Calendar.getInstance();
        // 치명적인 단점 , 달은 0부터 표현
        // 월 정보를 더할 때는 1을 더함

        // 현재 날짜 정보 얻기 (연, 월, 일)  ex) 책 도서 예약 시스템
        LocalDate nowDate = LocalDate.now();
        System.out.println("nowDate = " + nowDate);

        // 시, 분, 초     ex) 피시방 예약
        LocalTime nowTime = LocalTime.now();
        System.out.println("nowTime = " + nowTime);

        // 연월일시분초
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("nowDateTime = " + nowDateTime);

        // 원하는 날짜정보만 얻기
        System.out.println(nowDateTime.getMonth()); // 365일 중에 몇일인가?
        // 특정 날짜 만들기
        LocalDateTime targetDate = LocalDateTime.of(2023, 5, 5, 9, 0, 0);
        System.out.println("targetDate = " + targetDate);

        // 날짜 연산
        // 도서 대여 시스템 빌린 날짜로부터 3일 후가 반납일
        LocalDateTime rentalDate = LocalDateTime.now();
        LocalDateTime returnDate = rentalDate.plusDays(3);
        System.out.println("returnDate = " + returnDate);

        // 빌더 패턴
        LocalDateTime targetDateTime = returnDate
                                    .plusYears(1)
                                    .plusMonths(3)
                                    .plusDays(10)
                                    .plusHours(5);

        // 사이 날짜 구하기 D-day
        LocalDate b = LocalDate.of(2019, 12, 28);
        LocalDate d = LocalDate.of(2023, 3, 10);
        long between = ChronoUnit.DAYS.between(b, d);
        System.out.println("between = " + between);


        System.out.println("nowDateTime = " + nowDateTime);

        // 날짜 포맷 바꾸기
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 a hh시 mm분");

        System.out.println("nowDateTime.format(pattern) = " + nowDateTime.format(pattern));
        

    }
}
