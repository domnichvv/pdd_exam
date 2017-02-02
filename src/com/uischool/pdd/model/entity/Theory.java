package com.uischool.pdd.model.entity;

/**
 * Created by Vlad on 12.01.2017.
 */

/**
 * Класс описание сущности Theory(теория). Содержит две переменные экземпляра: идентификатор и описание
 */

public class Theory {

    private int id = -1;
    private String description = null;

    public Theory(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Theory(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Theory{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
