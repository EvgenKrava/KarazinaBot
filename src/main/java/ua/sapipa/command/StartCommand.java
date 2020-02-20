package ua.sapipa.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StartCommand extends Command {
    private static final Logger LOG = LogManager.getLogger(StartCommand.class);

    public StartCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }


    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        try {
            absSender.execute(new SendMessage().setChatId(chat.getId()).setText("Привет, надеюсь ты  с КБ-31.\nИначе тебе будет не интересно.\nСписок команд: /help"));
        } catch (TelegramApiException e) {
            LOG.error(e);
        }
    }
}
