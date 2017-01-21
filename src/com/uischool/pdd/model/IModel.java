package com.uischool.pdd.model;

import com.uischool.pdd.model.entity.Questions;

/**
 * Created by Влад on 11.11.2016.
 */
public interface IModel {

    public void add(Integer key, Questions value);
    public void remove(Integer key);
    public String get(Integer key);
}
