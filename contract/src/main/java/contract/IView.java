package contract;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	/**
	 * @param controller
     * Initialize the controller
     * @author Dorian
	 */
	void setController(IController controller);

    /**
     * In the loop, refresh the view for animation, movement, and update made on the map
     * @author Dorian
     */
    void repaint();

    /**
     * @return height of the window
     */
    int getHeight();

    /**
     * @return width of the window
     */
    int getWidth();

    /**
     * text area for the user name at the beginning of the game
     * @return pseudo
     * @author Dorian
     */
    String getPseudo();

	/**
	 * @param message
     * POPUP to show a message like a println but not in the console
     * @author Dorian
	 */
	void printMessage(final String message);
}
