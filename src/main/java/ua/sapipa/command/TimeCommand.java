package ua.sapipa.command;

import com.google.inject.internal.cglib.core.$Customizer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Date;

public class TimeCommand implements Command {


    @Override
    public SendMessage execute(Update update) {
        return new SendMessage().setChatId(update.getMessage().getChatId()).setText(new Date().toString());
    }
}
