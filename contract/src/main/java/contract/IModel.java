package contract;


import java.awt.*;
import java.util.Hashtable;
import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the observable.
	 * @return the observable
	 */
	Observable getObservable();



	/**
	 * Gets the map content.
	 * Load the text file of the map needed as it appear in the DataBase
	 * @return the content
     * @author Dorian
	 */
	String getMap();

	/**
	 * Load the map using the key in the table map of the database
	 * @param key
	 * @author Dorian
	 */
	void loadMap(String key);

	/**
	 * @param c
	 * @param pos
	 * Use the parser to locate, on the map, the position for the mobile elements, and the door, in order to make them move when needed
	 * @return
	 */
	IElement element(char c, Point pos);

    /**
     * Get the Highscore from the DB made by the five best users. Use a SQL routine
     * @return an array, in the first column the nickname, and the second the highscore
     * @author Dorian
     */
    String[][] getHighScore();

    /**
     * @param score
     * @param nickname
     * At win or loose POPUP the actual score made is load in the DataBase
     * @author Dorian
     */
    void upNameAndScore(final int score, final String nickname);
}
