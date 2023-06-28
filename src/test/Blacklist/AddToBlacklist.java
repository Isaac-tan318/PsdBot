package com.paul.PaulSeahBot.Blacklist;

import com.paul.PaulSeahBot.MessageParsing.CmdWithArgs;
import com.paul.PaulSeahBot.MessageParsing.ConfirmationMessage;
import discord4j.common.util.Snowflake;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import static java.lang.String.format;
import static java.sql.DriverManager.getConnection;

public class AddToBlacklist implements CmdWithArgs {
    @Override
    public void execute(MessageCreateEvent event, List<String> args) {
        String toAdd = args.get(1);
        String serverId = event.getGuildId().orElse(Snowflake.of("")).asString();

        if(!toAdd.matches("[a-zA-Z]+")){
            event.getMessage().getChannel()
                    .flatMap(channel -> channel.createMessage("It has to be an actual word bro")).then();
        }

        else {
            String addWordConfirmMessage = format("add %s?", toAdd);
            Mono<Void> confirmMsg = event.getMessage().getChannel()
                    .flatMap(channel -> channel.createMessage(addWordConfirmMessage)).then();

            ConfirmationMessage.confirmMessage(addWordConfirmMessage, event,

                    addWordEvent -> {
                        if(addWordEvent.getMessage().getContent().equalsIgnoreCase("yes")){
                            try {
                                Connection connection = getConnection("jdbc:sqlite:C:\\Users\\James\\Desktop\\sqlite\\sqlite-tools-win32-x86-3380200\\ps_bot.db");
                                connection.setAutoCommit(false);
                                String updateBlacklist = format("UPDATE word_blacklist SET banned_words = banned_words || \"%s\" where server_id = \"%s\"", toAdd + ",", serverId);
                                Statement statement = connection.createStatement();
                                statement.executeUpdate(updateBlacklist);
                                connection.commit();
                                connection.close();
                                statement.close();

//                                SeeBlacklist sbl = new SeeBlacklist();
//                                Mono<Void> sendBlackList = sbl.execute(event, args);
//                                addWordEvent.getMessage().getChannel()
//                                        .flatMap(channel -> channel.createMessage("Current blacklist:"))
//                                        .and(sendBlackList);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        event.getMessage().getChannel().flatMap(channel -> channel.createMessage("ok nvm then")).then();
                    }
                    );



        }
    }
}

