package ua.sapipa.command;


import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HelpCommand extends Command {

    private static final Logger LOG = Logger.getLogger(HelpCommand.class);

    public HelpCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        try {
            absSender.execute(new SendMessage().setChatId(chat.getId()).setText("Доступные команды (расписание КБ-31):\n" +
                    " /today — расписание на сегодня\n" +
                    " /tomorrow — расписание на завтра\n" +
                    " /week — расписание на неделю\n" +
                    " /nextweek — расписание на следующую неделю\n" +
                    " /timetable — расписание звонков\n" +
                    "/exam — твои экзамены\n" +
                    "/full — расписание на две недели с именами преподавателей\n" +
                    "\n" +
                    "/list — список группы КБ-31\n" +
                    "\n" +
                    "/who — подсказывает имя преподавателя\n" +
                    "/left — показывает время до конца пары\n" +
                    "\n" +
                    "/help — показать это сообщение \uD83D\uDE31"));
        } catch (TelegramApiException e) {
            LOG.error(e);
        }
    }
    /*@Override
    public void execute(Update update, TelegramLongPollingBot telegramLongPollingBot) throws TelegramApiException {
        telegramLongPollingBot.execute();
    }*/
}
