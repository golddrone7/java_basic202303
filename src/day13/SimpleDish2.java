package day13;


import day13.Dish.Type;

// 음식의 이름과 타입
public class SimpleDish2 {
    private final String name;
    private final Type type;

    public SimpleDish2(Dish dish) {
        name = dish.getName();
        type = dish.getType();
    }

    @Override
    public String toString() {
        return "SimpleDish2{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
