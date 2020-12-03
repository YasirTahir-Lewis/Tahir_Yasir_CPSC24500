import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/**
 * This class basically paints the tiles, their shapes and colors on the window
 * We also checks which tile is been clicked by the user and change it's color and shape randomly
 */
public class TilePanel extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Tile> tiles;
	private Random rnd;
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
		int whichTile = e.getX()/(this.getWidth()/4);
		Tile tile = tiles.get(whichTile);
		tile.setRandomly(rnd);
		repaint();
	}
	
/**
 * 	This is a constructor which sets the tiles shape and color randomly
 */
	public TilePanel() {
		tiles = new ArrayList<Tile>();
		Tile tile;
		rnd = new Random();
		for (int i = 0; i < 4; i++) {
			tile = new Tile();
			tile.setRandomly(rnd);
			tiles.add(tile);
		}
		addMouseListener(this);
	}
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
	
/**
 * 	This is the most important function it displays the tiles after changes are made every time
 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int cellWidth = this.getWidth() / 4;
		int tileSize = 4*cellWidth/5;
		int shape;
		Color color;
		Tile tile;
		for (int i = 0; i < tiles.size(); i++) {
			tile = tiles.get(i);
			shape = tile.getShape();
			color = tile.getActualColor();
			g.setColor(color);
			if (shape == 0) {
				g.fillOval(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize); 
			} else if (shape == 1) {
				g.fillRect(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize);
			} 
		}
	}
}
