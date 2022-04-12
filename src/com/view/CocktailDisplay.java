package com.view;

import com.controller.AddFavoriteActionListener;
import com.controller.DetailsListener;
import com.model.dao.Cocktail;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;


public class CocktailDisplay extends JPanel {
    private Cocktail cocktail;

    public CocktailDisplay(Cocktail cocktail) {
        this.cocktail = cocktail;
        display(cocktail);
    }

    /**
     * This method is the cocktail display, that contains title and image of the cocktail, also a button to add to favorites list
     *
     * @param cocktail
     */
    public void display(Cocktail cocktail) {
        setLayout(new BorderLayout());

        try {
            // here we get the image
            URL url = new URL(cocktail.getImg());
            BufferedImage c = ImageIO.read(url);
            ImageIcon imageIcon = new ImageIcon(c); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // scale
            imageIcon = new ImageIcon(newimg); // transform it back
            JLabel iconLabel = new JLabel(cocktail.getName(), imageIcon, JLabel.CENTER);
            // set font in label
            iconLabel.setFont(new Font("Sans-serif", Font.BOLD, 16));
            // give position to the icon in horizontal and vertical axis
            // by changing text position
            iconLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            iconLabel.setVerticalTextPosition(SwingConstants.TOP);
            // add label to panel
            add(iconLabel, BorderLayout.CENTER);
            //mouse listener for details
            DetailsListener detailsListener = new DetailsListener(cocktail.getId());
            iconLabel.addMouseListener(detailsListener);


        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException in Class CocktailDisplay");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException in Class CocktailDisplay");
            e.printStackTrace();
        }
        //
        // add to favorites button
        JButton button = new JButton();
        button.setFocusable(false);
        // add image icon to the button
        ImageIcon favoriteIcon = new ImageIcon("assets/images/addFavorite.png");
        button.setIcon(favoriteIcon);
        // add tool tip to the button when hover
        button.setToolTipText("Click to add to favourites list");
        // set button color
        button.setBackground(Color.WHITE);
        // set margin for button
        button.setMargin(new Insets(10, 10, 10, 10));
        // set the preferred size of button by pixels
        button.setPreferredSize(new Dimension(50, 40));
        // add action
        AddFavoriteActionListener action = new AddFavoriteActionListener(cocktail);
        button.addActionListener(action);
        // panel for the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(button, BorderLayout.EAST);
        // hover to see this string
        setToolTipText("Click to see details");
    }
}