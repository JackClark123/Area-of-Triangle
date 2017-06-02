package items;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

public class TextBox extends JComponent implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	private String text = "Enter number";
	private int posX, posY;
	
	private boolean empty = true;

	/**
	 * Constructor handles Text Box position
	 * @param posX Text X position
	 * @param posY Text Y position
	 */
	public TextBox(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	//Text graphics. Font: Times New Roman. Size: 18
	public void paint(Graphics g) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 18)); 
		if (empty) {
			g.drawString(text, posX, posY);
			g.drawString("of boxes", posX + 12, posY + 30);
		} else {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
			g.drawString(text, posX + 35 - 4 * text.length(), posY + 30);
		}
	}
	
	/**
	 * Requests number of boxes to use in game. 
	 * In multiplayer mode, requests number of boxes to use in game
	 * @return Number of boxes. Default is 0
	 */
	public int getNum() {
		if (!text.equals("Enter number")) {
			return Integer.parseInt(text);
		}
		return 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		
		if (Character.isDigit(key)) {
			if (empty == true) {
				text = "";
			}
			text += key;
			empty = false;
		}
		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DELETE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if(text.length() != 0) {
				text = text.substring(0, text.length() - 1);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
