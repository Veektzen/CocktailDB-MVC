package com.view.factory;

import com.controller.OsListener;

import javax.swing.*;
import java.awt.*;

public class ChooseDialog extends JDialog {

    public ChooseDialog() {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2, dimension.height / 2 - this.getSize().height / 2);

        this.setPreferredSize(new Dimension(500, 100));

        this.setTitle("Choose your operating System");
        JComboBox<String> combo = new JComboBox();
        JButton button = new JButton("Continue");
        JLabel label = new JLabel("Cocktail DB");
        ImageIcon frameImg = new ImageIcon("assets/images/dialogIcon.png");
        this.setIconImage(frameImg.getImage());

        // combo settings
        combo.addItem("Windows");
        combo.addItem("MacOS");
        combo.addItem("Linux");
        combo.setOpaque(false);

        //button settings
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.addActionListener(new OsListener(combo, this));
        button.setBackground(Color.WHITE);
        button.setFocusable(false);

        //add the button and combo to a new panel
        JPanel myPanel = new JPanel(new GridLayout(0, 1));
        myPanel.add(label);
        myPanel.add(combo);
        myPanel.add(button);

        //then add these on dialog
        add(myPanel);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        pack();
    }

}
