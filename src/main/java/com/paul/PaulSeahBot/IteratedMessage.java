//package com.paul.PaulSeahBot;
//
//import Swears.SwearHandler;
//import com.paul.PaulSeahBot.Blacklist.WordBlacklist;
//import discord4j.core.event.domain.message.MessageCreateEvent;
//import discord4j.core.object.entity.Member;
//
//public class IteratedMessage{
//    String[] contentArray;
//    private final MessageCreateEvent event;
//    Member member;
//
//    public IteratedMessage(MessageCreateEvent event, String content){
//        this.event = event;
//        this.contentArray = content.split(" ");
//        member = event.getMember().get();
//    }
//
//    public void iterateThroughMessage(){
//        swearCaller();
//    }
//    private void swearCaller(){
//        for (int i = 0; i < contentArray.length; i++) {
//            System.out.println(contentArray[i]);
//            SwearHandler.handle(member, contentArray[i]);
//
////            if (contentArray[i].equalsIgnoreCase("!swears")) {
////                try {
////                    if (contentArray[i + 1].equalsIgnoreCase("server")) {
////                        SwearRetriever.serverTotal(event);
////                    }
////                    else if(contentArray[i + 1].equalsIgnoreCase("highest")){
////                        SwearRetriever.seeHighestCount(event);
////                    }
////                } catch (Exception e) {
////                    SwearRetriever.sendSwearCount(event);
////                }
////                break;
////            }
//
//             if (contentArray[i].equalsIgnoreCase("im") || contentArray[i].equalsIgnoreCase("i'm")) {
//                initDadResponse(i);
//                break;
//            } else if(contentArray[i].equalsIgnoreCase("!blacklist")){
//                editBlacklist(i);
//                break;
//            }
//        }
//    }
//
//    private void initDadResponse(int i){
//                try {
//                    if (contentArray[i].equalsIgnoreCase("im"))
//                        event.getMessage().getChannel().block().createMessage(dadMessage(contentArray[i + 1])).block();
//                    else
//                        event.getMessage().getChannel().block().createMessage(momMessage(contentArray[i + 1])).block();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//    }
//
//    private String momMessage(String name) {
//        return String.format("hi %s, TUCK IN YOUR SHIRT! WHERE IS YOUR BELT?", name);
//    }
//
//    private String dadMessage(String name) {
//        return String.format("hi %s, WHERE IS YOUR NAMETAG AND SCHOOLBADGE", name);
//    }
//
//    private void editBlacklist(int i){
//        WordBlacklist wordBlacklist = new WordBlacklist(event);
//            wordBlacklist.createBlacklistIfAbsent();
//            try {
//                if (contentArray[i + 1].equalsIgnoreCase("add"))
//                    try {
//                        wordBlacklist.addToBlacklist(contentArray[i + 2]);
//                        System.out.println(contentArray[i + 2]);
//                    } catch (Exception e) {
//                        event.getMessage().getChannel().block().createMessage("> ***~~`ADD WHAT`~~***").block();
//                    }
//                else if (contentArray[i + 1].equalsIgnoreCase("remove"))
//                    try {
//                        wordBlacklist.removeFromBlacklist(contentArray[i + 2]);
//                        wordBlacklist.seeBlacklist();
//                    } catch (Exception e) {
//                        event.getMessage().getChannel().block().createMessage("> ***~~`remove WHAT??`~~***").block();
//                    }
//                else if (contentArray[i + 1].equalsIgnoreCase("see"))
//                    wordBlacklist.seeBlacklist();
//            } catch (Exception e) {
//                wordBlacklist.seeBlacklist();
//            }
//    }
//}
