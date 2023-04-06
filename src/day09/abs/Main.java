package day09.abs;

public class Main {
    public static void main(String[] args) {
        Pet[] pets = {
                new Dog("해피", "푸들", 2),
                new Dog("초코", "시츄", 3),
                new Dog("최강", "불독", 4),
                new Cat("꾸꾸까까", "러시안블루", 2),
        };

//        new Pet("그냥 동물", "끄냥 종", 1);
//      팀장이 인터페이스, 추상 클래스를 만듬, 명세서 역할
//        GoldFish goldFish = new GoldFish();
//        goldFish.takeNap();
//        goldFish.eat();
        for (Pet pet : pets) {
            pet.eat();
        }


    }
}
