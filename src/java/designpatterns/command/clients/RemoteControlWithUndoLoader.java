package java.command.clients;

import java.command.commands.*;
import java.command.invokers.RemoteControlWithUndo;
import java.command.receivers.GarageDoor;
import java.command.receivers.Light;
import java.command.receivers.Stereo;

public class RemoteControlWithUndoLoader {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // the invoker
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        // the receiver of the request
        Light light1 = new Light("Kitchen");
        // create command and pass the receiver to it
        LightOnCommand kitchenLightOn = new LightOnCommand(light1);
        LightOffCommand kitchenLightOff = new LightOffCommand(light1);

        Light light2 = new Light("Bathroom");
        LightOnCommand bathroomLightOn = new LightOnCommand(light2);
        LightOffCommand bathroomLightOff = new LightOffCommand(light2);

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);

        Stereo stereo = new Stereo();
        StereoOnWithCDCommand stereoOnCommand = new StereoOnWithCDCommand(stereo);

        NoCommand noCommand = new NoCommand();

        remoteControl.setCommand(0, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(1, bathroomLightOn, bathroomLightOff);
        remoteControl.setCommand(2, garageDoorOpenCommand, noCommand);
        remoteControl.setCommand(3, stereoOnCommand, noCommand);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();

        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();

    }
}
