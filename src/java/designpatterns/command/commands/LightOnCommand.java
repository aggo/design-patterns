package java.command.commands;

import java.command.Command;
import java.command.receivers.Light;

// a command is a request
public class LightOnCommand implements Command {
    Light light; // the Receiver of the request

    public LightOnCommand(final Light light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() { //opposite of execute
        light.off();
    }
}
