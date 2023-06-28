package com.PS.PsdBot.MessageParsing;

import com.PS.PsdBot.Reactions.defaultReact;
import discord4j.core.event.domain.message.MessageCreateEvent;

public enum Cmd {

//    BLACKLIST(new BlacklistHandler()),
    PS(event -> event.getMessage().getChannel().block().createMessage("ni hao!!").block()),
    HI(new defaultReact());

    public final Command command;

    Cmd (Command command){
        this.command = command;
    }

     public void execute(MessageCreateEvent event){
        command.execute(event);
     }





//    private void swearCaller(){
//        for (int i = 0; i < contentArray.length; i++) {
//            System.out.println(contentArray[i]);
//            SwearHandler.handle(member, contentArray[i]);
//
//            if (contentArray[i].equalsIgnoreCase("!swears")) {
//                try {
//                    if (contentArray[i + 1].equalsIgnoreCase("server")) {
//                        SwearRetriever.serverTotal(event);
//                    }
//                    else if(contentArray[i + 1].equalsIgnoreCase("highest")){
//                        SwearRetriever.seeHighestCount(event);
//                    }
//                } catch (Exception e) {
//                    SwearRetriever.sendSwearCount(event);
//                }
//                break;
//            }
//
//            else if (contentArray[i].equalsIgnoreCase("im") || contentArray[i].equalsIgnoreCase("i'm")) {
//                initDadResponse(i);
//                break;
//            } else if(contentArray[i].equalsIgnoreCase("!blacklist")){
//                editBlacklist(i);
//                break;
//            }
//        }
//    }
}
