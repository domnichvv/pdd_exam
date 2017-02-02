package com.uischool.pdd.view_controller;

import com.uischool.pdd.MyConstants;
import com.uischool.pdd.model.impl.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Влад on 12.11.2016.
 */
public class MainGUI extends JFrame implements ActionListener{

    private Model model;

    private JPanel panelDialog;
    private JLabel labelImage, labelLogin;
    private JButton buttonTraining, buttonTesting, buttonExit;

    public MainGUI(Model model){
        super(MyConstants.VIEW_TITLE_MAIN);

        this.model = model;

        super.setIconImage(new ImageIcon(MyConstants.PATH_TO_TITLE_IMAGE).getImage());

        setLayout(null);
        setSize(MyConstants.MAIN_SCREEN_WIDTH, MyConstants.MAIN_SCREEN_HEIGHT);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon image = new ImageIcon(MyConstants.PATH_TO_IMAGE_IN_MAIN);
        labelImage = new JLabel(image);
        labelImage.setBounds(0, 10, 120, 120);

        labelLogin = new JLabel("<html>" + viewUsersInfo() + "</html>");
        labelLogin.setBounds(330, 10, 250, 80);
        labelLogin.setFont(new Font("Serif", Font.PLAIN, 16));

        buttonTraining = new JButton(MyConstants.VIEW_BUTTON_TRAINING);
        buttonTraining.setFont(new Font("Serif", Font.ITALIC, 24));
        buttonTraining.addActionListener(this);
        buttonTraining.setBounds(150, 140, 300, 40);

        buttonTesting = new JButton(MyConstants.VIEW_BUTTON_TESTING);
        buttonTesting.setFont(new Font("Serif", Font.ITALIC, 24));
        buttonTesting.addActionListener(this);
        buttonTesting.setBounds(150, 210, 300, 40);

        buttonExit = new JButton(MyConstants.VIEW_BUTTON_EXIT);
        buttonExit.setFont(new Font("Serif", Font.ITALIC, 24));
        buttonExit.addActionListener(this);
        buttonExit.setBounds(150, 280, 300, 40);

        getContentPane().add(labelImage);
        getContentPane().add(labelLogin);
        getContentPane().add(buttonTraining);
        getContentPane().add(buttonTesting);
        getContentPane().add(buttonExit);

        /*pack();*/ //устанавливает такой минимальный размер окна, что бы влезли все компоненты
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals(MyConstants.VIEW_BUTTON_TRAINING)){
            trainingGUI();
        }
        else if (actionCommand.equals(MyConstants.VIEW_BUTTON_TESTING)){
            testingGUI();
        }
        else if (actionCommand.equals(MyConstants.VIEW_BUTTON_EXIT)){
            model = new Model();
            model.removeUsers();
            authorizationGUI();
        }
    }

    /**
     * Метод показывает на главном экране информацию о вошедшем в систему юзере
     * @return возвращает строку с информацией
     */

    private String viewUsersInfo(){
        model = new Model();
        String name = model.getUsers().getUserLogin();
        String status = model.getUsers().getUserStatus();
        String examStatus = model.getUsers().getUserExamStatus();
        if (status.equals(MyConstants.USERS_FINAL_STATUS) & examStatus.equals(MyConstants.USERS_FINAL_STATUS)){
            return "Вы вошли под логином: " + name + "<br>" +  "У Вас обучение - пройдено" + "<br>" + "Экзамен - сдан";
        }
        else if (status.equals(MyConstants.USERS_START_STATUS) & examStatus.equals(MyConstants.USERS_FINAL_STATUS)){
            return "Вы вошли под логином: " + name + "<br>" + "У Вас обучение - не пройдено" + "<br>" + "Экзамен - сдан";
        }
        else if (status.equals(MyConstants.USERS_START_STATUS) & examStatus.equals(MyConstants.USERS_START_STATUS)){
            return "Вы вошли под логином: " + name + "<br>" + "У Вас обучение - не пройдено" + "<br>" + "Экзамен - не сдан";
        }
        else if (status.equals(MyConstants.USERS_FINAL_STATUS) & examStatus.equals(MyConstants.USERS_START_STATUS)){
            return "Вы вошли под логином: " + name + "<br>" + "У Вас обучение - пройдено" + "<br>" + "Экзамен - не сдан";
        }
        return null;
    }

    private void trainingGUI(){
        this.setVisible(false);
        this.dispose();
        new TrainingGUI(model).setVisible(true);
    }

    private void authorizationGUI(){
        this.setVisible(false);
        this.dispose();
        new AuthorizationGUI(model).setVisible(true);
    }

    private void testingGUI(){
        model = new Model();
        if (model.getUsers().getUserStatus().equals(MyConstants.USERS_START_STATUS)){
            int result = JOptionPane.showConfirmDialog(panelDialog, MyConstants.VIEW_MESSAGE_DIALOG_NOT_FINISH_TRAINING,
                    MyConstants.VIEW_MESSAGE_DIALOG_TITLE_NOT_FINISH_TRAINING, JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
                this.setVisible(false);
                this.dispose();
                new TestingGUI(model).setVisible(true);
            } else return;
        } else {
            this.setVisible(false);
            this.dispose();
            new TestingGUI(model).setVisible(true);
        }
    }
}
