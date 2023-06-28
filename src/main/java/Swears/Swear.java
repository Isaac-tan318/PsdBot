package Swears;

import discord4j.core.event.domain.message.MessageCreateEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public enum Swear {
    //dont look!!!


























    FUCK,
    BITCH,
    CUNT,
    SHIT,
    NIGGER,
    ASS,
    GAY,
    FAG;

    private final char countName;
    public String count;

    Swear(){
        countName = this.name().charAt(0);
        //first letter of swear, used to add to database
    }

    // idk what this is for
    public void initCounts(MessageCreateEvent event) {
        try {
            String userId = event.getMember().get().getId().asString();

            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\James\\Desktop\\sqlite\\sqlite-tools-win32-x86-3380200\\ps_bot.db");
            String inputCommand = String.format("SELECT %s_count FROM UserSwearCount WHERE user_id = \"%s\"", countName, userId);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(inputCommand);
            if(resultSet.next()){
                count = resultSet.getString(String.format("%s_count", countName));
            }
            connection.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addToCount(String userId,int num){
        String db = "jdbc:sqlite:C:\\Users\\James\\Desktop\\sqlite\\sqlite-tools-win32-x86-3380200\\ps_bot.db";
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(db);
            connection.setAutoCommit(false);
            String countUpdate = String.format("UPDATE UserSwearCount SET %s_count = %s_count + %s WHERE user_id = %s;", countName, countName,num, userId);
            Statement statement = connection.createStatement();
            statement.executeUpdate(countUpdate);
            connection.commit();
            connection.close();
            statement.close();
        }catch(Exception e){e.printStackTrace();}
    }
}
