package java.command.invokers;

import java.command.Command;
import java.command.commands.NoCommand;

import java.util.Stack;

public class RemoteControlWithRepeatedUndo {
    Command[] onCommands;
    Command[] offCommands;
    Stack<Command> undoCommands = new Stack<>();

    public RemoteControlWithRepeatedUndo() {
        onCommands = new Command[4];
        offCommands = new Command[4];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 4; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommands.push(noCommand);
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommands.push(onCommands[slot]); //save a reference to it in order to have it accessible on undo
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommands.push(offCommands[slot]); //save ref to it
    }

    public void undoButtonWasPushed() {
        // invoke the undo method of the command stored in undoCommand
        while (!undoCommands.empty()) {
            undoCommands.pop().undo();
        }
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------Remote Control-------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] "
                    + onCommands[i].getClass().getName()
                    + "  "
                    + offCommands[i].getClass().getName() + "\n");
        }
        stringBuff.append("[undo] " + undoCommands.getClass().getName());
        return stringBuff.toString();
    }

}
