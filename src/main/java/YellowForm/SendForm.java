package YellowForm;

import discord4j.core.event.domain.message.MessageCreateEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.String.format;

public class SendForm {
    public SendForm(MessageCreateEvent event){
        String serverId = event.getGuildId().get().asString();
        String msg = event.getMessage().getContent();
        String db = "jdbc:sqlite:C:\\Users\\James\\Desktop\\sqlite\\sqlite-tools-win32-x86-3380200\\ps_bot.db";
        try {
            Connection connection = DriverManager.getConnection(db);
            String getBlacklist = format("SELECT banned_words FROM words_blacklist WHERE server_id = %s", serverId);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getBlacklist);
            while (resultSet.next()) {
                String[] words = resultSet.getString("banned_words").split(",");
            }
            connection.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
