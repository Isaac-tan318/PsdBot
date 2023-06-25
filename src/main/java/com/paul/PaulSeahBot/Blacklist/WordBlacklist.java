//package com.paul.PaulSeahBot.Blacklist;
//
//import com.paul.PaulSeahBot.BotConfig;
//import com.paul.PaulSeahBot.Command;
//import discord4j.common.util.Snowflake;
//import discord4j.core.event.domain.message.MessageCreateEvent;
//import discord4j.core.object.entity.Entity;
//import discord4j.core.object.entity.User;
//import reactor.core.publisher.Mono;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.time.Duration;
//
//import static java.lang.String.format;
//import static java.sql.DriverManager.getConnection;
//
//public class WordBlacklist implements Command {
//    private final MessageCreateEvent event;
//    private final String serverId;
//    private final String db ="jdbc:sqlite:C:\\Users\\James\\Desktop\\sqlite\\sqlite-tools-win32-x86-3380200\\ps_bot.db";
//
//    public WordBlacklist(MessageCreateEvent event) {
//        this.event = event;
//        this.serverId = event.getGuildId().get().asString();
//
//    }
//
//    @Override
//    public Mono<Void> execute(MessageCreateEvent event) {
//        return null;
//
//    }
//
//    public void createBlacklistIfAbsent(){
//        try {
//            Connection connection = getConnection(db);
//            connection.setAutoCommit(false);
//            String isPresent = format("SELECT 1 FROM word_blacklist WHERE server_id = \"%s\"", serverId);
//            String createBlacklist = format
//                    ("INSERT INTO word_blacklist(server_id, banned_words) VALUES(\"%s\",\"\")",serverId);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(isPresent);
//            if(!resultSet.next()){
//                statement.executeUpdate(createBlacklist);
//                connection.commit();
//            }
//            connection.close();
//            statement.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//    public void addToBlacklist(String addWord){
//        if(!addWord.matches("[a-zA-Z]+")){
//            event.getMessage().getChannel().block().createMessage("it has to be an actual word, marist gentleman").block();
//            return;
//        }else {
//            String addWordConfirmMessage = format("add %s?", addWord);
//            event.getMessage().getChannel().block().createMessage(addWordConfirmMessage).block();
//
//                waitForMessageCreateEvent(event.getMessage().getAuthor().map(User::getId).get(), event.getMessage().getChannelId())
//                        .subscribe(addWordEvent -> {
//                            if(addWordEvent.getMessage().getContent().equalsIgnoreCase("yes")){
//                                try {
//                                    Connection connection = getConnection(db);
//                                    connection.setAutoCommit(false);
//                                    String updateBlacklist = format("UPDATE word_blacklist SET banned_words = banned_words || \"%s\" where server_id = \"%s\"", addWord + ",", serverId);
//                                    Statement statement = connection.createStatement();
//                                    statement.executeUpdate(updateBlacklist);
//                                    connection.commit();
//                                    connection.close();
//                                    statement.close();
//                                    addWordEvent.getMessage().getChannel().block().createMessage("ok").block();
//                                    seeBlacklist();
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                            }else
//                                return event.getMessage().getChannel().block().createMessage("ok nvm then").block();
//                        }
//                        , d -> event.getMessage().getChannel().block().createMessage("d").block());
//        }
//    }
//    public void removeFromBlacklist(String wordToRemove){
//        try {
//            Connection connection = getConnection(db);
//            connection.setAutoCommit(false);
//            String removeFromBlacklist = format("UPDATE word_blacklist SET banned_words = REPLACE(banned_words,\"%s\",\"\")",wordToRemove);
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(removeFromBlacklist);
//            connection.commit();
//            connection.close();
//            statement.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//    public void seeBlacklist(){
//        try {
//            Connection connection = getConnection(db);
//            String getBlacklist = format("SELECT banned_words FROM word_blacklist WHERE server_id = \"%s\"",serverId);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(getBlacklist);
//            while(resultSet.next()){
//                String bannedWords ="Banned words:\n" + resultSet.getString("banned_words").replaceAll(",","\n");
//                if(bannedWords.equals("Banned words:\n")){
//                    event.getMessage().getChannel().block().createMessage("Banned words:\n(none)").block();
//                }else
//                event.getMessage().getChannel().block().createMessage(bannedWords).block();
//            }
//            connection.close();
//            statement.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//    public static Mono<MessageCreateEvent> waitForMessageCreateEvent(Snowflake userId, Snowflake channelId) {
//        System.out.println("NEW WAIT FOR MESSAGE");
//        return BotConfig.client.on(MessageCreateEvent.class)
//                .filter(event -> event.getMessage().getAuthor().map(User::getId).map(userId::equals).get())
//                .filterWhen(event -> event.getMessage().getChannel()
//                        .map(Entity::getId)
//                        .map(id -> {
//                            System.out.println(id.equals(channelId));
//                            return id.equals(channelId);
//                        }))
//                .timeout(Duration.ofMinutes(1))
//                .next();
//    }
//}
