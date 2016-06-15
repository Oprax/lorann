package controller;

import contract.*;

import java.awt.*;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

/**
 * The Class Controller.
 */
public class Controller implements IController, Observer {

	/** The view. */
	private IView view;

    private IElement[][] tileMap;

	/** The model. */
	private IModel model;

    private IHero hero;

    private IFireball fireBall;

    public IElement[][] getTileMap() {
        return tileMap;
    }

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
        this.tileMap = this.parser(this.model.getMap());
        this.hero = (IHero) model.element('L', new Point());
        model.getObservable().addObserver(this);
	}

	/**
	 * Entry point of Controller
	 * 
	 * @see contract.IController#start()
	 */
	public void start() {
        this.orderPerform(ControllerOrder.MENU);

        // Game Loop
        while (true) {
            if(this.fireBall != null) {
                this.moveFireBall();
            }

            this.view.repaint();

            try {
                Thread.sleep(250);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
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

        for(IElement[] row: map)
            Arrays.fill(row, this.model.element(' ', null));


        for(int i = 0; i < x; i++)
        {
            for(int j = 0; j < y; j++)
            {
                char c = lines[i].charAt(j);
				Point pos = new Point(i, j);

                IElement element = this.model.element(c, pos);
                if(c == 'L') {
                    this.hero = (IHero) element;
                }
                if (element != null) {
                    map[i][j] = element;
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
        if (controllerOrder == null)
            return;

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
            case MENU:
                this.model.loadMap("MENU");
                break;
            case WORKSHOP:
                this.model.loadMap("WORKSHOP");
                break;
            case MOVEDOWN:
                this.moveHero(MobileOrder.Down);
                break;
            case MOVEUP:
                this.moveHero(MobileOrder.Up);
                break;
            case MOVERIGHT:
                this.moveHero(MobileOrder.Right);
                break;
            case MOVELEFT:
                this.moveHero(MobileOrder.Left);
                break;
            case FIRE:
                this.fire();
                break;
			default:
                this.model.loadMap("TEST");
				break;
		}
	}

    public void fire() {
        this.destroyFireBall();
        MobileOrder direction = this.hero.getDirection();
        Point pos = this.hero.getPos().getLocation();
        boolean fireball = true;
        switch (direction) {
            case Left:
                if(pos.y > 0 &&
                        tileMap[pos.x][pos.y - 1].getPermeability())
                {
                    pos.setLocation(new Point(
                            pos.x,
                            pos.y - 1));
                } else {
                    fireball = false;
                }
                break;
            case Right:
                if(pos.y < view.getWidth() / 32 - 1 &&
                        tileMap[pos.x][pos.y + 1].getPermeability())
                {
                    pos.setLocation(new Point(
                            pos.x,
                            pos.y + 1));
                } else {
                    fireball = false;
                }
                break;
            case Up:
                if(pos.x > 0 &&
                        tileMap[pos.x - 1][pos.y].getPermeability()) {
                    pos.setLocation(new Point(
                            pos.x - 1,
                            pos.y));
                } else {
                    fireball = false;
                }
                break;
            case Down:
                if(pos.x < view.getHeight() / 32 - 1 &&
                        tileMap[pos.x + 1][pos.y].getPermeability()) {
                    pos.setLocation(new Point(
                            pos.x + 1,
                            pos.y));
                } else {
                    fireball = false;
                }
                break;
        }

        if(fireball) {
            this.fireBall = (IFireball) this.model.element('F', pos);
            this.fireBall.setDirection(direction);
            this.swapFireBall();
            this.view.repaint();
        }
    }
        /** Function checking if the hero is moving out of the map,
         * then checking if it collides with an object which permeability is false,
         * then applies the changes of position if the hero can move */
    public void moveHero(MobileOrder order) {
        Point pos = this.hero.getPos();
        this.hero.move(order, tileMap, this.view);
        this.tileMap[pos.x][pos.y] = model.element(' ', pos.getLocation());

        pos = this.hero.getPos();
        this.tileMap[pos.x][pos.y] = this.hero;
        this.view.repaint();
    }

    public void moveFireBall() {
        Point pos = this.fireBall.getPos().getLocation();
        this.fireBall.animate();
        System.out.printf("DICK '%s'%n", pos);
        switch (this.fireBall.getDirection()) {
            case Left:
                if(pos.y > 0 &&
                        tileMap[pos.x][pos.y - 1].getPermeability())
                {
                    this.fireBall.setLocation(new Point(
                            pos.x,
                            pos.y - 1));
                }
                break;
            case Right:
                if(pos.y < view.getWidth() / 32 - 1 &&
                        tileMap[pos.x][pos.y + 1].getPermeability())
                {
                    this.fireBall.setLocation(new Point(
                            pos.x,
                            pos.y + 1));
                }
                break;
            case Up:
                if(pos.x > 0 &&
                        tileMap[pos.x - 1][pos.y].getPermeability()) {
                    this.fireBall.setLocation(new Point(
                            pos.x - 1,
                            pos.y));
                }
                break;
            case Down:
                if(pos.x < view.getHeight() / 32 - 1 &&
                        tileMap[pos.x + 1][pos.y].getPermeability()) {
                    this.fireBall.setLocation(new Point(
                            pos.x + 1,
                            pos.y));
                }
                break;
        }
        System.out.printf("BUTT '%s'%n", pos);

        this.tileMap[pos.x][pos.y] = model.element(' ', pos.getLocation());

        this.swapFireBall();

        if(this.fireBall != null && this.fireBall.getStep() > 5) {
            this.destroyFireBall();
        }
    }

    public void swapFireBall() {
        Point pos = this.fireBall.getPos();
        String elementName = this.tileMap[pos.x][pos.y].getClass().getCanonicalName();
        if(elementName.contains("Monster")) {
            this.destroyFireBall();
        } else {
            this.tileMap[pos.x][pos.y] = this.fireBall;
        }
    }

    public void destroyFireBall() {
        if(this.fireBall != null) {
            Point pos = this.fireBall.getPos().getLocation();
            this.tileMap[pos.x][pos.y] = this.model.element(' ', pos);
            this.fireBall = null;
        }
    }

    public void update(Observable o, Object arg) {
        this.tileMap = parser(model.getMap());
        this.view.repaint();
    }
}
