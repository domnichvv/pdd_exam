package com.uischool.pdd.model.impl;

import com.uischool.pdd.model.IModel;
import com.uischool.pdd.model.UsersJDBC;
import com.uischool.pdd.model.entity.Questions;
import com.uischool.pdd.model.entity.Theory;
import com.uischool.pdd.model.entity.Users;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Влад on 12.11.2016.
 */
public class Model implements IModel {

    private static Map<Integer, Questions> questions = new HashMap<>();
    private static List<Users> users = new ArrayList<>();

    public void addUsers(Users user){
        users.add(user);
    }

    public Users getUsers(){
        return users.get(0);
    }

    public void removeUsers(){
        users.remove(0);
    }

    @Override
    public void add(Integer key, Questions quest) {
        questions.put(key, quest);
    }

    @Override
    public void remove(Integer index) {
        questions.remove(index);
    }

    @Override
    public String get(Integer key) {
        return questions.get(key).getQuestDescription();
    }

    @Override
    public String toString() {
        return "Model{}";
    }
}
