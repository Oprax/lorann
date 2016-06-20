package contract;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

	/**
	 * Start the main gameloop.
	 */
	void start();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	void orderPerform(ControllerOrder controllerOrder);

	/**
	 * @return tileMap
	 */
	IElement[][] getTileMap();

	/**
	 * @return Score
	 */
	int getScore();

	/**
	 * @return Hero
	 */
	IHero getHero();

	/**
	 * @return FireBall
	 */
	IFireball getFireBall();

	/**
	 * @return Level
	 */
	int getLevel();

    /**
     * @param tilemap String representing map with binding of letter with Element
     * @return 2-dimensional array representing game (map + mobile)
     */
    IElement[][] parser(String tilemap);
}
