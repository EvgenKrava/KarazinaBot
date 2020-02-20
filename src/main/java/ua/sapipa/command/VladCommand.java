package ua.sapipa.command;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class VladCommand extends Command {

    private static final Logger LOG = Logger.getLogger(VladCommand.class);

    public VladCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        try {
            absSender.execute(new SendPhoto().setChatId(chat.getId()).setPhoto(new File("src/main/resources/1/valakas.jpg")));
        } catch (TelegramApiException e) {
            LOG.error(e);
        }
    }
}
