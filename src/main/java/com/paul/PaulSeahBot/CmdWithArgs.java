package com.paul.PaulSeahBot;

import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CmdWithArgs {
    Mono<Void> execute(MessageCreateEvent event, List<String> args);
}
