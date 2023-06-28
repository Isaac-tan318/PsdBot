package com.paul.PaulSeahBot.MessageParsing;

import Swears.checkForSwears;
import com.paul.PaulSeahBot.DadReply.DadReply;
import discord4j.core.event.domain.message.MessageCreateEvent;

import java.util.List;


public class WordDetector{

    private final MessageCreateEvent event;
    private List<String> content;
    public WordDetector(MessageCreateEvent event, List<String> content){
        this.event = event;
        this.content = content;
    }

    public void detect(){
        DetectWords[] detectWords = {new checkForSwears(), new DadReply()};

        for(DetectWords detect : detectWords){
            detect.check(event, content);
        }

    }
}
