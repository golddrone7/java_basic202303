package day09.quiz;

public abstract class SmartPhone implements Camera, PhoneCall{
    private String model;

    public abstract String information();
    public abstract String charge();

    public SmartPhone(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
