package com.view;

import javax.swing.*;

import com.model.dao.Cocktail;
import com.model.singleton.Singleton;

import java.awt.*;
import java.util.List;

public class SecondFrame {

    private JFrame frame;
    private JPanel midPanel;
    private JPanel topPanel;
    private JLabel title;
    private JScrollPane scrollPane;

    public SecondFrame() {

        initialize();
    }

    private void initialize() {

        // --------------------FRAME--------------------------
        // initialize frame
        frame = new JFrame();
        // give title to frame
        frame.setTitle("Favorites");
        // when you hit X the program closes completely
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // set the size of the frame
        frame.setSize(800, 500);
        // by default the layout on frame is border layout
        frame.setLayout(new BorderLayout());
        // frame is displayed in the middle of the screen
        frame.setLocationRelativeTo(null);
        // we can't resize the frame
        frame.setResizable(false);
        // frame icon
        ImageIcon frameImg = new ImageIcon("assets/images/favoritesIcon.png");
        frame.setIconImage(frameImg.getImage());
        // --------------------FRAME--------------------------
        //
        //
        // --------------------PANEL1-------------------------
        // initialize mid panel with grid layout
        // in grid layout manager we have 4 rows, 5 columns
        // and 10 vertical and 10 horizontal pixels gap
        midPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        scrollPane = new JScrollPane();


        // faster scroll on mid panel
        scrollPane.setViewportView(midPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        // set border to the panel
        // midPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // set background color to the panel
        midPanel.setBackground(Color.GRAY);

        Singleton instance = Singleton.getInstance();
        List<Cocktail> favorites = instance.getFavoriteR().getAll();
        // display the list of cocktails
        for (int i = 0; i < favorites.size(); i++) {


            midPanel.add(new CocktailDisplayFavorite(favorites.get(i)));

        }

        // add panel to the frame
        frame.add(scrollPane, BorderLayout.CENTER);

        // --------------------PANEL1-------------------------
        //
        //
        //
        // --------------------PANEL2-------------------------
        // initialize panel
        topPanel = new JPanel();
        // set border to the panel
        // topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // set background color to the panel
        topPanel.setBackground(Color.LIGHT_GRAY);
        // add panel to the frame
        frame.add(topPanel, BorderLayout.NORTH);

        // --------------------PANEL2-------------------------
        //
        //
        //
        // --------------------TITLE-------------------------
        // label can have nothing or text or graphic
        title = new JLabel("Favorites", JLabel.CENTER);

        // add label to the panel
        topPanel.add(title);

        // add color to the text
        title.setForeground(Color.BLACK);

        // change the font of color
        title.setFont(new Font("Sans-serif", Font.BOLD, 36));
        // --------------------TITLE-------------------------

        // show the frame
        show();
    }

    public void show() {
        this.frame.setVisible(true);
    }

}