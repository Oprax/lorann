package contract;

import java.awt.Point;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

	/**
	 * Start the main gameloop.
     * @author Dorian
	 */
	void start();

	/**
	 * Order perform.
	 * @param controllerOrder
	 * Method use in every mobile object, and also when load map, to execute the predefined order contain in the ControllerOrder list
	 * @author Dorian
	 */
	void orderPerform(ControllerOrder controllerOrder);

	/**
     * Dynamically resize the window view according to the map size
	 * @return tileMap
     * @author Dorian
	 */
	IElement[][] getTileMap();

	/**
     * Get the score made at the end of the game (win or loose) for POPUP
	 * @return Score
     * @author Dorian
	 */
	int getScore();

    /**
     * @param direction
     * @param currentPos
     * @return
     */
    Point computeNextPos(MobileOrder direction, Point currentPos);

	/**
     * Get the level according to the number of the map played for the draw string at the bottom of the window
	 * @return Level
     * @author Dorian
	 */
	int getLevel();

    /**
     * @param tilemap String representing map with binding of letter with Element
     * @return 2-dimensional array representing game (map + mobile)
     * @author Romain
     */
    IElement[][] parser(String tilemap);

	String[][] getScores();
}
