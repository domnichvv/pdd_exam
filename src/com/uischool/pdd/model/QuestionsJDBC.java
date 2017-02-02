package com.uischool.pdd.model;

import com.uischool.pdd.model.entity.Questions;
import com.uischool.pdd.model.impl.Model;

import java.sql.*;

/**
 * Created by Vlad on 17.01.2017.
 */
public class QuestionsJDBC {

    private static Model model;

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pdd_db";

    private static final String USER = "root";
    private static final String PASS = "root";

    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement preparedStmt = null;
    private static ResultSet rs = null;

    /**
     * Метод выбирает из БД вопросы по идентификатору.
     * @param id - идентификатор вопроса
     * @return возващает объект Questions
     */

    public static Questions getQuestions(int id){
        try {

            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String query = "SELECT id, description, answer1, answer2, answer3, right_answer FROM questions";
            rs = stmt.executeQuery(query);

            while (rs.next()){
                int idd = rs.getInt("id");
                String descr = rs.getString("description");
                String answer1 = rs.getString("answer1");
                String answer2 = rs.getString("answer2");
                String answer3 = rs.getString("answer3");
                String right_answer = rs.getString("right_answer");

                if(idd == id){
                    return new Questions(idd, descr, answer1, answer2, answer3, right_answer);
                }
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(stmt != null){
                    stmt.close();
                }
            } catch (SQLException se1) {}
            try{
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException se2){}
        }
        return null;
    }
}
