package model;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Observable;

import contract.IElement;
import contract.IModel;
import model.mobile.*;
import model.motionless.*;

/**
 * The Class Model.
 */
public class Model extends Observable implements IModel {

	/** The message. */
	private String message;

	/** The map */
	private String map;

	/** Array of every elements in the map */
	public Element[][] elements;



	/**
	 * Return Hashtable<Character, String> of associate sprite
	 * @return assocSprite
	 */
	public Hashtable<Character, IElement> getAssocSprite() {
		return assocSprite;
	}

	/**
	 * Array have letter in key and the sprite's name in value
	 */
	private Hashtable<Character, IElement> assocSprite = new Hashtable<Character, IElement>();

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.fillAssoc();
        this.map = "B V H P L\n" +
				"1 2 3 4  \n" +
				"C O      ";
	}

	/**
	 * Associate all sprite with a letter representing hin in tileMap
	 */
	private void fillAssoc() {
		this.assocSprite.put('B', new Bone());
		this.assocSprite.put('K', new CrystalBall());
		this.assocSprite.put('H', new HorizontalBone());
		this.assocSprite.put('V', new VerticalBone());
		this.assocSprite.put('C', new ClosedDoor());
		this.assocSprite.put('O', new OpenDoor());
		this.assocSprite.put('P', new Purse());
		this.assocSprite.put('L', new Heroe());
		this.assocSprite.put('1', new Monster1());
		this.assocSprite.put('2', new Monster2());
		this.assocSprite.put('3', new Monster3());
		this.assocSprite.put('4', new Monster4());
		this.assocSprite.put(' ', new Empty());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}


	/** i added the map functions in general here*/

	public String getMap() {
		return this.map;
	}
	private void setMap(final String map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}
	public void loadMap(String key) {
		try {
			final DAOLoadMap daoLoadMap = new DAOLoadMap(DBConnection.getInstance().getConnection());
			this.setMap(daoLoadMap.find(key).getMap());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
}
