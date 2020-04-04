package main.java.designpatterns.command;

public interface Command {
    public void execute();

    public void undo(); //opposite of execute
}
