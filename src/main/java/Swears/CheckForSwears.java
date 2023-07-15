package Swears;

import com.PS.PsdBot.MessageParsing.DetectWords;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Member;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class CheckForSwears implements DetectWords {

    @Override
    public void check(MessageCreateEvent event, List<String> content) {
        Member member = event.getMember().get();

        String username = member.getUsername();
        String userId = member.getId().asString();
        String server = member.getGuild().map(guild -> guild.getId().asString()).block();

        addIfNotInDb(username, userId, server);

        for(Swear swear : Swear.values()){
            int freq = Collections.frequency(content, swear.name().toLowerCase(Locale.ROOT));
            swear.addToCount(userId, freq);
        }
    }


    private void addIfNotInDb(String userId,String username, String server){
        String db = "jdbc:sqlite:C:\\Users\\James\\Desktop\\sqlite\\sqlite-tools-win32-x86-3380200\\ps_bot.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(db);
            connection.setAutoCommit(false);
            String inputCommand = String.format("SELECT 1 FROM UserSwearCount WHERE user_id = \"%s\"", userId);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(inputCommand);
            if (!resultSet.next()) {
                String createUserData = String.format
                        ("INSERT INTO UserSwearCount"
                                + "(user_id,username,server,f_count,b_count,c_count,s_count,n_count,a_count,g_count,fag_count) "
                                + "VALUES (\"%s\",\"%s\",\"%s\",0,0,0,0,0,0,0,0)", userId, username, server);
                statement.executeUpdate(createUserData);
                connection.commit();
            }
            connection.close();
            statement.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
