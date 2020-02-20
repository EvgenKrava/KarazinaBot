package ua.sapipa.command;


import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

public class LeftCommand extends Command {

    private static final Logger LOG = Logger.getLogger(LeftCommand.class);

    private static final LocalDateTime one = LocalDateTime.of(LocalDateTime.now().getYear(),
            LocalDateTime.now().getMonth(),
            LocalDateTime.now().getDayOfMonth(),
            9,
            50);
    private static final LocalDateTime two = LocalDateTime.of(LocalDateTime.now().getYear(),
            LocalDateTime.now().getMonth(),
            LocalDateTime.now().getDayOfMonth(),
            11,
            30);
    private static final LocalDateTime three = LocalDateTime.of(LocalDateTime.now().getYear(),
            LocalDateTime.now().getMonth(),
            LocalDateTime.now().getDayOfMonth(),
            13,
            20);
    private static final LocalDateTime four = LocalDateTime.of(LocalDateTime.now().getYear(),
            LocalDateTime.now().getMonth(),
            LocalDateTime.now().getDayOfMonth(),
            15,
            0);
    private static final LocalDateTime five = LocalDateTime.of(LocalDateTime.now().getYear(),
            LocalDateTime.now().getMonth(),
            LocalDateTime.now().getDayOfMonth(),
            16,
            40);
    private static final LocalDateTime six = LocalDateTime.of(LocalDateTime.now().getYear(),
            LocalDateTime.now().getMonth(),
            LocalDateTime.now().getDayOfMonth(),
            18,
            20);
    private static final LocalDateTime seven = LocalDateTime.of(LocalDateTime.now().getYear(),
            LocalDateTime.now().getMonth(),
            LocalDateTime.now().getDayOfMonth(),
            20,
            0);

    public LeftCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        try {
            LocalDateTime now = LocalDateTime.now();
            if (Objects.equals(now.getDayOfWeek(), DayOfWeek.SATURDAY) || Objects.equals(now.getDayOfWeek(), DayOfWeek.SUNDAY)) {
                absSender.execute(new SendMessage().setChatId(chat.getId()).setText("Сегодня выходной, расслабься!"));
            }
            if (now.isBefore(LocalDateTime.of(LocalDateTime.now().getYear(),
                    LocalDateTime.now().getMonth(),
                    LocalDateTime.now().getDayOfMonth(),
                    8,
                    30)) || now.isAfter(seven)) {
                absSender.execute(new SendMessage().setChatId(chat.getId()).setText("Сейчас нет пары!"));
            }
            LocalDateTime[] localDateTimes = {one, two, three, four, five, six, seven};
            LocalDateTime end = one;
            int num = 0;
            for (int i = 0; i < localDateTimes.length - 1; i++) {
                if (now.isAfter(localDateTimes[i]) && now.isBefore(localDateTimes[i + 1])) {
                    end = localDateTimes[i + 1];
                    num = i + 2;
                }
            }

            long sec = end.toEpochSecond(ZoneOffset.UTC) - now.toEpochSecond(ZoneOffset.UTC);
            LocalDateTime res = LocalDateTime.ofEpochSecond(sec, 0, ZoneOffset.UTC);
            absSender.execute(new SendMessage().setChatId(chat.getId()).setText("До конца " + num + " пары " + res.getHour() + " ч. " + res.getMinute() + " мин. " + res.getSecond() + "сек."));
        } catch (TelegramApiException e) {
            LOG.error(e);
        }
    }
}
