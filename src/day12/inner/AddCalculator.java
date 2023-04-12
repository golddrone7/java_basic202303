package day12.inner;

public class AddCalculator implements Calculator {

    String model;

    @Override
    public int operate(int n1, int n2) {
        return n1 + n2;
    }
}
