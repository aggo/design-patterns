package java.command.receivers;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed; //local state representing the speed

    public CeilingFan(final String location) {
        this.location = location;
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
        System.out.println("CF on high");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println("CF on medium");
    }

    public void low() {
        speed = LOW;
        System.out.println("CF on low");
    }

    public void off() {
        speed = OFF;
        System.out.println("CF on off");
    }

    public int getSpeed() {
        return speed;
    }
}
