package day13;

public class Dish {

    // 파이널의 의미, 모든 요리의 이름은 다름 (불변성)
    // final static 모든 요리의 이름이 같고 못바꿈(유일성 불변성)
    private final String name; // 요리 이름
    private final boolean vegeterian; // 채식주의 여부
    private final int calorise; // 칼로리
    private final Type type; // 요리 카테고리

    public enum Type{
        MEAT, FISH, OTHER
    }

    public Dish(String name, boolean vegeterian, int calorise, Type type) {
        this.name = name;
        this.vegeterian = vegeterian;
        this.calorise = calorise;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegeterian=" + vegeterian +
                ", calorise=" + calorise +
                ", type=" + type +
                '}';
    }

    public String getName() {
        return name;
    }

    public boolean isVegeterian() {
        return vegeterian;
    }

    public int getCalorise() {
        return calorise;
    }

    public Type getType() {
        return type;
    }
}
