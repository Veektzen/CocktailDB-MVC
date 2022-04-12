package com.controller;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import com.controller.factory.OsFactory;
import org.json.JSONException;

public class OsListener implements ActionListener {

    public OsListener(JComboBox<String> combo, JDialog dialog) {
        this.combo = combo;
        this.dialog = dialog;
    }

    /**
     * This method is for the button at the beginning dialog
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // close dialog
        dialog.dispose();
        OsFactory osfactory = new OsFactory();
        //
        try {
            (osfactory.getOs(combo.getSelectedItem().toString())).view();
        } catch (JSONException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }


    JComboBox<String> combo;
    JDialog dialog;
}