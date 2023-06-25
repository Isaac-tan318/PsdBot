package com.paul.PaulSeahBot.Blacklist;

import com.paul.PaulSeahBot.CmdWithArgs;
import com.paul.PaulSeahBot.Command;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import static java.lang.String.format;
import static java.sql.DriverManager.getConnection;

public class RemoveFromBlacklist implements CmdWithArgs {

    @Override
    public Mono<Void> execute(MessageCreateEvent event, List<String> args) {
        try {
            Connection connection = getConnection("jdbc:sqlite:C:\\Users\\James\\Desktop\\sqlite\\sqlite-tools-win32-x86-3380200\\ps_bot.db");
            connection.setAutoCommit(false);
            // decision made, argument list will exclude initial command
            String removeFromBlacklist = format("UPDATE word_blacklist SET banned_words = REPLACE(banned_words,\"%s\",\"\")", args.get(1));
            Statement statement = connection.createStatement();
            statement.executeUpdate(removeFromBlacklist);
            connection.commit();
            connection.close();
            statement.close();

            SeeBlacklist Sbl = new SeeBlacklist();
            return event.getMessage().getChannel()
                    .flatMap(channel -> channel.createMessage("Successfully removed, your blacklist now:\n")).and(Sbl.execute(event, args)).then();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event.getMessage().getChannel()
                .flatMap(channel -> channel.createMessage("Your request has failed")).then();
    }
}

