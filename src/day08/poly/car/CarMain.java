package day08.poly.car;

import day07.util.Utility;


import static day07.util.Utility.makeLine;

public class CarMain {
    public static void main(String[] args) {
        CarShop shop = new CarShop();
        shop.runTest();

        makeLine();
        Driver park = new Driver();
        park.drive(new Mustang());

        makeLine();
        Mustang mustang = new Mustang();
        mustang.accelerate();
        mustang.powerSound();

        Stinger stinger = new Stinger();
        stinger.accelerate();

        makeLine();

        // 내릴땐 항상 캐스팅을 하자
        // 조건이 하나 있음,
        Car car =  shop.exportCar(5000);

        System.out.println(car instanceof Stinger);
        System.out.println(car instanceof Tucson);
        System.out.println(car instanceof Mustang);
//        System.out.println("car = " + car);

//        car.powerSound();

    }
}
