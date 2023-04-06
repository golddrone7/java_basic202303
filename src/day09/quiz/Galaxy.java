package day09.quiz;

public class Galaxy extends SmartPhone implements Pencil {

    public Galaxy(String model) {
        super(model);
    }

    @Override
    public String information() {
        return "갤럭시는 "+ getModel() +"에서 만들어졌고 제원은 다음과 같다.\n" +
                makeCall() +
                takeCall() +
                takePicture() +
                charge() +
                "블루투스 펜 탑재 여부: " + bluetoothPen();
    }

    @Override
    public String charge() {
        return "고속충전, 고속 무선 충전\n정전식, 와콤펜 지원\n";
    }

    @Override
    public String takePicture() {
        return  "1300만 듀얼카메라\n";
    }

    @Override
    public String makeCall() {
        return "번호를 누르고 통화버튼을 누름\n";
    }

    @Override
    public String takeCall() {
        return  "전화받기 버튼을 누름\n" ;
    }

    @Override
    public boolean bluetoothPen() {
        return true;
    }
}
