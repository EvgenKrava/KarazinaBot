package ua.sapipa.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TimeTableCommand implements Command {
    @Override
    public SendMessage execute(Update update) {
        return new SendMessage().setChatId(update.getMessage().getChatId()).setText("" +
                "1) 8:30 - 9:50\n" +
                "2) 10:10 - 11:30\n" +
                "3) 12:00 - 13:20\n" +
                "4) 13:40 - 15:00\n" +
                "5) 15:20 - 16:40\n" +
                "6) 17:00 - 18:20\n" +
                "7) 18:40 - 20:00\n");
    }
}
