package ua.sapipa.command;


import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.sapipa.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TodayCommand extends Command {

    private static final Logger LOG = Logger.getLogger(TodayCommand.class);

    public TodayCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    protected String text() {
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new File("src/main/resources/"
                + (Util.isEven() ? 2 : 1)
                + File.separator
                + LocalDateTime.now().getDayOfWeek()
                + ".txt"))
        ) {
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            LOG.error(e);
            return "See you later alligator!";
        }
        return stringBuilder.toString();
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        try {
            absSender.execute(new SendMessage().setChatId(chat.getId()).setText(text()));
        } catch (TelegramApiException e) {
            LOG.error(e);
        }
    }
}
