package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

import java.util.Hashtable;

// TODO: Auto-generated Javadoc
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

	/*
	 *
	 * 
	 * @see contract.IController#start()
	 */
	public void start() {
		this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
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


    public String[][] parser(String tilemap)
	{
		String[] lines = tilemap.split("\n");
        int x = lines.length;
        int y = lines[0].length();
        String[][] map = new String[x][y];

        Hashtable<Character, String> assocSprite = this.view.getAssocSprite();

        for(int i = 0; i < x; i++)
        {
            for(int j = 0; j < y; j++)
            {
                map[i][j] = assocSprite.get(lines[i].charAt(j));
            }
        }

        return map;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case English:
				this.model.loadMessage("GB");
				break;
			case Francais:
				this.model.loadMessage("FR");
				break;
			case Deutsch:
				this.model.loadMessage("DE");
				break;
			case Indonesia:
				this.model.loadMessage("ID");
				break;

			default:
				break;
		}
	}

}
