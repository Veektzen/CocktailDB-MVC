package com.view;

import javax.swing.*;
import java.awt.*;

public class DetailsDialog extends JDialog {

    public DetailsDialog(String list){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2, dimension.height / 2 - this.getSize().height / 2);
        setLayout(new BorderLayout());
        setModal(true);
        JPanel jPan = new JPanel();
        JLabel label = new JLabel(list);
        jPan.add(label);
        add(jPan);
        pack();
    }

}
