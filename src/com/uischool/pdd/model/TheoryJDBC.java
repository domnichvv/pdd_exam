package com.uischool.pdd.model;

import com.uischool.pdd.model.entity.Theory;
import com.uischool.pdd.model.impl.Model;

import java.sql.*;

/**
 * Created by Vlad on 17.01.2017.
 */
public class TheoryJDBC {

    private static Model model;

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pdd_db";

    private static final String USER = "root";
    private static final String PASS = "root";

    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement preparedStmt = null;
    private static ResultSet rs = null;

    public static Theory getTheory(int id){

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String query = "SELECT id, description FROM theory";
            rs = stmt.executeQuery(query);

            while (rs.next()){
                int id_bd = rs.getInt("id");
                String descr = rs.getString("description");

                if(id_bd == id){
                    return new Theory(id_bd, descr);
                }
                else if(id == 0){
                    id = 1;
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
