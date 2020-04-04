package main.java.designpatterns.command.clients;

import main.java.designpatterns.command.commands.GarageDoorOpenCommand;
import main.java.designpatterns.command.commands.LightOnCommand;
import main.java.designpatterns.command.invokers.SimpleRemoteControl;
import main.java.designpatterns.command.receivers.GarageDoor;
import main.java.designpatterns.command.receivers.Light;

// this is our client
public class SimpleRemoteControlTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // the invoker
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();

        // -- scenario 1
        // the receiver of the request
        Light light = new Light();
        // create command and pass the receiver to it
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        // pass command to invoker
        remoteControl.setCommand(lightOnCommand);
        // simulate the button being pressed
        remoteControl.buttonWasPressed();



        //--- scenario 2
        // the receiver of the request
        GarageDoor garageDoor = new GarageDoor();
        // create command and pass the receiver to it
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        // pass command to invoker
        remoteControl.setCommand(garageDoorOpenCommand);
        // simulate the button being pressed
        remoteControl.buttonWasPressed();
    }
}
