package ua.sapipa.command;

import org.apache.log4j.Logger;
import ua.sapipa.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TomorrowCommand extends TodayCommand {
    private static final Logger LOG = Logger.getLogger(TomorrowCommand.class);

    public TomorrowCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    protected String text() {
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new File("src/main/resources/" + (Util.isEven() ? 2 : 1) + File.separator + LocalDateTime.now().getDayOfWeek().plus(1) + ".txt"));) {
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            LOG.error(e);
            return "Расписание отсутствует!";
        }
        return stringBuilder.toString();
    }
}
