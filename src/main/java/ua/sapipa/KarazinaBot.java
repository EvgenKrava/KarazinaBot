package ua.sapipa;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.sapipa.command.*;

public class KarazinaBot extends TelegramLongPollingCommandBot {

    private static final Logger LOG = Logger.getLogger(KarazinaBot.class);

    public KarazinaBot() {
        register(new StartCommand("start", "Start command!\n"));
        register(new HelpCommand("help", "Available commands\n"));
        register(new LeftCommand("left", "Time left\n"));
        register(new ListCommand("list", "Group list\n"));
        register(new TimeCommand("time", "Current time\n"));
        register(new TimeTableCommand("timetable", "Time table\n"));
        register(new TodayCommand("today", ""));
        register(new TomorrowCommand("tomorrow", ""));
        register(new VladCommand("vlad", ""));
        register(new WhoCommand("who", ""));
    }


    @Override
    public String getBotUsername() {
        return "KarazinaBot";
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        try {
            execute(new SendMessage().setChatId(update.getMessage().getChatId()).setText("Не понимаю такое)"));
        } catch (TelegramApiException e) {
            LOG.error(e);
        }
    }

    @Override
    public String getBotToken() {
        return "1035330895:AAE0uuAz7zUEMXHQvWNLEDwag5Vo6KSAixk";
    }
}
