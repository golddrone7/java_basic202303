package day06.encap;

public class Car {
    private String model; // 모델명
    private int speed; // 현재 속도
    private char mode; // 변속 모드 (D, N, R, P)
    private boolean start; // 시동 온오프 상태

    // 생성자 : 객체가 처음 생성될 때 상태
    public Car(String model){
        this.model = model;
        this.mode = 'P';
//        this.speed = 0;  // 기본적으로 0 생략 가능
//        this.start = false; // 기본적으로 flase
    }

    // setter : 필드값을 제어하기 위한 메서드
    // 필드값을 함부러 접근하지 못하도록 setter를 통해 확인을 하도록 함
    public void setSpeed(int speed){
        if(speed < 0 || speed > 200) return;;
        this.speed = speed;
    }

    // getter : 필드값을 참조하기 위한 메서드
    public int getSpeed(){
        // 필드에는 km로 저장되어 있는데
        // mile 변홚서 줘야함.
        return this.speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public char getMode() {
        return mode;
    }

    public void setMode(char mode) {
        switch (mode){
            case 'D' : case 'R' : case 'N' : case 'P' :
                this.mode = mode;
                break;
            default:
                this.mode = 'P';
        }
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    // 엔진에 연료가 주입되는 기능
    private void inject(){
        System.out.println("연료가 주입됩니다.");
    }
    // 엔진오일이 순환하는 기능
    private void putOil(){
        System.out.println("엔진오일이 순환합니다.");
    }
    // 엔진 실린더가 움직이는 기능
    private void moveCylinder(){
        if (start) {
            System.out.println("실린더가 움직입니다.");
        } else{
            System.out.println("차가 폭발합니다.");
        }
    }
    // 시동 버튼을 누르는 기능(캡슐화), 내부적으로 순서를 정해줌
    public void pressButton(){
        this.start = true;
        inject();
        putOil();
        moveCylinder(); // 순서가 중요할 경우 캡슐화를 해줌, private 처리
        System.out.println("시동이 걸렸습니다.");
    }


}
