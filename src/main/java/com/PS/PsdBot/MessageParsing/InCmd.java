package com.PS.PsdBot.MessageParsing;

import Swears.SwearHandler;
import discord4j.core.event.domain.message.MessageCreateEvent;

import java.util.List;

public enum InCmd {
    SWEARS(new SwearHandler()),
//    BLACKLIST()
    ;

    private final CmdWithArgs innerCommand;

    InCmd(CmdWithArgs innerCommand) {
        this.innerCommand = innerCommand;
    }
    public void execute (MessageCreateEvent event, List<String> args) {
        innerCommand.execute(event, args);
    }
}
// inner cmds are the same as cmds with args because i was lazy