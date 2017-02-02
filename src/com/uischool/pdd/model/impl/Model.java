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

/**
 * Класс с колекциями в которых записываються юзеры и вопросы, и с ними выполняется работа
 */

public class Model implements IModel {

    private static Map<Integer, Questions> questions = new HashMap<>();
    private static List<Users> users = new ArrayList<>();

    /**
     *Метод добавляет юзера в колекцию
     * @param user объект, который будет добавлен
     */

    public void addUsers(Users user){
        users.add(user);
    }

    /**
     * Метод получает юзера из коллекции по индексу
     * @return возвращает объект юзер из коллекции
     */

    public Users getUsers(){
        return users.get(0);
    }

    /**
     * Удаляет юзера по индексу
     */

    public void removeUsers(){
        users.remove(0);
    }

    @Override
    public void add(Integer key, Questions quest) {
        questions.put(key, quest);
    }

    @Override
    public void remove(Integer key) {
        questions.remove(key);
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
