package com.athlima;

public interface ICommand {
    void handle(CommandContext ctx);
    String getName();
    String getHelp();
}
