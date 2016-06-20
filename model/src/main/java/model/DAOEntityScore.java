package model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The Class DAOEntityScore.
 *
 * @author Quentin Strinati
 *
 * @param <E>
 *          the element type
 */
abstract class DAOEntityScore<E extends EntityScore> {

    /** The connection. */
    private final Connection connection;

    /**
     * Instantiates a new DAO entity score.
     *
     * @param connection
     *          the connection
     * @throws SQLException
     *           the SQL exception
     */
    public DAOEntityScore(final Connection connection) throws SQLException {
        this.connection = connection;
    }

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    protected Connection getConnection() {
        return this.connection;
    }

    /**
     * Update.
     *
     * @param entityScore
     *          the entityScore
     * @return true, if successful
     */
    public abstract boolean update(E entityScore);

    /** Gets the high scores
     * @return a array of array of strings, the first column containing the nicknames et the second the scores
     */
    public abstract String[][] getHighScore();

    /** Uploads the nickname and the score
     * @param score contains the score
     * @param nickname contains the nickname
     */
    public abstract void upNameAndScore(final int score, final String nickname);
}
