package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();



	/**
	 * Gets the map content.
	 *
	 * @return the content
	 */
	String getMap();

	/**
	 * Load the map.
	 *
	 * @param key
	 *          the key
	 */
	void loadMap(String key);
	void moveLeft();
	void moveRight();
	void moveDown();
	void moveUp();
}
