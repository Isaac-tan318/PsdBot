package com.paul.PaulSeahBot.MessageParsing;

import Swears.ReactiveSwearHandler;
import com.paul.PaulSeahBot.Blacklist.BlacklistHandler;
import com.paul.PaulSeahBot.Command;
import com.paul.PaulSeahBot.Reactions.defaultReact;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

public enum Cmd {
    SWEARS(new ReactiveSwearHandler()),
    BLACKLIST(new BlacklistHandler()),
    PAUL(event -> event.getMessage().getChannel().flatMap(channel -> channel.createMessage("bow say ah!")).then()),
    POOP(new defaultReact());

    public final Command command;

    Cmd (Command command){
        this.command = command;
    }

     public Mono<Void> execute(MessageCreateEvent event){
        return command.execute(event);
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
