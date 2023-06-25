package com.paul.PaulSeahBot;

import com.paul.PaulSeahBot.MessageParsing.InnerCommand;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class DadReply implements InnerCommand {

    @Override
    public Mono<Void> execute(MessageCreateEvent event, List<String> msg) {

        String[] name = event.getMessage().getContent().split("im");
        String[] altName = event.getMessage().getContent().split("i'm");
        if(name.length == 2)
            return event.getMessage().getChannel()
                    .flatMap(channel -> channel.createMessage(String.format("Hi %s, TUCK IN YOUR SHIRT! WHERE IS YOUR BELT?", name[1]))).then();
        if(altName.length == 2)
            return event.getMessage().getChannel()
                    .flatMap(channel -> channel.createMessage(String.format("Hi %s, WHERE IS YOUR NAME TAG AND SCHOOL BADGE?", name[1]))).then();

        return Mono.empty();
    }
}
