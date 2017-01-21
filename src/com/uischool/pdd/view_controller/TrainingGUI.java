package com.uischool.pdd.view_controller;

import com.uischool.pdd.MyConstants;
import com.uischool.pdd.model.TheoryJDBC;
import com.uischool.pdd.model.UsersJDBC;
import com.uischool.pdd.model.entity.Theory;
import com.uischool.pdd.model.impl.Model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Влад on 05.12.2016.
 */
public class TrainingGUI extends JFrame implements ActionListener{

    private Model model;

    private static int counterPage = 1;

    private JPanel panelDialog;
    private JLabel labelHead, labelTheory, labelImage;
    private JButton buttonBack, buttonNext, buttonPrev;

    private Box horizontalLayoutHead, horizontalLayoutBody, horizontalLayoutButton, verticalLayout;

    public TrainingGUI(Model model){
        super(MyConstants.VIEW_TITLE_TRAINING);
        super.setIconImage(new ImageIcon(MyConstants.PATH_TO_TITLE_IMAGE).getImage());

        this.model = model;

        setSize(MyConstants.TRAINING_SCREEN_WIDTH, MyConstants.TRAINING_SCREEN_HEIGHT);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //создаем горизонтальную панель для заголовка
        horizontalLayoutHead = Box.createHorizontalBox();
        labelHead = new JLabel(MyConstants.VIEW_TRAINING_HEADER);
        labelHead.setFont(new Font("Serif", Font.PLAIN, 28));
        horizontalLayoutHead.add(labelHead);

        //создаем горизонтальную панель для тела
        horizontalLayoutBody = Box.createHorizontalBox();
        labelTheory = new JLabel("<html>" + TheoryJDBC.getTheory(counterPage).getDescription() + "</html>");
        labelTheory.setFont(new Font("Serif", Font.PLAIN, 18));
        horizontalLayoutBody.add(labelTheory);

        //создаем гоизонтальную панель для кнопок
        horizontalLayoutButton = Box.createHorizontalBox();
        buttonPrev = new JButton(MyConstants.VIEW_BUTTON_PREV);
        horizontalLayoutButton.add(buttonPrev);
        buttonPrev.addActionListener(this);
        horizontalLayoutButton.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_BUTTONS));
        buttonNext = new JButton((MyConstants.VIEW_BUTTON_NEXT));
        horizontalLayoutButton.add(buttonNext);
        buttonNext.addActionListener(this);
        horizontalLayoutButton.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_BUTTONS));
        buttonBack = new JButton(MyConstants.VIEW_BUTTON_TO_MAIN);
        horizontalLayoutButton.add(buttonBack);
        buttonBack.addActionListener(this);

        //создаем вертикальную панель и добавляем на нее ветикальные
        verticalLayout = Box.createVerticalBox();
        verticalLayout.setBorder(new EmptyBorder(MyConstants.BORDER_EMPTY, MyConstants.BORDER_EMPTY,
                MyConstants.BORDER_EMPTY, MyConstants.BORDER_EMPTY));
        verticalLayout.add(horizontalLayoutHead);
        verticalLayout.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));
        verticalLayout.add(horizontalLayoutBody);
        verticalLayout.add(Box.createVerticalGlue());
        verticalLayout.add(horizontalLayoutButton);
        verticalLayout.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));


        setContentPane(verticalLayout);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals(MyConstants.VIEW_BUTTON_TO_MAIN)){
            if (counterPage != 25){
                int result = JOptionPane.showConfirmDialog(panelDialog, MyConstants.VIEW_MESSAGE_EXIT_FROM_TRAINING,
                        MyConstants.VIEW_MESSAGE_EXIT_FROM_TRAINING_TITLE, JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION){
                    counterPage = 1;
                    returnToMainGUI();
                }
            }
            else {
                model = new Model();
                model.getUsers().setUserStatus(MyConstants.USERS_FINAL_STATUS);
                UsersJDBC.updateUsers();
                returnToMainGUI();
                counterPage = 1;
            }
        }
        else if (actionCommand.equals(MyConstants.VIEW_BUTTON_NEXT)){
            counterPage++;
            if (counterPage < 25 && counterPage >= 1){
                viewTheory(counterPage);
            }
            else if (counterPage == 25){
                completedTheory();
            }
        }
        else if (actionCommand.equals(MyConstants.VIEW_BUTTON_PREV)){
            if (counterPage < 25 && counterPage > 1){
                counterPage--;
                viewTheory(counterPage);
            }
        }
    }

    private  void completedTheory(){
        labelHead.setText(MyConstants.VIEW_MESSAGE_ABOUT_FINISH_TRAINING);
        labelHead.setFont(new Font("Serif", Font.PLAIN, 24));
        labelTheory.setVisible(false);
        buttonPrev.setVisible(false);
        buttonBack.setVisible(false);
        buttonNext.setText(MyConstants.VIEW_BUTTON_TO_MAIN);
        buttonNext.setFont(new Font("Serif", Font.PLAIN, 20));
    }

    private void viewTheory(int counterPage){
        Theory theory = TheoryJDBC.getTheory(counterPage);
        labelTheory.setText("<html>" + theory.getDescription() + "</html>");
    }

    private void returnToMainGUI(){
        this.setVisible(false);
        this.dispose();
        new MainGUI(model).setVisible(true);
    }
}
