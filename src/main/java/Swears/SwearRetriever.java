package Swears;

import discord4j.core.event.domain.message.MessageCreateEvent;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.sql.DriverManager.getConnection;

public class SwearRetriever {
    private int fCount,bCount, cCount,sCount,nCount,aCount,gCount,fagCount,total;
    private final MessageCreateEvent event;
    private final String userId;

    public SwearRetriever(MessageCreateEvent event) {
        this.event = event;
        userId = event.getMember().get().getId().asString();

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\James\\Desktop\\sqlite\\sqlite-tools-win32-x86-3380200\\ps_bot.db");
            String inputCommand = String.format("SELECT * FROM UserSwearCount WHERE user_id = \"%s\"", userId);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(inputCommand);
            while(resultSet.next()){
                fCount = Integer.parseInt(resultSet.getString("f_count"));
                bCount = Integer.parseInt(resultSet.getString("b_count"));
                cCount = Integer.parseInt(resultSet.getString("c_count"));
                sCount = Integer.parseInt(resultSet.getString("s_count"));
                nCount = Integer.parseInt(resultSet.getString("n_count"));
                aCount = Integer.parseInt(resultSet.getString("a_count"));
                gCount = Integer.parseInt(resultSet.getString("g_count"));
                fagCount = Integer.parseInt(resultSet.getString("fag_count"));
                total = fCount + bCount + cCount + sCount + nCount + aCount + gCount + fagCount;
            }
            connection.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendSwearCount(){
        event.getMessage().getChannel().block().createMessage(
            "You have sent " + total + " swears"
        ).block();
        // just to mirror to console
        System.out.println("You have sent " + total + " swears");
    }
    public void serverTotal(){
        String serverId = event.getGuildId().get().asString();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\James\\Desktop\\sqlite\\sqlite-tools-win32-x86-3380200\\ps_bot.db");
            String getTotal = String.format("SELECT SUM(f_count) + SUM(b_count) + SUM(c_count) + SUM(s_count) + SUM(n_count) + SUM(a_count) + SUM(g_count) + SUM(fag_count) "
                    + "FROM UserSwearCount WHERE server = \"%s\" GROUP BY server", serverId);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getTotal);
            while(resultSet.next()) {
                String total = resultSet.getString("SUM(f_count) + SUM(b_count) + SUM(c_count) + SUM(s_count) + SUM(n_count) + SUM(a_count) + SUM(g_count) + SUM(fag_count)");

                event.getMessage().getChannel().block().createMessage(
                        "Server total: " + total
                ).block();
            }
            connection.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void seeHighestCount(){
        String db = "jdbc:sqlite:C:\\Users\\James\\Desktop\\sqlite\\sqlite-tools-win32-x86-3380200\\ps_bot.db";
        try {
            String highest = "";
            int fCount = 0;
            Connection connection = getConnection(db);
            String getBlacklist = "SELECT username, f_count FROM UserSwearCount ORDER BY f_count DESC LIMIT 1";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getBlacklist);
            while (resultSet.next()) {
                highest = resultSet.getString("username");
                fCount = resultSet.getInt("f_count");
            }
            connection.close();
            statement.close();
            event.getMessage().getChannel().block().createMessage("highest guy: " + highest + " with " + fCount + " fucks").block();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void oldSendSwearCount() {
                event.getMessage().getChannel().block().createMessage(
                        "fuck : " + fCount + "\n"
                        + "bitch : " + bCount + "\n"
                        + "cunt : " + cCount + "\n"
                        + "shit : " + sCount + "\n"
                        + "nigglet : " + nCount + "\n"
                        + "ass : " + aCount + "\n"
                        + "gay : " + gCount + "\n"
                        + "faggot : " + fagCount).block();
        System.out.println(                        "fuck : " + fCount + "\n"
                + "bitch : " + bCount + "\n"
                + "cunt : " + cCount + "\n"
                + "shit : " + sCount + "\n"
                + "nigglet : " + nCount + "\n"
                + "ass : " + aCount + "\n"
                + "gay : " + gCount + "\n"
                + "faggot : " + fagCount);
    }
    public void oldServerTotal(){
        String serverId = event.getGuildId().get().asString();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\James\\Desktop\\sqlite\\sqlite-tools-win32-x86-3380200\\ps_bot.db");
            String getTotal = String.format("SELECT SUM(f_count),SUM(b_count),SUM(c_count),SUM(s_count),SUM(n_count),SUM(a_count),SUM(g_count),SUM(fag_count) "
                    + "FROM UserSwearCount WHERE server = \"%s\" GROUP BY server", serverId);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getTotal);
            while(resultSet.next()) {
                String fCount = resultSet.getString("SUM(f_count)");
                String bCount = resultSet.getString("SUM(b_count)");
                String cCount = resultSet.getString("SUM(c_count)");
                String sCount = resultSet.getString("SUM(s_count)");
                String nCount = resultSet.getString("SUM(n_count)");
                String aCount = resultSet.getString("SUM(a_count)");
                String gCount = resultSet.getString("SUM(g_count)");
                String fagCount = resultSet.getString("SUM(fag_count)");

                StringBuilder swearMsg = new StringBuilder();
//                Arrays.stream(Swear.values()).map(swear -> swear.name().toLowerCase(Locale.ROOT))
//                        .forEach()

                event.getMessage().getChannel().block().createMessage(
                        "fuck : " + fCount + "\n"
                                + "bitch : " + bCount + "\n"
                                + "cunt : " + cCount + "\n"
                                + "shit : " + sCount + "\n"
                                + "nigglet : " + nCount + "\n"
                                + "ass : " + aCount + "\n"
                                + "gay : " + gCount + "\n"
                                + "faggot : " + fagCount).block();
            }
            connection.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
