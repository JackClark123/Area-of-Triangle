package items;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Wall {
	
	private final String wallImage = "Images/crate.png";
	private int posX, posY, size, spacing;
	private ImageIcon img;
	
	/**
	 * Wall Constructor
	 * @param posX Wall X Position
	 * @param posY Wall Y Position
	 * @param size Wall image size
	 * @param spacing Wall image spacing
	 */
	public Wall(int posX, int posY, int size , int spacing) {
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		this.spacing = spacing;
		img = new ImageIcon(wallImage);
	}

	//Creates Wall image
	public void print(Graphics g) {
		Image wall = img.getImage();
		g.drawImage(wall, posX * spacing, posY * spacing, size, size, null);
	}
	
	/**
	 * Sets Wall position
	 * @param posX Wall X position
	 * @param posY Wall Y Position
	 */
	public void setPosition(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	/**
	 * Get Wall X Position
	 * @return Wall X position
	 */
	public int getX() {
		return posX;
	}
	
	/**
	 * Get Wall Y Position
	 * @return Wall Y Position
	 */
	public int getY() {
		return posY;
	}
}
