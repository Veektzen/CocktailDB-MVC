package com.view;

import com.controller.DeleteFavoriteActionListener;
import com.controller.DetailsListener;
import com.controller.MyComboBoxRenderer;
import com.controller.SetEnumActionListener;
import com.model.dao.Cocktail;
import com.model.repository.FavouriteType;
import com.model.singleton.Singleton;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.Border;
//import com.controller.DeleteFavouriteActionListener;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;


@SuppressWarnings("serial")
public class CocktailDisplayFavorite extends JPanel {
private Cocktail favorite;


	public CocktailDisplayFavorite(Cocktail favorite) {
		this.favorite=favorite;
		display(favorite);
	}

	public void display(Cocktail favorite) {

		setLayout(new BorderLayout());
		// image of cocktail
		try {
			Singleton instance = Singleton.getInstance();
			URL url = new URL(favorite.getImg());
			BufferedImage c = ImageIO.read(url);
			ImageIcon imageIcon = new ImageIcon(c); // load the image to a imageIcon
			Image image = imageIcon.getImage(); // transform it
			Image newimg = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // scale
			imageIcon = new ImageIcon(newimg); // transform it back
			JLabel iconLabel = new JLabel(favorite.getName(), imageIcon, JLabel.CENTER);
			// set font in label
			iconLabel.setFont(new Font("Sans-serif", Font.BOLD, 16));
			// give position to the icon in horizontal and vertical axis
			// by changing text position
			iconLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			iconLabel.setVerticalTextPosition(SwingConstants.TOP);
			// add label to panel
			add(iconLabel, BorderLayout.CENTER);
			//mouse listener for details
			DetailsListener detailsListener = new DetailsListener(favorite.getId());
			iconLabel.addMouseListener(detailsListener);

		} catch (MalformedURLException e) {
			System.out.println("MalformedURL Exception in Class CocktailDisplayFavourite");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception in Class CocktailDisplayFavourite");
			e.printStackTrace();
		}
		//
		// add to favorites button
		JButton button = new JButton();
		button.setFocusable(false);
		// add image icon to the button
		ImageIcon favouriteIcon = new ImageIcon("assets/images/deleteFavorite.png");
		button.setIcon(favouriteIcon);
		// add tool tip to the button when hover
		button.setToolTipText("Click to add to favorites list");
		// set margin for button
		button.setMargin(new Insets(10, 10, 10, 10));
		// set the preferred size of button by pixels
		button.setPreferredSize(new Dimension(50, 40));
		// set button color
		button.setBackground(Color.WHITE);
		// delete action
		DeleteFavoriteActionListener action = new DeleteFavoriteActionListener(favorite,this);
		button.addActionListener(action);

		JPanel southPanel = new JPanel(new BorderLayout());
		// add the button to the south of border layout
		southPanel.add(button, BorderLayout.EAST);

		JComboBox<String> comboBox = new JComboBox(FavouriteType.values());
		comboBox.setOpaque(false);
		comboBox.setRenderer(new MyComboBoxRenderer(favorite.getCategory()));
		comboBox.setSelectedIndex(-1);
		SetEnumActionListener enumAction = new SetEnumActionListener(favorite,comboBox);
		comboBox.addActionListener(enumAction);

		southPanel.add(comboBox,BorderLayout.WEST);

		add(southPanel,BorderLayout.SOUTH);

	}
}