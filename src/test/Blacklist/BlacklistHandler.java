package com.PS.PsdBot.Blacklist;

import com.PS.PsdBot.MessageParsing.Command;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BlacklistHandler implements Command {
    @Override
    public void execute(MessageCreateEvent event) {
        List<String> args = Arrays.asList(event.getMessage().getContent().split(" "));
        args.remove(0);
        if(args.size() == 0){
            BlacklistArg.SEE.execute(event, args);
        }

        Stream.of(BlacklistArg.values())
                .filter(value -> value.name().equalsIgnoreCase(args.get(0)))
                .findFirst()
                .orElse(BlacklistArg.SEE)
                .execute(event, args);
    }
}

