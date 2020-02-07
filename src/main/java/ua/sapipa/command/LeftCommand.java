package ua.sapipa.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

public class LeftCommand implements Command {

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

    @Override
    public SendMessage execute(Update update) {

        LocalDateTime now = LocalDateTime.now();
        if (Objects.equals(now.getDayOfWeek(), DayOfWeek.SATURDAY) || Objects.equals(now.getDayOfWeek(), DayOfWeek.SUNDAY)) {
            return new SendMessage().setChatId(update.getMessage().getChatId()).setText("Сегодня выходной, расслабься!");
        }
        if (now.isBefore(LocalDateTime.of(LocalDateTime.now().getYear(),
                LocalDateTime.now().getMonth(),
                LocalDateTime.now().getDayOfMonth(),
                8,
                0)) || now.isAfter(LocalDateTime.of(LocalDateTime.now().getYear(),
                LocalDateTime.now().getMonth(),
                LocalDateTime.now().getDayOfMonth(),
                20,
                0))) {
            return new SendMessage().setChatId(update.getMessage().getChatId()).setText("Сейчас нет пары!");
        }
        LocalDateTime[] localDateTimes = {one, two, three, four, five, six, seven};
        LocalDateTime end = null;
        System.out.println(now);
        int num = 0;
        for (int i = 0; i < localDateTimes.length - 1; i++) {
            System.out.println(localDateTimes[i]);
            if (now.isAfter(localDateTimes[i]) && now.isBefore(localDateTimes[i + 1])) {
                end = localDateTimes[i + 1];
                num = i + 2;
            }
        }

        long sec = end.toEpochSecond(ZoneOffset.UTC) - now.toEpochSecond(ZoneOffset.UTC);
        LocalDateTime res = LocalDateTime.ofEpochSecond(sec, 0, ZoneOffset.UTC);
        return new SendMessage().setChatId(update.getMessage().getChatId()).setText("До конца " + num + " пары " + res.getHour() + " ч. " + res.getMinute() + " мин. " + res.getSecond() + "сек.");
    }
}
