package main.java.designpatterns.command.clients;

import main.java.designpatterns.command.Command;
import main.java.designpatterns.command.commands.*;
import main.java.designpatterns.command.invokers.RemoteControlWithUndo;
import main.java.designpatterns.command.receivers.GarageDoor;
import main.java.designpatterns.command.receivers.Light;
import main.java.designpatterns.command.receivers.Stereo;

public class MacroCommandsRemoteLoader {
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
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);

        Stereo stereo = new Stereo();
        StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);

        NoCommand noCommand = new NoCommand();

        Command[] arrivedHomeCommands = {garageDoorOpen, kitchenLightOn, stereoOn};
        Command[] goingToSleepCommands = {kitchenLightOff, bathroomLightOn};

        MacroCommand arrivedHomeMacro = new MacroCommand(arrivedHomeCommands, "Arrived home!");
        MacroCommand goingToSleepMacro = new MacroCommand(goingToSleepCommands, "Going to sleep!");
        remoteControl.setCommand(0, arrivedHomeMacro, noCommand);
        remoteControl.setCommand(1, goingToSleepMacro, noCommand);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);

        remoteControl.onButtonWasPushed(1);
        remoteControl.undoButtonWasPushed();
    }
}
