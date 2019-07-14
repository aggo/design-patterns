package java.command.clients;

import java.command.commands.CeilingFanHighCommand;
import java.command.commands.CeilingFanMediumCommand;
import java.command.commands.CeilingFanOffCommand;
import java.command.invokers.RemoteControlWithUndo;
import java.command.receivers.CeilingFan;

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
