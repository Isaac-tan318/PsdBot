package Swears;

import com.PS.PsdBot.MessageParsing.CmdWithArgs;
import discord4j.core.event.domain.message.MessageCreateEvent;

import java.util.List;

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
