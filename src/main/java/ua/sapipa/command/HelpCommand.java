package ua.sapipa.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommand implements Command {
    @Override
    public SendMessage execute(Update update) {
        return new SendMessage().setChatId(update.getMessage().getChatId()).setText("Доступные команды (расписание КБ-31):\n" +
                " /today — расписание на сегодня\n" +
                " /tomorrow — расписание на завтра\n" +
                " /week — расписание на неделю\n" +
                " /nextweek — расписание на следующую неделю\n" +
                " /timetable — расписание звонков\n" +
                "/exam — твои экзамены\n" +
                "/full — расписание на две недели с именами преподавателей\n" +
                "\n" +
                "/who — подсказывает имя преподавателя\n" +
                "/left — показывает время до конца пары\n" +
                "\n" +
                "/help — показать это сообщение \uD83D\uDE31");
    }
}
