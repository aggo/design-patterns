package main.java.designpatterns.command.commands;

import main.java.designpatterns.command.Command;
import main.java.designpatterns.command.receivers.Light;

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
