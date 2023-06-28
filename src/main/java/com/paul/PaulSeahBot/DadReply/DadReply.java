package com.paul.PaulSeahBot.DadReply;

import com.paul.PaulSeahBot.MessageParsing.CmdWithArgs;
import com.paul.PaulSeahBot.MessageParsing.DetectWords;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

import java.util.List;

public class DadReply implements DetectWords {

    @Override
    public void check(MessageCreateEvent event, List<String> msg) {

        int name = msg.indexOf("im") + 1;
        name = name == 0 ? msg.indexOf("i'm") + 1 : name;

        if(name == 0){
            return;
        }
        if(msg.size() >= name){
            event.getMessage().getChannel().block().createMessage(String.format("Hi %s, TUCK IN YOUR SHIRT! WHERE IS YOUR BELT?", msg.get(name))).block();
        }
        else
            event.getMessage().getChannel().block().createMessage("you are?").block();

    }
}
