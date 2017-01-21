package com.uischool.pdd.view_controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.uischool.pdd.model.UsersJDBC;
import com.uischool.pdd.model.impl.Model;
import com.uischool.pdd.MyConstants;

/**
 * Created by Влад on 07.11.2016.
 */
public class AuthorizationGUI extends JFrame implements ActionListener {

    private Model model;

    private JPanel panelMessageDialog;
    private JLabel labelLogin, labelPassword;
    private JTextField textLogin = null;
    private JPasswordField textPassword = null;
    private JButton buttonEntrance, buttonCancel, buttonReg;

    private Box verticalLayoutAuthor, horizontalLayoutLabelLogin, horizontalLayoutLabelPass, horizontalLayoutTextLogin,
            horizontalLayoutTextPass, horizontalLayoutButton, horizontalLayoutButtonReg;

    public AuthorizationGUI(Model model) {
        super(MyConstants.VIEW_TITLE_AUTH);
        super.setIconImage(new ImageIcon(MyConstants.PATH_TO_TITLE_IMAGE).getImage());

        this.model = model;

        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //создаем горизонтальные панели
        horizontalLayoutLabelLogin = Box.createHorizontalBox();
        labelLogin = new JLabel(MyConstants.VIEW_LABEL_LOGIN);
        horizontalLayoutLabelLogin.add(labelLogin);

        horizontalLayoutTextLogin = Box.createHorizontalBox();
        textLogin = new JTextField(MyConstants.AUTH_FIELD_WIDTH);
        horizontalLayoutTextLogin.add(textLogin);

        horizontalLayoutLabelPass = Box.createHorizontalBox();
        labelPassword = new JLabel(MyConstants.VIEW_LABEL_PASS);
        horizontalLayoutLabelPass.add(labelPassword);

        horizontalLayoutTextPass = Box.createHorizontalBox();
        textPassword = new JPasswordField(MyConstants.AUTH_FIELD_WIDTH);
        horizontalLayoutTextPass.add(textPassword);

        horizontalLayoutButton = Box.createHorizontalBox();
        buttonEntrance = new JButton(MyConstants.VIEW_BUTTON_TEXT_ENTRANCE);
        buttonEntrance.addActionListener(this);
        horizontalLayoutButton.add(buttonEntrance);
        horizontalLayoutButton.add(Box.createHorizontalStrut(MyConstants.DISTANCE_BETWEEN_COMPONENTS));
        buttonCancel = new JButton(MyConstants.VIEW_BUTTON_TEXT_CANCEL);
        buttonCancel.addActionListener(this);
        horizontalLayoutButton.add(buttonCancel);


        horizontalLayoutButtonReg = Box.createHorizontalBox();
        buttonReg = new JButton(MyConstants.VIEW_BUTTON_TEXT_REG);
        buttonReg.addActionListener(this);
        horizontalLayoutButtonReg.add(buttonReg);

        //уточняем размер компонента
        labelLogin.setPreferredSize(labelPassword.getPreferredSize());

        //добавляем компоненты к горизонтальной панели;
        verticalLayoutAuthor = Box.createVerticalBox();
        verticalLayoutAuthor.setBorder(new EmptyBorder(MyConstants.BORDER_EMPTY, MyConstants.BORDER_EMPTY,
                MyConstants.BORDER_EMPTY, MyConstants.BORDER_EMPTY));
        verticalLayoutAuthor.add(horizontalLayoutLabelLogin);
        verticalLayoutAuthor.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));
        verticalLayoutAuthor.add(horizontalLayoutTextLogin);
        verticalLayoutAuthor.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));
        verticalLayoutAuthor.add(horizontalLayoutLabelPass);
        verticalLayoutAuthor.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_VERTICAL));
        verticalLayoutAuthor.add(horizontalLayoutTextPass);
        verticalLayoutAuthor.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_AND_BUTTONS_VERTICAL));
        verticalLayoutAuthor.add(horizontalLayoutButton);
        verticalLayoutAuthor.add(Box.createVerticalStrut(MyConstants.DISTANCE_BETWEEN_LAYOUT_AND_BUTTONS_VERTICAL));
        verticalLayoutAuthor.add(horizontalLayoutButtonReg);

        setContentPane(verticalLayoutAuthor);
        pack();
        setLocationRelativeTo(null); //окно по центру экрана(устанавливать после pack())
        setResizable(false); //размер окна не изменяеться
        setVisible(true); //показать окно
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals(MyConstants.VIEW_BUTTON_TEXT_ENTRANCE)) {
            checkUser(textLogin, textPassword);
        } else if (actionCommand.equals(MyConstants.VIEW_BUTTON_TEXT_CANCEL)) {
            System.exit(0);
        } else if (actionCommand.equals(MyConstants.VIEW_BUTTON_TEXT_REG)) {
            registration();
        }
    }

    public void checkUser(JTextField textLogin, JPasswordField textPassword) {

        String loginText = new String(textLogin.getText());
        String passText = new String(textPassword.getPassword());

        if (loginText.equals("") || passText.equals("")) {
            JOptionPane.showMessageDialog(panelMessageDialog, MyConstants.VIEW_MESSAGE_DIALOG_EMPTY_FIELD);
        }
        else if (loginText.equals(MyConstants.ADMIN_LOGIN) && passText.equals(MyConstants.ADMIN_PASS)) {
            JOptionPane.showMessageDialog(panelMessageDialog, MyConstants.VIEW_MESSAGE_DIALOG_ADMIN);
            AdminPanelGUI();
        }
        else {
            if (UsersJDBC.selectUsers(loginText, passText) == true) {
                JOptionPane.showMessageDialog(panelMessageDialog, MyConstants.VIEW_MESSAGE_DIALOG_SUCCESSFUL_AUTH);
                mainGUI();
            } else {
                JOptionPane.showMessageDialog(panelMessageDialog, MyConstants.VIEW_MESSAGE_DIALOG_USER_NOT_FOUND);
                textLogin.setText("");
                textPassword.setText("");
            }
        }
//            JSONParser parser = new JSONParser();
//
//            try {
//                Object obj = parser.parse(new FileReader(MyConstants.FILE_NAME));
//
//                JSONObject jsonObject = (JSONObject) obj;
//
//                // По ключу User получаем значения
//                JSONArray array = (JSONArray) jsonObject.get(MyConstants.USER_SEARCH);
//
//                for (int i = 0; i < array.size(); i++) {
//                    JSONObject object = (JSONObject) array.get(i);
//                    String userLogin = (String) object.get(MyConstants.LOGIN_SEARCH);
//                    String b = (String) object.get(MyConstants.PASSWORD_SEARCH);
//
//                    //Расскодируем логин и пароль
////                    String userLogin = Coding.decryptText(a);
//                    String userPass = Coding.decryptText(b);
//
//                    if (loginText.equals(MyConstants.ADMIN_LOGIN) && passText.equals(MyConstants.ADMIN_PASS)){
//                        JOptionPane.showMessageDialog(panelMessageDialog, MyConstants.VIEW_MESSAGE_DIALOG_ADMIN);
//                        mainAdminGUI();
//                        textLogin.setText("");
//                        textPassword.setText("");
//                        break;
//                    }
//                    else if (loginText.equals(userLogin) && passText.equals(userPass)) {
//                        JOptionPane.showMessageDialog(panelMessageDialog, MyConstants.VIEW_MESSAGE_DIALOG_SUCCESFUL_AUTH);
////                        String userStatus = null;
////                        int userPercent = -1;
////                        Users user = new Users(loginText, passText, userStatus, userPercent);
////                        model = new Model();
////                        model.add("login", user.getUserLogin());
////                        model.add("password", user.getUserPass());
////                        model.add("status", user.getUserStatus());
////                        model.add("percent", String.valueOf(user.getUserPercent()));
//                        mainGUI();
//                        break;
//                    }
//                    else if (array.size() == (i + 1) && !loginText.equals(userLogin) && !passText.equals(userPass)){
//                        JOptionPane.showMessageDialog(panelMessageDialog, MyConstants.VIEW_MESSAGE_DIALOG_USER_NOT_FOUND);
//                        textLogin.setText("");
//                        textPassword.setText("");
//                    }
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
    }

    public void registration() {
        this.setVisible(false);
        this.dispose();
        new RegistrationGUI(model).setVisible(true);
    }

    public void mainGUI() {
        this.setVisible(false);
        this.dispose();
        new MainGUI(model).setVisible(true);
    }

    public void AdminPanelGUI() {
        this.setVisible(false);
        this.dispose();
        new AdminPanelGUI(model).setVisible(true);
    }
}
