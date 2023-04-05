package day07.util;

public class Singleton {

    //생성자에 private
    private Singleton(){
        System.out.println("객체가 생성됨!");
    }

    //스스로의 객체 생성
    private static Singleton s = new Singleton();

    // 객체 주소값을 리턴하는 메서드
    public  static Singleton getInstance(){
        return s;
    }


    public void method1(){
        System.out.println("중요한 메서드");
    }

    public void method2(){
        System.out.println("귀한 메서드");
    }



}


