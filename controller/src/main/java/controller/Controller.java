package controller;

import contract.*;

import java.awt.*;
import java.util.*;

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

    private int level = 1;

    private int score = 0;

    private Point posDoor = null;

    private HashMap<String, IMonster> monsters = new HashMap<String, IMonster>();

    private IFireball fireBall;

    private boolean dead = false;

    public IElement[][] getTileMap() {
        return tileMap;
    }

    public int getScore() {
        return score;
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

    private void printTileMap(IElement[][] tileMap) {
        System.out.println("[");
        for(int i =0; i < tileMap.length; i++) {
            System.out.print("    [");
            for(int j = 0; j < tileMap[0].length; j++) {
                System.out.print(tileMap[i][j].getClass().getSimpleName()
                        + ", ");
            }
            System.out.println("]");
        }
        System.out.println("]");
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

            if(this.dead) {
                System.out.println("DEAD");
            }

            for (Object o : this.monsters.entrySet()) {
                Map.Entry pair = (Map.Entry) o;
                IMonster monster = (IMonster) pair.getValue();
                this.moveMonster(monster);
            }

            this.view.repaint();

            try {
                Thread.sleep(300);
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

        this.monsters.clear();
        this.posDoor = null;

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
                    this.dead = false;
                    this.hero = (IHero) element;
                }
                if(c == '1' || c == '2' || c == '3' || c == '4') {
                    IMonster monster = (IMonster) element;
                    this.monsters.put(monster.getClass().getSimpleName(), monster);
                }
                if(c == 'C') {
                    this.posDoor = pos.getLocation();
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
                this.level = 1;
				break;
            case MAP2:
				this.model.loadMap("MAP2");
                this.level = 2;
				break;
            case MAP3:
				this.model.loadMap("MAP3");
                this.level = 3;
				break;
            case MAP4:
				this.model.loadMap("MAP4");
                this.level = 4;
				break;
            case MAP5:
                this.model.loadMap("MAP5");
                this.level = 5;
                break;
            case MAP6:
                this.model.loadMap("MAP6");
                this.level = 6;
                break;
            case MAP7:
                this.model.loadMap("MAP7");
                this.level = 7;
                break;
            case MAP8:
                this.model.loadMap("MAP8");
                this.level = 8;
                break;
            case MAP9:
                this.model.loadMap("MAP9");
                this.level = 9;
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

    private void fire() {
        if(this.fireBall != null)
            return;
        this.destroyFireBall();
        MobileOrder direction = this.hero.getDirection();
        Point currentPos = this.hero.getPos().getLocation();
        Point nextPos = this.computeNextPos(direction, currentPos);
        if(!currentPos.equals(nextPos)) {
            this.fireBall = (IFireball) this.model.element('F', nextPos);
            this.fireBall.setDirection(direction);
            this.swapFireBall(nextPos);
            this.view.repaint();
        }
    }
        /** Function checking if the hero is moving out of the map,
         * then checking if it collides with an object which permeability is false,
         * then applies the changes of position if the hero can move */
    private void moveHero(MobileOrder order) {
        Point pos = this.hero.getPos();
        this.hero.move(order, tileMap, this.view);
        this.tileMap[pos.x][pos.y] = model.element(' ', pos.getLocation());

        pos = this.hero.getPos();
        String elementName = this.tileMap[pos.x][pos.y].getClass().getSimpleName();
        if(elementName.contains("Monster")) {
            this.dead = true;
        } else if (elementName.contains("Crystal") && this.posDoor != null) {
            this.tileMap[this.posDoor.x][this.posDoor.y] = model.element('O', this.posDoor);
        } else if (elementName.contains("OpenDoor")) {
            this.level++;
            this.model.loadMap(String.format("MAP%d", this.level));
            return;
        }
        this.tileMap[pos.x][pos.y] = this.hero;
        this.view.repaint();
    }

    private void moveFireBall() {
        Point currentPos = this.fireBall.getPos().getLocation();
        MobileOrder direction = this.fireBall.getDirection();
        for (MobileOrder dir : MobileOrder.getValues()) {
            if(!dir.equals(direction)) {
                Point aroundPos = this.computeNextPos(dir, currentPos);
                IElement element = this.tileMap[aroundPos.x][aroundPos.y];
                String elementName = element.getClass().getSimpleName();
                if(elementName.contains("Monster")) {
                    this.tileMap[aroundPos.x][aroundPos.y] = model.element(' ', aroundPos);
                    this.monsters.remove(elementName);
                    this.destroyFireBall();
                    return;
                }
            }
        }
        this.fireBall.animate();
        Point nextPos = this.computeNextPos(this.fireBall.getDirection(), currentPos);

        this.swapFireBall(nextPos);

        this.tileMap[currentPos.x][currentPos.y] = model.element(' ', currentPos.getLocation());

        if(this.fireBall != null && this.fireBall.getStep() > 5) {
            this.destroyFireBall();
        }
    }

    private void swapFireBall(Point nextPos) {
        String nextElement = this.tileMap[nextPos.x][nextPos.y].getClass().getSimpleName();
        if(nextElement.contains("Monster")) {
            this.fireBall.setLocation(nextPos);
            this.tileMap[nextPos.x][nextPos.y] = this.fireBall;
            this.destroyFireBall();
            IMonster monster = this.monsters.get(nextElement);
            Point monsterPos = monster.getPos().getLocation();
            this.tileMap[monsterPos.x][monsterPos.y] = model.element(' ', monsterPos);
            System.out.println("Monster : " + this.monsters.remove(nextElement));
        } else if(nextElement.contains("Door") ||
                nextElement.contains("Purse") ||
                nextElement.contains("Crystal")) {
            this.fireBall = null;
        }
        else {
            this.fireBall.setLocation(nextPos);
            this.tileMap[nextPos.x][nextPos.y] = this.fireBall;
        }
    }

    private void moveMonster(IMonster monster) {
        Point pos = monster.getPos().getLocation();
        Point nextPos = this.computeNextPos(
                monster.getDirection(
                        this.hero.getPos().getLocation(),
                        this.tileMap),
                pos);
        if(nextPos != pos) {
            String element = tileMap[nextPos.x][nextPos.y].getClass()
                    .getSimpleName();
            if(element.contains("Hero")) {
                this.dead = true;
            } else if(!element.contains("Monster") &&
                    !element.contains("Purse") &&
                    !element.contains("Crystal") &&
                    !element.contains("Door")) {
                tileMap[pos.x][pos.y] = model.element(' ', pos.getLocation());
                monster.setLocation(nextPos);
                tileMap[nextPos.x][nextPos.y] = monster;
            }
        }
    }

    private Point computeNextPos(MobileOrder direction, Point currentPos) {
        Point nextPos = currentPos.getLocation();

        if(direction == null)
            return nextPos;

        switch (direction) {
            case Left:
                if(currentPos.y > 0 &&
                        tileMap[currentPos.x][currentPos.y - 1].getPermeability())
                {
                    nextPos = new Point(
                            currentPos.x,
                            currentPos.y - 1);
                }
                break;
            case Right:
                if(currentPos.y < (view.getWidth() / 32) - 1 &&
                        tileMap[currentPos.x][currentPos.y + 1].getPermeability())
                {
                    nextPos = new Point(
                            currentPos.x,
                            currentPos.y + 1);
                }
                break;
            case Up:
                if(currentPos.x > 0 &&
                        tileMap[currentPos.x - 1][currentPos.y].getPermeability()) {
                    nextPos = new Point(
                            currentPos.x - 1,
                            currentPos.y);
                }
                break;
            case Down:
                if(currentPos.x < (view.getHeight() / 32) - 1 &&
                        tileMap[currentPos.x + 1][currentPos.y].getPermeability()) {
                    nextPos = new Point(
                            currentPos.x + 1,
                            currentPos.y);
                }
                break;
        }
        return nextPos;
    }

    private void destroyFireBall() {
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
