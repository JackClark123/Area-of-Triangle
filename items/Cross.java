package items;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Cross {

	private final String wallImage = "Images/hayPile.png";
	private int posX, posY, size, spacing;
	private ImageIcon img;
	
	/**
	 * Goal Constructor
	 * @param posX Goal X position
	 * @param posY Goal Y position
	 * @param size Goal size
	 * @param spacing Goal image spacing
	 */
	public Cross(int posX, int posY, int size, int spacing) {
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		this.spacing = spacing;
		img = new ImageIcon(wallImage);
	}

	//Prints goal image
	public void print(Graphics g) {
		Image cross = img.getImage();
		g.drawImage(cross, posX * spacing + size/4, posY * spacing + size/4, size/2, size/2, null);
	}
	
	/**
	 * Sets goal position
	 * @param posX Goal X position
	 * @param posY Goal Y position
	 */
	public void setPosition(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	/**
	 * Gets Goal X position
	 * @return Goal X position
	 */
	public int getX() {
		return posX;
	}
	
	/**
	 * Gets Goal Y position
	 * @return Goal Y position
	 */
	public int getY() {
		return posY;
	}
}
