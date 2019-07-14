package java.command.commands;

import java.command.Command;

/*
A command that can execute other commands
 */
public class MacroCommand implements Command {
    Command[] commands;
    String name;

    public MacroCommand(Command[] commands, String name) {
        this.commands = commands;
        this.name = name;
    }

    public void execute() {
        System.out.println(name);
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
        System.out.println("\n\n");
    }

    @Override
    public void undo() {
        for (int i = commands.length - 1; i >= 0; i--) {
            commands[i].undo();
        }
    }
}
