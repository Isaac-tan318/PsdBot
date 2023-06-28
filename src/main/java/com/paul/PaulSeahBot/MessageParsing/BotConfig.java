package com.paul.PaulSeahBot.MessageParsing;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.presence.ClientActivity;
import discord4j.core.object.presence.ClientPresence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class BotConfig{

    private static final Map<String, Command> commands = new HashMap<>();
    public static GatewayDiscordClient client = DiscordClientBuilder.create(getId())
            .build()
            .login()
            .block();

    public void runBot(){

        client.updatePresence(ClientPresence.online(ClientActivity.playing("ni hao"))).subscribe();


        client.getEventDispatcher().on(MessageCreateEvent.class).subscribe(
                event -> {
                    String content = event.getMessage().getContent();

                    System.out.println(content);
                    //repeats msg

                    List<String> splitMsg = Arrays.stream(content.split("\\s+")).map(String::toLowerCase).toList();
                    AtomicBoolean hasInCmd = new AtomicBoolean(false);

                    WordDetector wordDetector = new WordDetector(event, splitMsg);
                    wordDetector.detect();
                    // detects words within msg that cause a function

                    Arrays.stream(InCmd.values()).filter(inCmd -> splitMsg.contains("!" + inCmd.name().toLowerCase(Locale.ROOT)))
                            .findFirst().ifPresent(inCmd -> {
                                inCmd.execute(event, splitMsg);
                                hasInCmd.set(true);
                            });
                    //runs first inner command or cmdwithargs that is after or the first word

                    if(hasInCmd.get())
                        return;

                    Arrays.stream(Cmd.values()).filter(cmd -> cmd.name().equals(splitMsg.get(0)))
                            .findFirst().ifPresent(cmd -> cmd.execute(event));
                    // runs cmds without args


                });


        client.onDisconnect().block();
    }
    // so i can put this on github without the id getting stolen xd
    private static String getId(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\James\\Desktop\\ps bot id.txt"));
            return reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
// get msg, check if msg has cmd with args, then check if has cmd without args
