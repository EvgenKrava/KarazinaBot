package ua.sapipa.command;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;

public abstract class Command extends BotCommand {
    public Command(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }
}
