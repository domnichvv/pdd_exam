package com.uischool.pdd.view_controller;

import com.uischool.pdd.Coding;
import com.uischool.pdd.MyConstants;
import com.uischool.pdd.model.UsersJDBC;
import com.uischool.pdd.model.impl.Model;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Влад on 09.11.2016.
 */

/**
 * Класс расширает JFrame и создает форму регистрации нового юзера
 */

public class RegistrationGUI extends JFrame implements ActionListener{

    private Model model;

    private JPanel panelDialog;
    private JLabel labelLogin, labelPass, labelRepeatPass;
    private JTextField textLogin;
    private JPasswordField textPass, textRepeatPass;
    private JButton buttonZaReg, buttonBack;

    private Box verticalLayoutReg, horizontalLayoutLabelLogin, horizontalLayoutLabelPass, horizontalLayoutLabelRepeatPass,
            horizontalLayoutTextLogin, horizontalLayoutTextPass, horizontalLayoutTextRepetPass, horizontalLayoutButtonZaReg,
            horizontalLayoutButtonBack;

    public RegistrationGUI(Model model){
        super(MyConstants.VIEW_TITLE_REG);
        super.setIconImage(new ImageIcon(MyConstants.PATH_TO_TITLE_IMAGE).getImage());

        this.model = model;

        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //создаем горизонтальные панели
        horizontalLayoutLabelLogin = Box.createHorizontalBox();
        labelLogin = new JLabel(MyConstants.VIEW_LABEL_LOGIN_REG);
        horizontalLayoutLabelLogin.add(labelLogin);

        horizontalLayoutTextLogin = Box.createHorizontalBox();
        textLogin = new JTextField(MyConstants.REG_FIELD_WIDTH);
        horizontalLayoutTextLogin.add(textLogin);

        horizontalLayoutLabelPass = Box.createHorizontalBox();
        labelPass = new JLabel(MyConstants.VIEW_LABEL_PASS_REG);
        horizontalLayoutLabelPass.add(labelPass);

        horizontalLayoutTextPass = Box.createHorizontalBox();
        textPass = new JPasswordField(MyConstants.REG_FIELD_WIDTH);
        horizontalLayoutTextPass.add(textPass);

        horizontalLayoutLabelRepeatPass = Box.createHorizontalBox();
        labelRepeatPass = new JLabel(MyConstants.VIEW_LABEL_REPEAT_PASS_REG);
        horizontalLayoutLabelRepeatPass.add(labelRepeatPass);

        horizontalLayoutTextRepetPass = Box.createHorizontalBox();
        textRepeatPass = new JPasswordField(MyConstants.REG_FIELD_WIDTH);
        horizontalLayoutTextRepetPass.add(textRepeatPass);

        horizontalLayoutButtonZaReg = Box.createHorizontalBox();
        buttonZaReg = new JButton(MyConstants.VIEW_BUTTON_TEXT_ZAREG);
        buttonZaReg.addActionListener(this);
        horizontalLayoutButtonZaReg.add(buttonZaReg);

        horizontalLayoutButtonBack = Box.createHorizontalBox();
        buttonBack = new JButton(MyConstants.VIEW_BUTTON_TEXT_BACK);
        buttonBack.addActionListener(this);
        horizontalLayoutButtonBack.add(buttonBack);

        //добавляем компоненты к вертикальной панели
        verticalLayoutReg = Box.createVerticalBox();
        verticalLayoutReg.setBorder(new EmptyBorder(MyConstants.BORDER_EMPTY, MyConstants.BORDER_EMPTY,
                MyConstants.BORDER_EMPTY, MyConstants.BORDER_EMPTY));
        verticalLayoutReg.add(horizontalLayoutLabelLogin);
        verticalLayoutReg.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));
        verticalLayoutReg.add(horizontalLayoutTextLogin);
        verticalLayoutReg.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));
        verticalLayoutReg.add(horizontalLayoutLabelPass);
        verticalLayoutReg.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));
        verticalLayoutReg.add(horizontalLayoutTextPass);
        verticalLayoutReg.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));
        verticalLayoutReg.add(horizontalLayoutLabelRepeatPass);
        verticalLayoutReg.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));
        verticalLayoutReg.add(horizontalLayoutTextRepetPass);
        verticalLayoutReg.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_AND_BUTTONS_VERTICAL));
        verticalLayoutReg.add(horizontalLayoutButtonZaReg);
        verticalLayoutReg.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_AND_BUTTONS_VERTICAL));
        verticalLayoutReg.add(horizontalLayoutButtonBack);

        setContentPane(verticalLayoutReg);
        pack();
        setLocationRelativeTo(null); //окно по центру экрана(устанавливать после pack())
        setResizable(false); //размер окна не изменяеться
        setVisible(true); //показать окно
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals(MyConstants.VIEW_BUTTON_TEXT_ZAREG)){
            try {
                checkTextField(textLogin, textPass, textRepeatPass);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if (actionCommand.equals(MyConstants.VIEW_BUTTON_TEXT_BACK)){
            returnToAuthorization();
        }
    }

    public void returnToAuthorization(){
        this.setVisible(false);
        this.dispose();
        new AuthorizationGUI(model).setVisible(true);
    }

    /**
     * Метод проверяющий введенные данные в полях на форме регистрации нового пользователя
     * @param textLogin - введенный логин
     * @param textPass - введенный пароль
     * @param textRepeatPass - повтор пароля
     * @throws IOException исключение, которое может возникнуть
     */

    public void checkTextField(JTextField textLogin, JPasswordField textPass, JPasswordField textRepeatPass) throws IOException {

        String loginText = new String(textLogin.getText());
        String passText = new String(textPass.getPassword());
        String repetPassText = new String(textRepeatPass.getPassword());

        if (loginText.equals("") || passText.equals("") || repetPassText.equals("")) {
            JOptionPane.showMessageDialog(panelDialog, MyConstants.VIEW_MESSAGE_DIALOG_EMPTY_FIELD);
            textPass.setText("");
            textRepeatPass.setText("");
        }
        else if (!(passText.equals(repetPassText))) {
            JOptionPane.showMessageDialog(panelDialog, MyConstants.VIEW_MESSAGE_DIALOG_NOT_EQUALS_PASS);
            textPass.setText("");
            textRepeatPass.setText("");
        }
        else if (passText.length() < 8) {
            JOptionPane.showMessageDialog(panelDialog, MyConstants.VIEW_MESSAGE_DIALOG_SIMVOL_PASS);
            textPass.setText("");
            textRepeatPass.setText("");
        }
        else if (passText.equals(repetPassText)) {
            String userStatus = MyConstants.USERS_START_STATUS;
            String userExamStatus = MyConstants.USERS_START_STATUS;
//            Validation.writeToFile(loginText, Coding.encryptText(passText), userStatus, userPercent);
            UsersJDBC.insertUsers(loginText, Coding.encryptText(passText), userStatus, userExamStatus);
            JOptionPane.showMessageDialog(panelDialog, MyConstants.VIEW_MESSAGE_DIALOG_SUCCESSFUL_ZAREG);
            returnToAuthorization();
        }
    }
}