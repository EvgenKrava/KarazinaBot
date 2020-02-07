package ua.sapipa.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommand implements Command {
    @Override
    public SendMessage execute(Update update) {
        return new SendMessage().setChatId(update.getMessage().getChatId()).setText("Доступные команды:\n" +
                "/rozklad — помогает выбрать или поменять название группы\n" +
                "/r — тоже, что /rozklad\n" +
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
                "/notification — c помощью уведомлений ты можешь получать в выбранное тобой время расписание на следующий день\n" +
                " /off — выключает уведомления\n" +
                " /t — используется для установки времени напоминания\n" +
                "\n" +
                "/help — показать это сообщение \uD83D\uDE31");
    }
}
