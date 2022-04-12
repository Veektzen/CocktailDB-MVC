package com.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.view.SecondFrame;

public class WishListActionListener implements ActionListener {

    public WishListActionListener() {

    }

    /**
     * This method is for the wishlist button
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        SecondFrame frame2 = new SecondFrame();
        frame2.show();

    }
}
