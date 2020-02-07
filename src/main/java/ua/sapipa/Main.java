package ua.sapipa;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import ua.sapipa.command.Command;
import ua.sapipa.command.HelpCommand;
import ua.sapipa.command.StartCommand;
import ua.sapipa.command.TimeCommand;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws TelegramApiRequestException {
        Map<String, Command> commands = new HashMap<>();
        commands.put("/time", new TimeCommand());
        commands.put("/help", new HelpCommand());
        commands.put("/start", new StartCommand());
        commands.put("/today", new StartCommand());
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        telegramBotsApi.registerBot(new KarazinaBot(commands));
    }
}
