package java.command.invokers;

import java.command.Command;

// the remote is the invoker - it gets a command object that can be used to make requests
public class SimpleRemoteControl {
    Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }

}
