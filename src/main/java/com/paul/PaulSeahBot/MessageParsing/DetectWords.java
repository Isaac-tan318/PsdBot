package com.paul.PaulSeahBot.MessageParsing;

import discord4j.core.event.domain.message.MessageCreateEvent;

import java.util.List;

public interface DetectWords {
    void check(MessageCreateEvent event, List<String> content);
}
