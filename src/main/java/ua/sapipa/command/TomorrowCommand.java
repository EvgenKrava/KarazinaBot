package ua.sapipa.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TomorrowCommand extends TodayCommand {
    @Override
    protected String text() {
        LocalDateTime now = LocalDateTime.now();
        int week = 0;
        switch (now.getMonth()) {
            case FEBRUARY:
                if (now.getDayOfMonth() >= 10 && now.getDayOfMonth() <= 14) {
                    week = 1;
                }
                if (now.getDayOfMonth() >= 17 && now.getDayOfMonth() <= 21) {
                    week = 2;
                }
                if (now.getDayOfMonth() >= 24 && now.getDayOfMonth() <= 28) {
                    week = 3;
                }
                break;
            case MARCH:
                if (now.getDayOfMonth() >= 2 && now.getDayOfMonth() <= 6) {
                    week = 4;
                }
                if (now.getDayOfMonth() >= 9 && now.getDayOfMonth() <= 13) {
                    week = 5;
                }
                if (now.getDayOfMonth() >= 16 && now.getDayOfMonth() <= 20) {
                    week = 6;
                }
                if (now.getDayOfMonth() >= 23 && now.getDayOfMonth() <= 27) {
                    week = 7;
                }
                if (now.getDayOfMonth() >= 30 && now.getDayOfMonth() <= 31) {
                    week = 8;
                }
                break;
            case APRIL:
                if (now.getDayOfMonth() >= 1 && now.getDayOfMonth() <= 3) {
                    week = 8;
                }
                if (now.getDayOfMonth() >= 6 && now.getDayOfMonth() <= 10) {
                    week = 9;
                }
                if (now.getDayOfMonth() >= 13 && now.getDayOfMonth() <= 17) {
                    week = 10;
                }
                if (now.getDayOfMonth() >= 20 && now.getDayOfMonth() <= 24) {
                    week = 11;
                }
                if (now.getDayOfMonth() >= 27 && now.getDayOfMonth() <= 30) {
                    week = 12;
                }
                break;
            case MAY:
                if (now.getDayOfMonth() == 1) {
                    week = 12;
                }
                if (now.getDayOfMonth() >= 4 && now.getDayOfMonth() <= 8) {
                    week = 13;
                }
                if (now.getDayOfMonth() >= 11 && now.getDayOfMonth() <= 15) {
                    week = 14;
                }
                if (now.getDayOfMonth() >= 18 && now.getDayOfMonth() <= 22) {
                    week = 15;
                }
                if (now.getDayOfMonth() >= 25 && now.getDayOfMonth() <= 29) {
                    week = 16;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + now.getMonth());
        }
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/main/resources/" + (week % 2 == 0 ? 2 : 1) + File.separator + now.getDayOfWeek().plus(1) + ".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "See you later alligator!";
        }
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
