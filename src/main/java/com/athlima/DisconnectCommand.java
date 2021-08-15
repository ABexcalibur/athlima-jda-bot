package com.athlima;

import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;

public class DisconnectCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        final TextChannel channel = ctx.getChannel();
        final Member bot = ctx.getSelfMember();
        final GuildVoiceState selfVoiceState = bot.getVoiceState();
        if (!selfVoiceState.inVoiceChannel()) {
            channel.sendMessage("Bot is not in any voice channel").queue();
            return;
        }
        final AudioManager audioManager = ctx.getGuild().getAudioManager();
        final VoiceChannel vc = selfVoiceState.getChannel();
        System.out.println(selfVoiceState.inVoiceChannel());
        audioManager.closeAudioConnection();
        channel.sendMessageFormat("Disconnected from `\uD83D\uDD0A %s`", vc.getName()).queue();
    }

    @Override
    public String getName() {
        return "disconnect";
    }

    @Override
    public String getHelp() {
        return "Disconnect the BOT from the connected Voice Channel";
    }
}
