package main.java.designpatterns.command.commands;

import main.java.designpatterns.command.Command;
import main.java.designpatterns.command.receivers.Light;

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
