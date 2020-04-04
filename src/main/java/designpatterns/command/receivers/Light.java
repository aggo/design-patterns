package main.java.designpatterns.command.receivers;

public class Light {
    String location = "";

    public Light(String location) {
        this.location = location;
    }

    public Light() {
    }

    public void on() {
        System.out.println(location + ": Light was turned on.");
    }

    public void off() {
        System.out.println(location + ": Light was turned off.");
    }
}
