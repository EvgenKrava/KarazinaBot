package ua.sapipa;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.sapipa.command.Command;
import ua.sapipa.command.DefaultCommand;

import java.util.Map;

public class KarazinaBot extends TelegramLongPollingBot {

    private Map<String, Command> commands;

    public KarazinaBot(Map<String, Command> commands) {
        this.commands = commands;

    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("Have message from user " + update.getMessage().getChat().getUserName() + " " +update.getMessage().getLocation());
        try {
            execute(commands.getOrDefault(update.getMessage().getText().split(" ")[0], new DefaultCommand()).execute(update));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return "KarazinaBot";
    }

    @Override
    public String getBotToken() {
        return "1035330895:AAE0uuAz7zUEMXHQvWNLEDwag5Vo6KSAixk";
    }
}
