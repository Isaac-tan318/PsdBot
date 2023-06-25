package com.paul.PaulSeahBot.Blacklist;

import com.paul.PaulSeahBot.Command;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BlacklistHandler implements Command {
    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        List<String> args = Arrays.asList(event.getMessage().getContent().split(" "));
        args.remove(0);
        if(args.size() == 0){
            return BlacklistArg.SEE.execute(event, args);
        }

        return Stream.of(BlacklistArg.values())
                .filter(value -> value.name().equalsIgnoreCase(args.get(0)))
                .findFirst()
                .orElse(BlacklistArg.SEE)
                .execute(event, args);
    }
}

