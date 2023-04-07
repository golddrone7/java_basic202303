package day10.generic;

import java.util.ArrayList;

// T는 복제타입, 나중에 결정되는 타입을 의미
public class Basket<T> {

    private T fruit;
//    ArrayList<Fruit> list = new ArrayList<>();


    public T getFruit() {
        return fruit;
    }

    public void setFruit(T fruit) {
        this.fruit = fruit;
    }
}
