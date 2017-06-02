package items;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Player extends JComponent implements KeyListener,Cloneable{
	
	private static final long serialVersionUID = 1L;
	
	private final int UP = 1;
	private final int DOWN = 2;
	private final int RIGHT = 3;
	private final int LEFT = 4;
	
	private int playerState = 1;
	
	private int posX, posY, size, spacing;
	private int prevX, prevY;
	private ImageIcon up, down, left, right;
	
	private int moves = 0;
	private int playerNum;
	private boolean moving = false;
	
	/**
	 * Player constructor
	 * @param posX Player X position
	 * @param posY Player Y position
	 * @param size Player image size
	 * @param spacing Player image spacing
	 */
	public Player(int posX, int posY, int size, int spacing) {
		playerNum = 1;
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		this.spacing = spacing;
		this.addKeyListener(this);
		up = new ImageIcon("Images/playerFront.png");
		down = new ImageIcon("Images/playerBack.png");
		left = new ImageIcon("Images/playerLeft.png");
		right = new ImageIcon("Images/playerRight.png");
	}
	
	/**
	 * Handles Player in Multiplayer mode
	 * @param posX Player X Position
	 * @param posY Player Y Position
	 * @param size Player image size
	 * @param spacing Player image spacing
	 * @param playerNum Number of players (Max=2)
	 */
	public Player(int posX, int posY, int size, int spacing, int playerNum) {
		this.playerNum = playerNum;
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		this.spacing = spacing;
		this.addKeyListener(this);
		up = new ImageIcon("Images/playerFront.png");
		down = new ImageIcon("Images/playerBack.png");
		left = new ImageIcon("Images/playerLeft.png");
		right = new ImageIcon("Images/playerRight.png");
	}
	
	
	public Player clone(){
		Player o = null;
		try{
			o = (Player)super.clone();
		}catch(CloneNotSupportedException e){ 
			e.printStackTrace(); 
		} 
		return o;
	}
	
	//Generates player image depending on direction faced
	public void paintComponent(Graphics g) {	
		Image player = null;
		if (playerState == UP) {
			player = down.getImage();
		} else if (playerState == DOWN) {
			player = up.getImage();
		} else if (playerState == LEFT) {
			player = left.getImage();
		} else if (playerState == RIGHT) {
			player = right.getImage();
		}
		
		g.drawImage(player, posX * spacing, posY * spacing, size, size, null);
	}
	
	/**
	 * Sets player spacing
	 * @param spacing spacing value
	 */
	public void setSpacing(int spacing) {
		this.spacing = spacing;
	}

	/**
	 * Sets player position
	 * @param posX Player X position
	 * @param posY Player Y Position
	 */
	public void setPosition(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	/**
	 * Moves player from current position
	 * @param deltaX X position shift value
	 * @param deltaY Y position shift value
	 */
	public void incrementPosition(int deltaX, int deltaY) {
		posX += deltaX;
		posY += deltaY;
	}
	
	/**
	 * Gets number of moves
	 * @return number of moves
	 */
	public int getMoves() {
		return moves;
	}

	/**
	 * Sets initial move number. Set to 0 when map is reset
	 * @param moves number to set
	 */
	public void setMoves(int moves) {
		this.moves = moves;
	}
	
	/**
	 * Increases move number by 1
	 */
	public void incrementMoves() {
		if (moving) {
			moves++;
			moving = false;
		}
	}
	
	/**
	 * Decreases current move number by 1 until a minimum of 0
	 */
	public void decreaseMoves(){
		if(moves <= 0){
			return;
		}else{
			moves--;
		}
	}

	/**
	 * Gets player's previous X position
	 * @return Player previous X position 
	 */
	public int getPrevX() {
		return prevX;
	}

	/**
	 * Sets player's previous X position
	 * @param prevX Player previous X position
	 */
	public void setPrevX(int prevX) {
		this.prevX = prevX;
	}

	/**
	 * Gets player's previous Y position
	 * @return Player previous Y position 
	 */
	public int getPrevY() {
		return prevY;
	}

	/**
	 * Sets player's previous Y position
	 * @param prevY Player previous Y position
	 */
	public void setPrevY(int prevY) {
		this.prevY = prevY;
	}

	/**
	 * Get player's current X position
	 * @return Player current X position
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Set player's current X position
	 * @param posX Player current X position
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * Get player's current Y position
	 * @return Player current Y position
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Set player's current Y position
	 * @param posY player current Y position
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
			prevX = posX;
			prevY = posY;
			
			if (playerNum == 1) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					posY--;
					moving = true;
					playerState = UP;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					posY++;
					moving = true;
					playerState = DOWN;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					posX--;
					moving = true;
					playerState = LEFT;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					posX++;
					moving = true;
					playerState = RIGHT;
				}
			} 
			
			if (playerNum == 2) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					posY--;
					moving = true;
					playerState = UP;
				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					posY++;
					moving = true;
					playerState = DOWN;
				} else if (e.getKeyCode() == KeyEvent.VK_A) {
					posX--;
					moving = true;
					playerState = LEFT;
				} else if (e.getKeyCode() == KeyEvent.VK_D) {
					posX++;
					moving = true;
					playerState = RIGHT;
				}
			}   
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
