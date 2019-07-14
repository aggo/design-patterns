package java.command.commands;

import java.command.Command;
import java.command.receivers.Light;

// a command is a request
public class LightOffCommand implements Command {
    Light light; // the Receiver of the request

    public LightOffCommand(final Light light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
