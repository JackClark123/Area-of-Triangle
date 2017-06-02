package items;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Box {

	private final String wallImage = "Images/hayBale.png";
	private int posX, posY, size, spacing;
	private ImageIcon img;
	
	/**
	 * Box Constructor
	 * 
	 * @param posX Box X position
	 * @param posY Box Y Position
	 * @param size Box size
	 * @param spacing Box image spacing
	 */
	public Box(int posX, int posY, int size, int spacing) {
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		this.spacing = spacing;
		img = new ImageIcon(wallImage);
	}
	
	/**
	 * Changes box position
	 * @param deltaX X position to change
	 * @param deltaY Y position to change
	 */
	public void incrementPosition(int deltaX, int deltaY) {
		posX += deltaX;
		posY += deltaY;
	}

	//Draws box graphic
	public void print(Graphics g) {
		Image cross = img.getImage();
		g.drawImage(cross, posX * spacing, posY * spacing, size, size, null);
		img = new ImageIcon(wallImage);
	}
	
	/**
	 * Sets box positions
	 * @param posX Box X position
	 * @param posY Box Y position
	 */
	public void setPosition(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	/**
	 * Returns Box X position
	 * @return Box X position
	 */
	public int getX() {
		return posX;
	}
	
	/**
	 * Returns Box Y position
	 * @return Box Y position
	 */
	public int getY() {
		return posY;
	}
	

	/**
	 * Sets Box image
	 * @param image Box Image
	 */
	public void setImage(String image){
		img = new ImageIcon(image);
	}
}
