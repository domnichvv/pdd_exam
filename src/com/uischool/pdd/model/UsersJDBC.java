package com.uischool.pdd.model;

import com.uischool.pdd.Coding;
import com.uischool.pdd.MyConstants;
import com.uischool.pdd.model.entity.Users;
import com.uischool.pdd.model.impl.Model;

import java.sql.*;

/**
 * Created by Vlad on 17.01.2017.
 */
public class UsersJDBC {

    private static Model model;

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pdd_db";

    private static final String USER = "vlad";
    private static final String PASS = "987654321";

    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement preparedStmt = null;
    private static ResultSet rs = null;

    public static void insertUsers(String user_login, String user_pass, String user_status, String user_exam_status){
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database....");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //execute query
            String query = "INSERT INTO users(user_login, user_pass, user_status, user_exam_status) VALUES(?, ?, ?, ?)";

            //create the mysql insert prepared statement
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, user_login);
            preparedStmt.setString(2, user_pass);
            preparedStmt.setString(3, user_status);
            preparedStmt.setString(4, user_exam_status);

            //execute prepared statement
            preparedStmt.execute();
            System.out.println("Successful registration!");

            conn.close();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            }
            catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static boolean selectUsers(String loginText, String passText){

        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Create a statement object
            stmt = conn.createStatement();

            //STEP 5: Execute a query
            String query = "SELECT id, user_login, user_pass, user_status, user_exam_status FROM users";
            rs = stmt.executeQuery(query);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int userId = rs.getInt("id");
                String userLogin = rs.getString("user_login");
                String userPassNo = rs.getString("user_pass");
                String userStatus = rs.getString("user_status");
                String userExamStatus = rs.getString("user_exam_status");

                String userPass = Coding.decryptText(userPassNo);

                if (loginText.equals(userLogin) && passText.equals(userPass)) {
                    Users user = new Users(userId, userLogin, userPass, userStatus, userExamStatus);
                    model = new Model();
                    model.addUsers(user);
                    return true;
                }
            }

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return false;
    }

    public static void updateUsers(){
        model = new Model();
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Create a statement object
            stmt = conn.createStatement();

            //STEP 5: Execute a query
            String queryStatus = "UPDATE users SET user_status = ?, user_exam_status = ? WHERE id = ?";

            //update the user_status
            preparedStmt = conn.prepareStatement(queryStatus);
            preparedStmt.setString(1, model.getUsers().getUserStatus());
            preparedStmt.setString(2, model.getUsers().getUserExamStatus());
            preparedStmt.setInt(3, model.getUsers().getUserID());
            preparedStmt.execute();

            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }
}
