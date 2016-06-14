package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;

/**
 * The Class Model.
 */
public class Model extends Observable implements IModel {

	/** The message. */
	private String message;

	/** The map */
	private String map;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
        this.map = "B V H P L\n" +
				"1 2 3 4  \n" +
				"C O      ";
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
