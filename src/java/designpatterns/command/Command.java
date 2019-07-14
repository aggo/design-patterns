package java.command;

public interface Command {
    public void execute();

    public void undo(); //opposite of execute
}
