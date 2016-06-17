package model;

import java.sql.*;

/**
 * The Class DAOLoadMap.
 *
 * @author Cyril SNIADACH
 */
class DAOGetHighscore extends DAOEntityScore<GetHighscore> {

    /**
     * Instantiates a new DAO Load Map.
     *
     * @param connection
     *          the connection
     * @throws SQLException
     *           the SQL exception
     */
    public DAOGetHighscore(final Connection connection) throws SQLException {
        super(connection);
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#create(model.Entity)
     */
    @Override
    public boolean create(final GetHighscore entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#delete(model.Entity)
     */
    @Override
    public boolean delete(final GetHighscore entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#update(model.Entity)
     */
    @Override
    public boolean update(final GetHighscore entity) {
        // Not implemented
        return false;
    }

    public void upNameAndScore(final int score, final String nickname)
    {

    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#find()
     */
    public String[][] getHighScore() {
        GetHighscore highscore = new GetHighscore();
        String[][] stringHighScore = null;

        try {
            final String sql = "{call Show5BestUsers()}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                highscore = new GetHighscore();
            }
            Array   tmp;
            tmp = call.getArray("score");
            stringHighScore[1] = (String[])tmp.getArray();
            tmp = call.getArray("nickname");
            stringHighScore[0] = (String[])tmp.getArray();
            return stringHighScore;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}