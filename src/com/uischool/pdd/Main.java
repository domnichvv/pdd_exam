package com.uischool.pdd;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.uischool.pdd.model.impl.Model;
import com.uischool.pdd.view_controller.AuthorizationGUI;
import javax.swing.*;
import java.io.IOException;

public class Main {

    private static Model model;

    public static void main(String[] args) throws IOException{

        model = new Model();

        try {
            UIManager.setLookAndFeel(new McWinLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AuthorizationGUI(model);
            }
        });
    }

    public static Model getModel() {
        return model;
    }
}
