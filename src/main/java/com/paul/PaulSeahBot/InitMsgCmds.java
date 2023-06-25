package com.paul.PaulSeahBot;

import Swears.SwearRetriever;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum InitMsgCmds {
//    SWEARS((event, args) -> args.flatMap(arg ->{
//        return Flux.fromIterable(
//                Arrays.asList(SwearArg.values()))
//                .filter(swearArg -> swearArg.name().equals(arg))
//                .flatMap(arg -> arg)
//                .next();
//
//    })),
//    BLACKLIST();
//
//    public final BiFunction<MessageCreateEvent,Flux<String>, Mono<Void>> function;
//
//    InitMsgCmds(BiFunction<MessageCreateEvent, Flux<String>, Mono<Void>> function){
//        this.function = function;
//    }
//     public Mono<Void> execute(MessageCreateEvent event){
//        Flux<String> args = Flux.fromIterable(Arrays.asList(event.getMessage().getContent().split(" ")));
//        return function.apply(args);
//     }
//
//    private enum SwearArg{
//        SERVER(),
//        HIGHEST(SwearRetriever);
//
//        public final Command command;
//
//        SwearArg(Command command) {
//            this.command = command;
//        }
//    }
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