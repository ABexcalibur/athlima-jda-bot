package com.athlima;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.List;

public class HelpCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<ICommand> iCommands = new CommandManager().getCommands();
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("-----HELP-----")
                .setDescription("List of all commands present in the JDA instance of the Athlima Bot:")
                .setColor(new Color((int)Math.floor(Math.random()*255),(int)Math.floor(Math.random()*255),(int)Math.floor(Math.random()*255)));
        for (ICommand command : iCommands) {
            builder.addField(command.getName(),command.getHelp(),false);
        }
        ctx.getChannel().sendMessage(builder.build()).queue();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getHelp() {
        return "Lists all the JDA Bot Commands";
    }
}
