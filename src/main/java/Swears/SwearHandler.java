package Swears;

import com.paul.PaulSeahBot.MessageParsing.CmdWithArgs;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Member;

import java.sql.*;
import java.util.List;
import java.util.Locale;

public class SwearHandler implements CmdWithArgs {
    public void execute(MessageCreateEvent event, List<String> content) {
        SwearRetriever swearRetriever = new SwearRetriever(event);

        if(content.size() == 1){
            swearRetriever.sendSwearCount();
            return;
        }
        String arg = content.get(1);

        if (arg.equalsIgnoreCase("highest")) {
            swearRetriever.seeHighestCount();
        } else if (arg.equalsIgnoreCase("server")) {
            swearRetriever.serverTotal();
        }

    }
}
