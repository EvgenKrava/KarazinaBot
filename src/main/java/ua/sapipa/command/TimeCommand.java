package ua.sapipa.command;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Date;

public class TimeCommand extends Command {

    private static final Logger LOG = Logger.getLogger(TimeCommand.class);

    public TimeCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        try {
            absSender.execute(new SendMessage().setChatId(chat.getId()).setText(new Date().toString()));
        } catch (TelegramApiException e) {
            LOG.error(e);
        }
    }
}
