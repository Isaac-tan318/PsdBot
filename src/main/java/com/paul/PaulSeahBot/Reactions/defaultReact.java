package com.paul.PaulSeahBot.Reactions;

import com.paul.PaulSeahBot.MessageParsing.Command;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.reaction.ReactionEmoji;
import reactor.core.publisher.Mono;

public class defaultReact implements Command {
    @Override
    public void execute(MessageCreateEvent event) {
        Message msg = event.getMessage();
        Mono.when(
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD33")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD32")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD30")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD29")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD28")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD27")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD26")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD25")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD24")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD23")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD22")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD21")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD20")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD19")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD18")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD16")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD15")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD14")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD13")),
                msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD31"))).block();
    }

}

//(msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD23")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD22")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD21")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD20")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD19")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD18")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD16")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD15")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD14")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD13")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD12")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD11")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD10")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD34")),
//        msg.addReaction(ReactionEmoji.unicode("\uD83E\uDD31"))