package ua.sapipa.command;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TimeTableCommand extends Command {

    private static final Logger LOG = Logger.getLogger(TimeTableCommand.class);

    public TimeTableCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        try {
            absSender.execute(new SendMessage().setChatId(chat.getId()).setText("" +
                    "1) 8:30 - 9:50\n" +
                    "2) 10:10 - 11:30\n" +
                    "3) 12:00 - 13:20\n" +
                    "4) 13:40 - 15:00\n" +
                    "5) 15:20 - 16:40\n" +
                    "6) 17:00 - 18:20\n" +
                    "7) 18:40 - 20:00\n"));
        } catch (TelegramApiException e) {
            LOG.error(e);
        }
    }
}
