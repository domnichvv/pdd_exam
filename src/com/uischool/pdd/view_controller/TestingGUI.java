package com.uischool.pdd.view_controller;

import com.uischool.pdd.MyConstants;
import com.uischool.pdd.model.QuestionsJDBC;
import com.uischool.pdd.model.UsersJDBC;
import com.uischool.pdd.model.entity.Questions;
import com.uischool.pdd.model.impl.Model;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Влад on 05.12.2016.
 */

/**
 * Класс расширает JFrame и создает форму для тестирования
 */

public class TestingGUI extends JFrame implements ActionListener{

    private Model model;

    private static int countQuestions = 1;
    private static int counterRightAnswer = 0;
    private static int counterWrongAnswer = 0;
    private static String answer = "";

    private JPanel panelDialog;
    private JLabel labelHeader, labelQuestion, labelCountQuestion, labelRightAnswers, labelWrongAnswers, labelMessageOneAnswer;
    private JCheckBox checkBoxOne, checkBoxTwo, checkBoxThree;
    private JCheckBoxMenuItem checkboxGroup;

    private JButton buttonNext, buttonAnswer, buttonEnd;

    private Box horizontalLayoutHeader, horizontalLayoutQuestion, horizontalLayoutAnswerOne, horizontalLayoutAnswerTwo,
            horizontalLayoutAnswerThree, horizontalLayoutButtons, horizontalLayoutButtonEnd, horizontalLayoutMessage, verticalLayout;

    public TestingGUI(Model model){
        super(MyConstants.VIEW_TITLE_TESTING);

        this.model = model;

        super.setIconImage(new ImageIcon(MyConstants.PATH_TO_TITLE_IMAGE).getImage());

        setSize(MyConstants.TESTING_SCREEN_WIDTH, MyConstants.TESTING_SCREEN_HEIGHT);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //создаем горизонтальную панель для заголовка
        horizontalLayoutHeader = Box.createHorizontalBox();
        labelHeader = new JLabel(MyConstants.VIEW_TESTING_HEADER);
        labelHeader.setFont(new Font("Serif", Font.PLAIN, 26));
        horizontalLayoutHeader.add(labelHeader);

        //создаем горизонтальную панель для вопросов
        horizontalLayoutQuestion = Box.createHorizontalBox();
        labelQuestion = new JLabel("<html>" + String.valueOf(countQuestions) + ".   " +
                QuestionsJDBC.getQuestions(countQuestions).getQuestDescription() + "</html>");
        labelQuestion.setFont(new Font("Serif", Font.PLAIN, 18));
        horizontalLayoutQuestion.add(labelQuestion);

        checkboxGroup = new JCheckBoxMenuItem();

        //создаем горизонтальные панели для ответов
        horizontalLayoutAnswerOne = Box.createHorizontalBox();
        checkBoxOne = new JCheckBox("<html>" + QuestionsJDBC.getQuestions(countQuestions).getAnswer1() + "</html>", false);
        horizontalLayoutAnswerOne.add(checkBoxOne);

        horizontalLayoutAnswerTwo = Box.createHorizontalBox();
        checkBoxTwo = new JCheckBox("<html>" + QuestionsJDBC.getQuestions(countQuestions).getAnswer2() + "</html>", false);
        horizontalLayoutAnswerTwo.add(checkBoxTwo);

        horizontalLayoutAnswerThree = Box.createHorizontalBox();
        checkBoxThree = new JCheckBox("<html>" + QuestionsJDBC.getQuestions(countQuestions).getAnswer3() + "</html>", false);
        horizontalLayoutAnswerThree.add(checkBoxThree);

        horizontalLayoutMessage = Box.createHorizontalBox();
        labelMessageOneAnswer = new JLabel(MyConstants.VIEW_MESSAGE_MUST_BE_ONE_ANSWER);
        labelMessageOneAnswer.setFont(new Font("Serif", Font.ITALIC, 14));
        horizontalLayoutMessage.add(labelMessageOneAnswer);

        //создаем горизонтальную панель для кнопок
        horizontalLayoutButtons = Box.createHorizontalBox();
        buttonAnswer = new JButton(MyConstants.VIEW_BUTTON_ANSWER);
        buttonAnswer.addActionListener(this);
        horizontalLayoutButtons.add(buttonAnswer);
        horizontalLayoutButtons.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_BUTTONS));
        labelCountQuestion = new JLabel(countQuestions());
        horizontalLayoutButtons.add(labelCountQuestion);
        horizontalLayoutButtons.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_BUTTONS));
        buttonNext = new JButton(MyConstants.VIEW_BUTTON_NEXT_QUESTION);
        buttonNext.addActionListener(this);
        horizontalLayoutButtons.add(buttonNext);

        //создаем панель для кнопки окончания экзамена и лейбы правильности ответов
        horizontalLayoutButtonEnd = Box.createHorizontalBox();
        horizontalLayoutButtonEnd.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_COMPONENTS));
        labelRightAnswers = new JLabel(MyConstants.VIEW_MESSAGE_RIGHT_ANSWER);
        labelRightAnswers.setFont(new Font("Serif", Font.PLAIN, 28));
        labelRightAnswers.setForeground(Color.GREEN);
        labelRightAnswers.setVisible(false);
        horizontalLayoutButtonEnd.add(labelRightAnswers);
        horizontalLayoutButtonEnd.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_ANSWERS_LABEL));
        buttonEnd = new JButton(MyConstants.VIEW_BUTTON_END);
        buttonEnd.setFont(new Font("Serif", Font.PLAIN, 16));
        buttonEnd.addActionListener(this);
        horizontalLayoutButtonEnd.add(buttonEnd);
        horizontalLayoutButtonEnd.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_ANSWERS_LABEL));
        labelWrongAnswers = new JLabel(MyConstants.VIEW_MESSAGE_WRONG_ANSWER);
        labelWrongAnswers.setFont(new Font("Serif", Font.PLAIN, 28));
        labelWrongAnswers.setForeground(Color.RED);
        labelWrongAnswers.setVisible(false);
        horizontalLayoutButtonEnd.add(labelWrongAnswers);
        horizontalLayoutButtonEnd.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_COMPONENTS));

        //создаем вертикальную панель
        verticalLayout = Box.createVerticalBox();
        verticalLayout.setBorder(new EmptyBorder(MyConstants.BORDER_EMPTY, MyConstants.BORDER_EMPTY,
                MyConstants.BORDER_EMPTY, MyConstants.BORDER_EMPTY));
        verticalLayout.add(horizontalLayoutHeader);
        verticalLayout.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_ANSWERS));
        verticalLayout.add(horizontalLayoutQuestion);
        verticalLayout.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_ANSWERS));
        verticalLayout.add(horizontalLayoutAnswerOne);
        verticalLayout.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_ANSWERS));
        verticalLayout.add(horizontalLayoutAnswerTwo);
        verticalLayout.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_ANSWERS));
        verticalLayout.add(horizontalLayoutAnswerThree);
        verticalLayout.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_ANSWERS));
        verticalLayout.add(horizontalLayoutMessage);
        verticalLayout.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_ANSWERS));
        verticalLayout.add(horizontalLayoutButtons);
        verticalLayout.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));
        verticalLayout.add(horizontalLayoutButtonEnd);
        verticalLayout.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));

        setContentPane(verticalLayout);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actionCommand = e.getActionCommand();

        if (actionCommand.equals(MyConstants.VIEW_BUTTON_ANSWER)){

            if (checkBoxOne.isSelected() == false & checkBoxTwo.isSelected() == false & checkBoxThree.isSelected() == false){
                JOptionPane.showMessageDialog(panelDialog,MyConstants.VIEW_MESSAGE_DIALOG_EMPTY_ANSWER);
            }
            else checkAnswer();
        }
        else if (actionCommand.equals(MyConstants.VIEW_BUTTON_NEXT_QUESTION)){

            if (checkBoxOne.isSelected() == false & checkBoxTwo.isSelected() == false & checkBoxThree.isSelected() == false){
                JOptionPane.showMessageDialog(panelDialog,MyConstants.VIEW_MESSAGE_DIALOG_EMPTY_ANSWER);
            }
            else if (answer.isEmpty()){
                JOptionPane.showMessageDialog(panelDialog, MyConstants.VIEW_MESSAGE_DIALOG_NOT_ANSWER);
            }
            else if (countQuestions < 20 && countQuestions >= 1){
                countQuestions++;
                visibleAndEnableComponents();
                nextPrevPages();
            }
            else if (countQuestions == 20){
                finishTesting();
            }
            else labelCountQuestion.setText(countQuestions());
        }
        else if (actionCommand.equals(MyConstants.VIEW_BUTTON_END)){

            if (countQuestions != 20){
                int result = JOptionPane.showConfirmDialog(panelDialog, MyConstants.VIEW_MESSAGE_EXIT_FROM_TESTING,
                        MyConstants.VIEW_MESSAGE_EXIT_FROM_TESTING_TITLE, JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION){
                    countQuestions = 1;
                    returnToMain();
                }
                else if (result == JOptionPane.NO_OPTION){
                    return;
                }
            }
            countQuestions = 1;
            returnToMain();
        }
    }

    /**
     * Метод выводит не форму вопросы и ответы
     */

    private void nextPrevPages(){
        Questions quest = QuestionsJDBC.getQuestions(countQuestions);
        labelCountQuestion.setText(countQuestions());
        labelQuestion.setText("<html>" + String.valueOf(countQuestions) + ".   " + quest.getQuestDescription() + "</html>");
        checkBoxOne.setText("<html>" + quest.getAnswer1() + "</html>");
        checkBoxTwo.setText("<html>" + quest.getAnswer2() + "</html>");
        checkBoxThree.setText("<html>" + quest.getAnswer3() + "</html>");
    }

    /**
     * Метод сверяеет выбраный ответ с правильным
     */

    private void checkAnswer(){
        String right_answer = QuestionsJDBC.getQuestions(countQuestions).getRight_answer();
        answer = "answer";

        if (checkBoxOne.isSelected() == true){
            if (checkBoxOne.getText().equals("<html>" + right_answer + "</html>")){
                counterRightAnswer++;
                labelRightAnswers.setVisible(true);
                falseCheckBox();
            }
            else {
                labelWrongAnswers.setVisible(true);
                counterWrongAnswer++;
                falseCheckBox();
            }
        }
        if (checkBoxTwo.isSelected() == true){
            if (checkBoxTwo.getText().equals("<html>" + right_answer + "</html>")){
                counterRightAnswer++;
                labelRightAnswers.setVisible(true);
                falseCheckBox();
            }
            else {
                labelWrongAnswers.setVisible(true);
                counterWrongAnswer++;
                falseCheckBox();
            }
        }
        if (checkBoxThree.isSelected() == true){
            if (checkBoxThree.getText().equals("<html>" + right_answer + "</html>")){
                counterRightAnswer++;
                labelRightAnswers.setVisible(true);
                falseCheckBox();
            }
            else {
                labelWrongAnswers.setVisible(true);
                counterWrongAnswer++;
                falseCheckBox();
            }
        }
    }

    //show result testing

    /**
     * Метод по завершении тестирования выводит на форму результаты.
     * Если правильных ответов 15 и больше - тестирование сдано, иначе - нет
     */

    private void finishTesting(){
        if (counterRightAnswer < 15){
            labelHeader.setText("<html>" + MyConstants.VIEW_MESSAGE_ABOUT_NOT_FINISH_TESTING + "</html>");
            labelQuestion.setText(MyConstants.VIEW_MESSAGE_RIGHT_ANSWERS + counterRightAnswer + "  " +
                    MyConstants.VIEW_MESSAGE_WRONG_ANSWERS + counterWrongAnswer);
            visibleComponents();
            model = new Model();
            model.getUsers().setUserExamStatus(MyConstants.USERS_START_STATUS);
            UsersJDBC.updateUsers();
        }
        else if (counterRightAnswer > 15){
            labelHeader.setText(MyConstants.VIEW_MESSAGE_ABOUT_FINISH_TESTING);
            labelQuestion.setText(MyConstants.VIEW_MESSAGE_RIGHT_ANSWERS + counterRightAnswer + " " +
                    MyConstants.VIEW_MESSAGE_WRONG_ANSWERS + counterWrongAnswer);
            visibleComponents();
            model = new Model();
            model.getUsers().setUserExamStatus(MyConstants.USERS_FINAL_STATUS);
            UsersJDBC.updateUsers();
        }
        else {
            labelHeader.setText(MyConstants.VIEW_MESSAGE_ABOUT_FINISH_TESTING);
        }
    }

    private void visibleAndEnableComponents(){
        labelRightAnswers.setVisible(false);
        labelWrongAnswers.setVisible(false);
        answer = "";
        checkBoxOne.setEnabled(true);
        checkBoxOne.setSelected(false);
        checkBoxTwo.setEnabled(true);
        checkBoxTwo.setSelected(false);
        checkBoxThree.setEnabled(true);
        checkBoxThree.setSelected(false);
    }

    private void visibleComponents(){
        checkBoxOne.setVisible(false);
        checkBoxTwo.setVisible(false);
        checkBoxThree.setVisible(false);
        labelRightAnswers.setVisible(false);
        labelWrongAnswers.setVisible(false);
        labelCountQuestion.setVisible(false);
        buttonAnswer.setVisible(false);
        buttonNext.setVisible(false);
        labelMessageOneAnswer.setVisible(false);
    }

    //make checkboxes enabled false
    private void falseCheckBox(){
        checkBoxOne.setEnabled(false);
        checkBoxTwo.setEnabled(false);
        checkBoxThree.setEnabled(false);
    }

    //counter questions
    private String countQuestions(){
        return "Вопрос " + String.valueOf(countQuestions) + " из 20";
    }

    private void returnToMain(){
        this.setVisible(false);
        this.dispose();
        new MainGUI(model).setVisible(true);
    }
}
