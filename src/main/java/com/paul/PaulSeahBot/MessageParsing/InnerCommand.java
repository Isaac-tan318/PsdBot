package com.paul.PaulSeahBot.MessageParsing;

import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

import java.util.List;

public interface InnerCommand {
    public Mono<Void> execute(MessageCreateEvent event, List<String> words);
}
