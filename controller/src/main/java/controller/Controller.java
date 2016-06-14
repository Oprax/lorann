package controller;

import contract.*;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
	 * Entry point of Controller
	 * 
	 * @see contract.IController#start()
	 */
	public void start() {
        this.orderPerform(ControllerOrder.TEST);
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}


    /**
     * Parse tileMap to associate a Letter to a sprite
     *
     * @param tilemap TileMap in text format (with letter)
     * @see contract.IController#parser(String)
     */
    public IElement[][] parser(String tilemap) {
        String[] lines = tilemap.split("\n");
        int x = lines.length;
        int y = lines[0].length();
        IElement[][] map = new IElement[x][y];

        Hashtable<Character, IElement> assocSprite = this.model.getAssocSprite();

        for(IElement[] row: map)
            Arrays.fill(row, assocSprite.get(' '));


        for(int i = 0; i < x; i++)
        {
            for(int j = 0; j < y; j++)
            {
                char c = lines[i].charAt(j);
                IElement ele = assocSprite.get(c);
                if (ele != null) {
                    map[i][j] = ele;
                }
            }
        }

        return map;
	}

	/**
	 * @param controllerOrder Load map from model
     *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
            case MAP1:
				this.model.loadMap("MAP1");
				break;
            case MAP2:
				this.model.loadMap("MAP2");
				break;
            case MAP3:
				this.model.loadMap("MAP3");
				break;
            case MAP4:
				this.model.loadMap("MAP4");
				break;
            case MAP5:
                this.model.loadMap("MAP5");
                break;
            case MAP6:
                this.model.loadMap("MAP6");
                break;
            case MAP7:
                this.model.loadMap("MAP7");
                break;
            case MAP8:
                this.model.loadMap("MAP8");
                break;
            case MAP9:
                this.model.loadMap("MAP9");
                break;
			default:
                this.model.loadMap("TEST");
				break;
		}
	}

}
