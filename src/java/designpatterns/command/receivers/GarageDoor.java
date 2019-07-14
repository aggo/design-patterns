package java.command.receivers;

public class GarageDoor {
    public void up() {
        System.out.println("Garage door is open");
    }

    public void down() {
        System.out.println("Garage door went down");
    }

    public void stop() {
        System.out.println("Garage door was stopped");
    }

    public void lightOn() {
        System.out.println("Garage door light was turned on.");
    }

    public void lightOff() {
        System.out.println("Garage door light was turned off.");
    }
}
