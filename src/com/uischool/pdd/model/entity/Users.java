package com.uischool.pdd.model.entity;

/**
 * Created by Влад on 11.11.2016.
 */

/**
 * Класс описание сущности Users(пользователи). Содержит переменные экземпляра: идентификатор, логин, пароль,
 * статус прохожедения обучения и статус сдачи экзамена
 */

public class Users{

    private int userID = -1;
    private String userLogin = null;
    private String userPass = null;
    private String userStatus = null;
    private String userExamStatus = null;

    public Users(int userID, String userLogin, String userPass, String userStatus, String userExamStatus){
        this.userID = userID;
        this.userLogin = userLogin;
        this.userPass = userPass;
        this.userStatus = userStatus;
        this.userExamStatus = userExamStatus;
    }

    public Users(){}

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserExamStatus() {
        return userExamStatus;
    }

    public void setUserExamStatus(String userExamStatus) {
        this.userExamStatus = userExamStatus;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userID=" + userID +
                ", userLogin='" + userLogin + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userExamStatus=" + userExamStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        return userLogin == users.userLogin;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
