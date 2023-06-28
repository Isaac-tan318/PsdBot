package com.PS.PsdBot.Blacklist;

import com.PS.PsdBot.MessageParsing.CmdWithArgs;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static java.lang.String.format;
import static java.sql.DriverManager.getConnection;

public class SeeBlacklist implements CmdWithArgs {

    @Override
    public void execute(MessageCreateEvent event, List<String> args) {
        try {
            String serverId = event.getGuildId().get().asString();
            Connection connection = getConnection("jdbc:sqlite:C:\\Users\\James\\Desktop\\sqlite\\sqlite-tools-win32-x86-3380200\\ps_bot.db");
            String getBlacklist = format("SELECT banned_words FROM word_blacklist WHERE server_id = \"%s\"", serverId);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getBlacklist);
            if (resultSet.next()) {
                String bannedWords = "Banned words:\n" + resultSet.getString("banned_words").replaceAll(",", "\n");

                if (bannedWords.equals("Banned words:\n")) {
                    event.getMessage().getChannel()
                            .flatMap(channel -> channel.createMessage("Banned words:\n(none)")).then();
                }
                else {
                    event.getMessage().getChannel()
                            .flatMap(channel -> channel.createMessage(bannedWords)).then();
                }
            }
            connection.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

