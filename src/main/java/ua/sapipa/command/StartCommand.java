package ua.sapipa.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {
    @Override
    public SendMessage execute(Update update) {

        return new SendMessage().setChatId(update.getMessage().getChatId()).setText("Привет, надеюсь ты  с КБ-31.\nИначе тебе будет не интересно.\nСписок команд: /help");
    }
}
