package com.PS.PsdBot.DadReply;

import com.PS.PsdBot.MessageParsing.DetectWords;
import discord4j.core.event.domain.message.MessageCreateEvent;

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
            event.getMessage().getChannel().block().createMessage(String.format("Hi %s, I'm PsdBot!", msg.get(name))).block();
        }
        else
            event.getMessage().getChannel().block().createMessage("who r u?").block();

    }
}
