package com.view;

import javax.swing.*;

import com.controller.WishListActionListener;
import com.model.dao.Cocktail;
import com.view.CocktailDisplay;
import org.json.JSONException;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import com.model.singleton.Singleton;
//import com.controller.WishListActionListener;


public class MainFrame {

    private JFrame frame;

    private JPanel midPanel;
    private JPanel topPanel;
    private JLabel title;
    private JScrollPane scrollPane;
    private String frameTitle;
    private Color color;
    private String framePhoto;


    public MainFrame(String frameTitle, Color color, String framePhoto) throws JSONException, IOException, InterruptedException {
        this.frameTitle = frameTitle;
        this.color = color;
        this.framePhoto = framePhoto;
        initialize();
    }

    private void initialize() throws JSONException, IOException, InterruptedException {

        // --------------------FRAME--------------------------
        // initialize frame
        frame = new JFrame();
        // give title to frame
        frame.setTitle(frameTitle);
        // when you hit X the program closes completely
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the size of the frame
        frame.setSize(1600, 1000);
        // by default the layout on frame is border layout
        frame.setLayout(new BorderLayout());
        // frame is displayed in the middle of the screen
        frame.setLocationRelativeTo(null);
        // we can't resize the frame
        frame.setResizable(false);
        // set frame up left icon
        ImageIcon frameImg = new ImageIcon(framePhoto);
        frame.setIconImage(frameImg.getImage());
        // --------------------FRAME--------------------------
        //
        //
        // --------------------PANEL1-------------------------
        // initialize mid panel with grid layout
        // in grid layout manager we have 4 rows, 5 columns
        // and 10 vertical and 10 horizontal pixels gap
        midPanel = new JPanel(new GridLayout(0, 5, 10, 10));
        scrollPane = new JScrollPane();

        // faster scroll on mid panel
        scrollPane.setViewportView(midPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        // set border to the panel
        // midPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // set background color to the panel
        midPanel.setBackground(color);
        Singleton instance = Singleton.getInstance();
        List<Cocktail> cocktails = instance.getCocktailR().getAll().subList(0, 100);
        List<Cocktail> favorites = instance.getFavoriteR().readJson();

        // display the list of cocktails
        for (int i = 0; i < cocktails.size(); i++) {
            if (i == 4 || i == 62) {
                continue;
            } else {

                midPanel.add(new CocktailDisplay(cocktails.get(i)));
                consoleProgressBar(i);
            }
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
        title = new JLabel("Welcome to cocktail DB. Please Choose your favourite cocktails", JLabel.CENTER);

        // add label to the panel
        topPanel.add(title);

        // add color to the text
        title.setForeground(Color.BLACK);

        // change the font of color
        title.setFont(new Font("Sans-serif", Font.PLAIN, 36));
        // --------------------TITLE-------------------------

        // -------------------WISHLIST-----------------------
        ImageIcon imageIcon = new ImageIcon("assets/images/wishlist.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH); // scale
        imageIcon = new ImageIcon(newimg); // transform it back
        JButton wishlist = new JButton(imageIcon);
        wishlist.setBackground(Color.WHITE);
        wishlist.setFocusable(false);
        wishlist.setToolTipText("Click to see the list with your favourite cocktails");
        WishListActionListener action = new WishListActionListener();
        wishlist.addActionListener(action);
        frame.add(wishlist, BorderLayout.SOUTH);

        // -------------------WISHLIST-----------------------
        // show the frame
//		frame.pack();
        show();
    }

    private void consoleProgressBar(int i) {
        //console progress bar
        if (i < 9) {
            System.out.print(i + 1 + "%........|\r");
        }
        if (i > 9) {
            System.out.print(i + 1 + "%.......|\r");
        }
        if (i > 13) {
            System.out.print(i + 1 + "%|......|\r");
        }
        if (i > 19) {
            System.out.print(i + 1 + "%||.....|\r");
        }
        if (i > 29) {
            System.out.print(i + 1 + "%|||....|\r");
        }
        if (i > 39) {
            System.out.print(i + 1 + "%||||...|\r");
        }
        if (i > 59) {
            System.out.print(i + 1 + "%|||||..|\r");
        }
        if (i > 79) {
            System.out.print(i + 1 + "%||||||.|\r");
        }
        if (i > 98) {
            System.out.print(i + 1 + "%|||||||\r");
        }
        //end of console progress bar
    }

    public void show() {
        this.frame.setVisible(true);
    }

}