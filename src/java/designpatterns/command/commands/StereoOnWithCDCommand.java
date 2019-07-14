package java.command.commands;

import java.command.Command;
import java.command.receivers.Stereo;

public class StereoOnWithCDCommand implements Command {
    Stereo stereo;

    public StereoOnWithCDCommand(final Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(7);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
