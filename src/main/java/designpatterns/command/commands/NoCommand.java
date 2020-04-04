package main.java.designpatterns.command.commands;

import main.java.designpatterns.command.Command;

// a null object - useful when we don't have a meaningful object to return, but want to remove the responsibility of
// handling null from the clients
public class NoCommand implements Command {
    @Override
    public void execute() {
        //        System.out.println("Nothing to be done.");
    }

    @Override
    public void undo() {

    }
}
