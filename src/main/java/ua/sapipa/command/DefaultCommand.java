package ua.sapipa.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class DefaultCommand implements Command {
    @Override
    public SendMessage execute(Update update) {
        return new SendMessage().setChatId(update.getMessage().getChatId()).setText("Command not found!");
    }
}
