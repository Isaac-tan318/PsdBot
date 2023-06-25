package com.paul.PaulSeahBot.Blacklist;

import com.paul.PaulSeahBot.CmdWithArgs;
import com.paul.PaulSeahBot.Command;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

import java.util.List;

public enum BlacklistArg {
    ADD(new AddToBlacklist()),
    REMOVE(new RemoveFromBlacklist()),
    SEE(new SeeBlacklist());

    private final CmdWithArgs argClass;

    BlacklistArg(CmdWithArgs argClass) {
        this.argClass = argClass;
    }

    public Mono<Void> execute(MessageCreateEvent event, List<String> args){
        return argClass.execute(event, args);
    }
}
