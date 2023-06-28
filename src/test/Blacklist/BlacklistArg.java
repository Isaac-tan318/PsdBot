package com.PS.PsdBot.Blacklist;

import com.PS.PsdBot.MessageParsing.CmdWithArgs;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

import java.util.List;

//public enum BlacklistArg {
//    ADD(new AddToBlacklist()),
//    REMOVE(new RemoveFromBlacklist()),
//    SEE(new SeeBlacklist());
//
//    private final CmdWithArgs argClass;
//
//    BlacklistArg(CmdWithArgs argClass) {
//        this.argClass = argClass;
//    }
//
//    public void execute(MessageCreateEvent event, List<String> args){
//        argClass.execute(event, args);
//    }
//}
