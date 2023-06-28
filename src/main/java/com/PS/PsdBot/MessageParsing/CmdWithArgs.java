package com.PS.PsdBot.MessageParsing;

import discord4j.core.event.domain.message.MessageCreateEvent;

import java.util.List;

public interface CmdWithArgs {
    void execute(MessageCreateEvent event, List<String> words);
}
