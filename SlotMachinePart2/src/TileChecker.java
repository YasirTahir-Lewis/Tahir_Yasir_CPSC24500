import java.util.ArrayList;

/**
 * This class checks the shape and color of each tile
 * Every time we click on Max, Mid, and Min buttons
 * It also checks if both color and shape matches or not
 *
 */
public class TileChecker {
	
/**
 * 	This function checks the color of each tile and compare it to each other
 *  And returns true if it does or false otherwise
 */
	public boolean colorChecker(ArrayList<Tile> tiles) {
		if (tiles.get(0).getColor()==tiles.get(1).getColor() && (tiles.get(1).getColor()==tiles.get(2).getColor()) && (tiles.get(2).getColor()==tiles.get(3).getColor())) {
			return true;
		} else {
			return false;
		}  
	}
	
/**
* 	This function checks the shape of each tile and compare it to each other
*   And returns true if it does or false otherwise
*/	
	public boolean shapeChecker(ArrayList<Tile> tiles) {
		if (tiles.get(0).getShape()==tiles.get(1).getShape() && (tiles.get(1).getShape()==tiles.get(2).getShape()) && (tiles.get(2).getShape()==tiles.get(3).getShape())) {
			return true;
		} else {
			return false;
		}  
	}

/**
* 	This function checks the color and shape of each tile and compare it to each other
*  	And returns true if it does or false otherwise
*/	
	public boolean matchChecker(ArrayList<Tile> tiles) {
		return (colorChecker(tiles) && shapeChecker(tiles));
	}
	
}
