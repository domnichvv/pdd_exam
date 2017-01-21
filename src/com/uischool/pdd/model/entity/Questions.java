package com.uischool.pdd.model.entity;

import com.uischool.pdd.MyConstants;
import com.uischool.pdd.model.impl.Model;

import java.awt.*;
import java.util.Set;

/**
 * Created by Влад on 12.11.2016.
 */
public class Questions {

    private int questID = -1;
    private String questDescription = null;
    private String answer1 = null;
    private String answer2 = null;
    private String answer3 = null;
    private String right_answer = null;

    public Questions(int questID, String questDescription, String answer1, String answer2, String answer3, String right_answer) {
        this.questID = questID;
        this.questDescription = questDescription;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.right_answer = right_answer;
    }

    public Questions(){}

    public int getQuestID() {
        return questID;
    }

    public void setQuestID(int questID) {
        this.questID = questID;
    }

    public String getQuestDescription() {
        return questDescription;
    }

    public void setQuestDescription(String questDescription) {
        this.questDescription = questDescription;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getRight_answer() {
        return right_answer;
    }

    public void setRight_answer(String right_answer) {
        this.right_answer = right_answer;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "questID=" + questID +
                ", questDescription='" + questDescription + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", right_answer='" + right_answer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Questions questions = (Questions) o;

        return questID == questions.questID;

    }

    @Override
    public int hashCode() {
        return questID;
    }
}
