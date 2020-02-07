package ua.sapipa.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class LeftCommand implements  Command {
    @Override
    public SendMessage execute(Update update) {
        return null;
    }
}
