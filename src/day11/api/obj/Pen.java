package day11.api.obj;

import java.util.List;
import java.util.Objects;

public class Pen extends Object {

    Company company; // 제조 회사

    long serial; // 시리얼 번호
    String color; // 색상
    int price; // 가격

    public Pen(long serial, String color, int price) {
        this.serial = serial;
        this.color = color;
        this.price = price;
    }

    // 개발할 때 hashCode는 출력은 잘 안봄
    // 객체의 필드 데이터를 빠르게 확인해볼 때
    // toString은 재정의가 필수다

    @Override
    public String toString() {
        return "Pen{" +
                "company=" + company +
                ", serial=" + serial +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }


    // Object의 equals는 주소값을 비교를 함
    // 재정의를 해서 원하는 값의 비교를 함
    // 시리얼 번호가 같으면 같은 객체로 보고 싶다
    // equals를 오버라이딩하면 반드시 hashCode도 같이 오버라이딩 해라
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Pen){
            Pen target = (Pen)obj;
            return this.serial == target.serial;
        }
        return  false;
//        if(!(obj instanceof Pen)) return false;
//        if(this.serial == ((Pen)obj).serial)
//            return true;
//        else
//            return false;
    }

    // 내부적으로 serial과 color를 확인해서 둘이 같으면 같은 hashCode를 반환함
    @Override
    public int hashCode() {
        return Objects.hash(serial, color);
    }
}
