package day06.modi.pac2;
import day06.modi.pac1.A;
//import day06.modi.pac1.B;

public class C {

    void test(){
        A a = new A();
//        new A(11); // default
//        new A("zzzz") // private


        a.f1= 10;  // public
//        a.f2 = 20; // default
//        a.f3 = 30; // private

        a.m1(); // public
//        a.m2(); // default
//        a.m3(); // default

//        B b = new B(); // 클래스 접근제한을 걸고 싶으면 default
//        b.x1 = 1;
    }



}

