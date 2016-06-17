package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public EntityScore find() {
        GetHighscore highscore = new GetHighscore();

        try {
            final String sql = "{call Show5BestUsers()}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                highscore = new GetHighscore();
            }
            return highscore;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}