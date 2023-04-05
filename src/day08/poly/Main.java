package day08.poly;

public class Main {
    public static void main(String[] args) {
        // 객체는 항상 역할에 의존해야지 구현체에 의존하면 안됨
        // 내가 편의점 사장이야, 알바라는 역할이 잇잖아
        // 알바한테 역할을 의존을 해야지 알바생중에 장동건을 의지하면 안된다.
        // 누구든 알바의 역할을 대체해야함
        // 뮤지컬을 해야하는데 조승우를 뽑음, 조승우에 의존을 하게 되면 공연을 못함.

        Computer com = new Computer();
        LgMonitor lgMonitor = new LgMonitor();
        com.monitor = lgMonitor;

        // 모니터 교환
        com.monitor = new HpMonitor();
        com.monitor = new LgMonitor();

    }
}
