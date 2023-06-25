package YellowForm;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class addForm {

    public void to(String userId){
        String db = "jdbc:sqlite:C:\\Users\\James\\Desktop\\sqlite\\sqlite-tools-win32-x86-3380200\\ps_bot.db";
        try{
            Connection connection = DriverManager.getConnection(db);
            connection.setAutoCommit(false);
            String existCheck = String.format("SELECT 1 FROM yellow_form_count where user_id = \"%s\"", userId);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(existCheck);
            if(!resultSet.next()){
                    String createCount =String.format("INSERT INTO yellow_form_count(user_id,count) VALUES(\"%s\",0)", userId);
                    statement.executeUpdate(createCount);
            }
            String incrementCount = String.format("UPDATE yellow_form_count SET count = count + 1 WHERE user_id = %s", userId);
            connection.commit();
            connection.close();
            statement.close();
        }catch(Exception e){e.printStackTrace();}
    }
}
