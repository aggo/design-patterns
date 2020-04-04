package main.java.designpatterns.command.clients;

import main.java.designpatterns.command.commands.CeilingFanHighCommand;
import main.java.designpatterns.command.commands.CeilingFanMediumCommand;
import main.java.designpatterns.command.commands.CeilingFanOffCommand;
import main.java.designpatterns.command.invokers.RemoteControlWithUndo;
import main.java.designpatterns.command.receivers.CeilingFan;

public class RemoteControlForCeilingFanLoader {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // the invoker
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        // the receiver of the request
        CeilingFan ceilingFan = new CeilingFan("Living room");

        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        remoteControl.setCommand(0, ceilingFanHighCommand, ceilingFanOffCommand);
        remoteControl.setCommand(1, ceilingFanMediumCommand, ceilingFanOffCommand);

//        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
//        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();

        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
//        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();

    }
}
