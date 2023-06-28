package com.paul.PaulSeahBot.MessageParsing;

import discord4j.common.util.Snowflake;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Entity;
import discord4j.core.object.entity.User;
import reactor.core.publisher.Mono;

import java.time.Duration;

//public class ConfirmationMessage {
//    public static Mono<Void> confirmMessage(String message, MessageCreateEvent superEvent, Command doWhenConfirmed) {
//
//        Snowflake userId = superEvent.getMessage().getAuthor().map(User::getId).orElse(Snowflake.of(""));
//        Snowflake channelId = superEvent.getMessage().getChannelId();
//
//        BotConfig.client.on(MessageCreateEvent.class)
//                .filter(event -> event.getMessage().getAuthor().map(User::getId).map(userId::equals).orElse(false))
//                .filterWhen(event -> event.getMessage().getChannel()
//                        .map(Entity::getId)
//                        .map(id -> {
//                            System.out.println(id.equals(channelId));
//                            return id.equals(channelId);
//                        }))
//                .timeout(Duration.ofMinutes(1))
//                .next()
//                .flatMap(doWhenConfirmed::execute)
//                .subscribe();
//
//        return superEvent.getMessage().getChannel()
//                .flatMap(channel -> channel.createMessage(message)).then();
//    }
//}
