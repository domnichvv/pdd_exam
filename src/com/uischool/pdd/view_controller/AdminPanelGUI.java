package com.uischool.pdd.view_controller;

import javax.swing.*;

import com.uischool.pdd.MyConstants;
import com.uischool.pdd.model.impl.Model;

/**
 * Created by Влад on 17.12.2016.
 */
public class AdminPanelGUI extends JFrame{

    private Model model;

    public AdminPanelGUI(Model model){
        super(MyConstants.VIEW_TITLE_ADMIN);

        this.model = model;



        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
