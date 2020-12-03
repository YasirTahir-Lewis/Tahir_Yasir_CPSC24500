import java.util.ArrayList;
import java.util.Random;

/**
 * This Class is for changing the shape and color of all tiles randomly at the same time
 * We used this class Restart button and
 * For Max, Mid, and Min buttons
 *
 */
public class TileRandomizer {
	
	public ArrayList<Tile> randomizedTiles() {
		ArrayList<Tile> randomTiles = new ArrayList<Tile>();
		for (int i=0; i<4; i++) {
			Tile t = new Tile();
			t.setRandomly(new Random());
			randomTiles.add(t);
		}
		return randomTiles;
	}
}