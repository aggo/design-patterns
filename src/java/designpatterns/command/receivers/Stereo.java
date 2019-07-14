package java.command.receivers;

public class Stereo {
    public void on() {
        System.out.println("Stereo turned on.");
    }

    public void off() {
        System.out.println("Stereo turned off.");
    }

    public void setCd() {
        System.out.println("CD was set.");
    }

    public void setVolume(int value) {
        System.out.println("Volume set to " + value);
    }
}
