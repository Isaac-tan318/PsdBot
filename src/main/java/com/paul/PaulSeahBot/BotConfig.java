package com.paul.PaulSeahBot;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.PartialMember;
import discord4j.core.object.entity.User;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.object.presence.ClientActivity;
import discord4j.core.object.presence.ClientPresence;
import reactor.core.publisher.Mono;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class BotConfig{

    private static final Map<String, Command> commands = new HashMap<>();
    public static GatewayDiscordClient client = DiscordClientBuilder.create("OTYxOTYxMDczMTk0NDY3MzY4.GdlUrJ.x3-emM2s7vbOpFjqHiYZnkcK8nwnhjYbk5DQAg")
            .build()
//            .gateway()
//            .setInitialPresence(__ -> ClientPresence.online(ClientActivity.playing("Hindi Enchanted Cocksucking Simulator 6")))
            .login()
            .block();

    public void runBot(){

        client.updatePresence(ClientPresence.online(ClientActivity.playing("Hindi Enchanted Cocksucking Simulator 6"))).subscribe();

        AtomicBoolean testIsRunning = new AtomicBoolean(false);

//        assert client != null;
//        client.getEventDispatcher().on(MessageCreateEvent.class)
//                .flatMap(event -> Mono.justOrEmpty(event.getMessage().getContent())
//                        .flatMap())


        client.getEventDispatcher().on(MessageCreateEvent.class).subscribe(
                event -> {

                    Optional<String> username = event.getMember().map(User::getUsername);
                    Optional<String> userNick = event.getMember().map(PartialMember::getNickname).orElse(username);
                    Member member = event.getMember().get();

                    System.out.println(username.get());
                    String userId = event.getMember().map(User::getId).get().asString();
                    Mono<MessageChannel> channel = event.getMessage().getChannel();
                    Snowflake flakeUserId = event.getMember().map(User::getId).get();
                    Snowflake flakeChannelId = event.getMessage().getChannelId();
                    String content = event.getMessage().getContent();
                    boolean isPaulSeah = userId.equals("961961073194467368");

//                    event

                    if (isPaulSeah) return;
                    else if (content.equalsIgnoreCase("!start")) testIsRunning.set(true);

                    else if (content.equalsIgnoreCase("!stop")) testIsRunning.set(false);

                    else if (testIsRunning.get()) {
                        System.out.println("d");
                        event.getMessage().getChannel().block().createMessage("weh").block();
                        return;
                    } else {
                        for (final Map.Entry<String, Command> entry : commands.entrySet()) {
                            if (content.startsWith(entry.getKey())) {
                                entry.getValue().execute(event);
                                System.out.println("hello");
                                break;
                            }
                        }

                        System.out.println(content);

//                        var replyEvent = client.on(MessageCreateEvent.class)
//                                .filter(temp -> temp.getMessage().getAuthor().map(User::getId).map(i -> i.equals(flakeUserId)).orElse(false))
//                                .next()
//                                .subscribe(
//                                        bruhReply -> bruhReply.getMessage()
//                                                .getChannel().block().createMessage("ok").block());

//                        IteratedMessage iteratedMessage = new IteratedMessage(event, content);
//                        iteratedMessage.iterateThroughMessage();

//                        iteratedMessage.swearCaller();
//                        iteratedMessage.initDadResponse();
                    }

//                                if(contentArray[i].equalsIgnoreCase("!form")){
//                                    try{
//                                        String next = contentArray[i + 1];
//                                        event.getMessage().getChannel().block().createMessage(MessageCreateSpec.builder()
//                                                .addFile("form.png", sendYellowForm(next)).build()).block();
//                                        break;
//                                    }catch(Exception ee){
//                                        event.getMessage().getChannel().block().createMessage(MessageCreateSpec.builder()
//                                                .addFile("form.png", sendYellowForm(userNick.orElseGet(username::get))).build()).block();
//                                        break;
//                                    }
//
//                                }
                });


        client.onDisconnect().block();
    }

     {
        commands.put("!paul", event ->
                event.getMessage()
                        .getChannel().flatMap(channel -> channel.createMessage("bow say ah!")).then());
    }

    InputStream sendYellowForm(String username) {
        InputStream stream = null;
         try {
             BufferedImage image = ImageIO.read(new File("C:\\Users\\James\\Desktop\\PaulSeahBot\\yellowForm.png"));
             ImageLibrary.writeToFile(image, username);
         }catch (Exception e){
             System.out.println("HELP");
         }
         try{
        File file = new File("C:\\Users\\James\\Desktop\\PaulSeahBot\\editedYellowForm.png");
        stream = new FileInputStream(file);
         }catch(Exception e){
             System.out.println("fail");
         }
        return stream;
    }

}
