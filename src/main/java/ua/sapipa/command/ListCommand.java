package ua.sapipa.command;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ListCommand extends Command {

    private static final Logger LOG = Logger.getLogger(ListCommand.class);

    public ListCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        try {
            absSender.execute(new SendMessage().setChatId(chat.getId()).setText(
                    "1) Д'яченко Андрій Сергійович;\n" +
                            "2) Даценко Сергій;\n" +
                            "3) Дейнега Тарас;\n" +
                            "4) Дерев'янко Ярослав;\n" +
                            "5) Загребельний Олег;\n" +
                            "6) Заїченко Юлія;\n" +
                            "7) Зуєв Денис;\n" +
                            "8) Кирилова Єлизовета;\n" +
                            "9) Ковальчук Діана;\n" +
                            "10) Кононченко Анна;\n" +
                            "11) Конюшенко Ростислав Вікторович;\n" +
                            "12) Кравченко Євгеній Миколайович;\n" +
                            "13) Локоткова Ірина;\n" +
                            "14) Панченко Наталія;\n" +
                            "15) Попенко Вікторія;\n" +
                            "16) Попов Юрій;\n" +
                            "17) Прудиус Богдан;\n" +
                            "18) Сафоненко Владислав Едуардович;\n" +
                            "19) Суслик Максим;\n" +
                            "10) Федотов Сергій;\n" +
                            "21) Хорєва Євгенія;\n" +
                            "22) Шахов Богдан;\n" +
                            "23) Шульга Євгеній;\n"
            ));
        } catch (TelegramApiException e) {
            LOG.error(e);
        }
    }
}
