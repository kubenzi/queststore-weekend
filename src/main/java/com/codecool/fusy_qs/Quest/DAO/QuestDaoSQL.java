package com.codecool.fusy_qs.Quest.DAO;

import com.codecool.fusy_qs.Order;
import com.codecool.fusy_qs.PSQLconnection;
import com.codecool.fusy_qs.Quest.Model.Quest;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class QuestDaoSQL extends PSQLconnection implements QuestDao {

    @Override
    public Quest getQuestByID(String questID) {
        String query = "SELECT * FROM quest" +
                "RIGHT JOIN quest_type on quest.quest_type_id = quest_type.quest_type_id" +
                "WHERE quest.quest_id = ?;";

        Quest quest = null;

        try (Connection con = DriverManager.getConnection(super.getUrl(), super.getUsername(), super.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(Order.FIRST_ATTRIBUTE.getValue(), questID);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Integer questTypeID = rs.getInt("quest_type_id");
                String questTypeName = rs.getString("type_name");
                String questDescription = rs.getString("quest_description");
                Integer questValue = rs.getInt("quest_value");

                quest = new Quest(questID, questTypeID, questTypeName, questDescription, questValue);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(QuestDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return quest;
    }

    @Override
    public List<Quest> getAllQuests() {
        String query = "SELECT * FROM quest" +
                "RIGHT JOIN quest_type on quest.quest_type_id = quest_type.quest_type_id;";

        List<Quest> allQuests = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(super.getUrl(), super.getUsername(), super.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                String questID = rs.getString("quest_id");
                Quest newQuest = getQuestByID(questID);
                allQuests.add(newQuest);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(QuestDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return allQuests;
    }

    @Override
    public List<Quest> getIndividualQuests() {
        String query = "SELECT * FROM quest" +
                "RIGHT JOIN quest_type on quest.quest_type_id = quest_type.quest_type_id" +
                "WHERE quest.quest_type_id = 1;";

        List<Quest> individualQuests = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(super.getUrl(), super.getUsername(), super.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                String questID = rs.getString("quest_id");
                Quest newQuest = getQuestByID(questID);
                individualQuests.add(newQuest);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(QuestDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return individualQuests;
    }

    @Override
    public List<Quest> getGroupQuests() {
        String query = "SELECT * FROM quest" +
                "RIGHT JOIN quest_type on quest.quest_type_id = quest_type.quest_type_id" +
                "WHERE quest.quest_type_id = 2;";

        List<Quest> groupQuests = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(super.getUrl(), super.getUsername(), super.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                String questID = rs.getString("quest_id");
                Quest newQuest = getQuestByID(questID);
                groupQuests.add(newQuest);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(QuestDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return groupQuests;
    }

    @Override
    public int removeQuestByID(String questID) {
        String query = "DELETE FROM quest WHERE quest_id = ?;";

        int affectrows= 0;

        try (Connection con = DriverManager.getConnection(super.getUrl(), super.getUsername(), super.getPassword());
             PreparedStatement pst1 = con.prepareStatement(query)) {

            pst1.setString(Order.FIRST_ATTRIBUTE.getValue(), questID);

            affectrows = pst1.executeUpdate();

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(QuestDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return affectrows;
    }

    @Override
    public void addNewQuest(Quest newQuest) {
        String query = "INSERT INTO quest(quest_id, quest_type_id, quest_description, quest_value) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(super.getUrl(), super.getUsername(), super.getPassword());
             PreparedStatement pst1 = con.prepareStatement(query)) {

            pst1.setString(Order.FIRST_ATTRIBUTE.getValue(), newQuest.getQuestID());
            pst1.setInt(Order.SECOND_ATTRIBUTE.getValue(), newQuest.getQuestTypeID());
            pst1.setString(Order.THIRD_ATTRIBUTE.getValue(), newQuest.getQuestDescription());
            pst1.setInt(Order.FOURTH_ATTRIBUTE.getValue(), newQuest.getQuestValue());

            pst1.executeUpdate();

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(QuestDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public void updateQuest(String questID, int newValue, String newDescription) {
        Quest questToUpdate = getQuestByID(questID);
        questToUpdate.setQuestValue(newValue);
        questToUpdate.setQuestDescription(newDescription);
        String query = "UPDATE quest SET quest_description = ?, quest_value = ? WHERE quest_id = ?;";

        try (Connection con = DriverManager.getConnection(super.getUrl(), super.getUsername(), super.getPassword());
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(Order.FIRST_ATTRIBUTE.getValue(), newDescription);
            pst.setInt(Order.SECOND_ATTRIBUTE.getValue(), newValue);
            pst.setString(Order.THIRD_ATTRIBUTE.getValue(), questID);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(QuestDaoSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
