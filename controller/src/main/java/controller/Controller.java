package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

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
        this.orderPerform(ControllerOrder.Map1);
		//this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
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
    public String[][] parser(String tilemap) {
        String[] lines = tilemap.split("\n");
        int x = lines.length;
        int y = lines[0].length();
        String[][] map = new String[x][y];

        for(String[] row: map)
            Arrays.fill(row, "");

        Hashtable<Character, String> assocSprite = this.view.getAssocSprite();

        for(int i = 0; i < x; i++)
        {
            for(int j = 0; j < y; j++)
            {
                char c = lines[i].charAt(j);
                System.out.printf("FUCK : '%s'%n", c);
                String sprite = assocSprite.get(c);
                System.out.printf("DICK : '%s'%n", sprite);
                if (sprite != null) {
                    map[i][j] = sprite;
                }
            }
        }

        System.out.println(Arrays.deepToString(map));

        return map;
	}

	/**
	 * @param controllerOrder Load map from model
     *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
            case Map1:
				this.model.loadMap("MAP1");
				break;
            case Map2:
				this.model.loadMap("MAP2");
				break;
            case Map3:
				this.model.loadMap("MAP3");
				break;
            case Map4:
				this.model.loadMap("MAP4");
				break;
            case Map5:
                this.model.loadMap("MAP5");
                break;
            case Map6:
                this.model.loadMap("MAP6");
                break;
            case Map7:
                this.model.loadMap("MAP7");
                break;
            case Map8:
                this.model.loadMap("MAP8");
                break;
            case Map9:
                this.model.loadMap("MAP9");
                break;
			default:
                this.model.loadMap("TEST");
				break;
		}
	}

}
