package items;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import States.GameState;
import States.Multiplayer;
import Window.PanelController;


public class Button extends JComponent implements MouseListener, MouseMotionListener{
	
	private static final long serialVersionUID = 1L;
	
	private ImageIcon img1, img2;
	private int posX, posY;
	private int cursorPosX, cursorPosY;
	private String nextState;
	private PanelController pc;
	private GameState gs;
	private Multiplayer mp;
	private boolean hovering = false;
	private boolean resume = false;

	/**
	 * Button Constructor for Main Menu
	 * @param image1 Default button Image
	 * @param image2 Highlighted button Image
	 * @param nextState Next state in game
	 * @param pc Panel Controller
	 */
	public Button(String image1, String image2, String nextState, PanelController pc) {
		this.pc = pc;
		img1 = new ImageIcon(image1);
		img2 = new ImageIcon(image2);
		this.nextState = nextState;
		this.addMouseListener(this);
		this.addMouseListener(this);
	}
	
	/**
	 * Button Constructor for Difficulty Menu
	 * @param image1 Default button image
	 * @param image2 Highlighted button image
	 * @param nextState Next state in game
	 * @param pc Panel Controller
	 * @param gs Current game state
	 */
	public Button(String image1, String image2, String nextState, PanelController pc, GameState gs) {
		this.pc = pc;
		this.gs = gs;
		img1 = new ImageIcon(image1);
		img2 = new ImageIcon(image2);
		this.nextState = nextState;
		this.addMouseListener(this);
		this.addMouseListener(this);
	}
	
	/**
	 * Button Constructor for multiplayer
	 * @param image1 Default button image
	 * @param image2 Highlighted button image
	 * @param nextState next state
	 * @param pc Panel controller
	 * @param gs Current game state
	 * @param mp Multiplayer flag
	 */
	public Button(String image1, String image2, String nextState, PanelController pc, GameState gs, Multiplayer mp) {
		this.mp = mp;
		this.pc = pc;
		this.gs = gs;
		img1 = new ImageIcon(image1);
		img2 = new ImageIcon(image2);
		this.nextState = nextState;
		this.addMouseListener(this);
		this.addMouseListener(this);
	}
	
	/**
	 * Button Constructor for resuming game
	 * @param image1 Default button image
	 * @param image2 Highlighted button image
	 * @param nextState Next State
	 * @param pc Panel Controller
	 * @param resume Checks whether game is resumed (TRUE/FALSE)
	 */
	public Button(String image1, String image2, String nextState, PanelController pc, boolean resume) {
		this.resume = resume;
		this.pc = pc;
		img1 = new ImageIcon(image1);
		img2 = new ImageIcon(image2);
		this.nextState = nextState;
		this.addMouseListener(this);
		this.addMouseListener(this);
	}
	
	
	
	/**
	 * Sets button positions
	 * @param posX Button X position
	 * @param posY Button Y position
	 */
	public void setPosition(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	/**
	 * Checks if cursor is on a button
	 * @return true if cursor is on button. false otherwise
	 */
	private boolean isCollision() {
		if (cursorPosX >= posX && cursorPosX <= posX + img1.getIconWidth() && cursorPosY >= posY && cursorPosY <= posY + img1.getIconHeight()) {
			return true;
		} 
		return false;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		if (isCollision()) {
			if (hovering == false) {
				hovering = true;
			}
			Image button = img1.getImage();
			g.drawImage(button, posX, posY, img1.getIconWidth(), img1.getIconHeight(), null);
		} else {
			hovering = false;
			Image button = img2.getImage();
			g.drawImage(button, posX, posY, img2.getIconWidth(), img2.getIconHeight(), null);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (isCollision()) {
			
			if (nextState.equals("restart")) {
				gs.restartMap();
			}else if (nextState.equals("undo")){
				gs.undo();
			} else if (nextState.equals("play")) {
				mp.generateMaps();
			} else {
				if (nextState.equals("diffselect") && gs != null) {
					gs.restartMap();
				}
				pc.setCurrentDifficulty(nextState);
				
				if (resume == false) {
					pc.setPanel(nextState);
				} else {
					pc.setPanelResume(nextState);
				}
				
			}
		}
		
	}

	/**
	 * Gets next state in game
	 * @return next state in game
	 */
	public String getNextState() {
		return nextState;
	}

	/**
	 * Sets next state in game
	 * @param nextState State to set as next state
	 */
	public void setNextState(String nextState) {
		this.nextState = nextState;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		cursorPosX = e.getX();
		cursorPosY = e.getY();
	}
}
