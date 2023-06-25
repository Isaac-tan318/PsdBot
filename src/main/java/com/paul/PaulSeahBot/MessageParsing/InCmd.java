package com.paul.PaulSeahBot.MessageParsing;

import com.paul.PaulSeahBot.DadReply;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

import java.util.List;

public enum InCmd {
    IN(new DadReply());

    private final InnerCommand innerCommand;

    InCmd(InnerCommand innerCommand) {
        this.innerCommand = innerCommand;
    }
    public Mono<Void> execute (MessageCreateEvent event, List<String> args) {
        return innerCommand.execute(event, args);
    }
}