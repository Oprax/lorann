package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dorian on 15/06/2016.
 */
public class DAOScore extends DAOEntity{


    /**
     * Instantiates a new DAO entity.
     *
     * @throws SQLException the SQL exception
     */
    public DAOScore() throws SQLException {
        super(connection())
    }

    /**
     * Instantiates a new DAO entity.
     *
     * @param connection the connection
     * @throws SQLException the SQL exception
     */
    public DAOScore(Connection connection) throws SQLException {
        super(connection);
    }

    public boolean create(Entity entity) {
        return false;
    }

    public boolean delete(Entity entity) {
        return false;
    }

    public boolean update(Entity entity) {
        return false;
    }

    public Entity find(int id) {
        return null;
    }

    public Entity find(String key) {
        return null;
    }

    public Scoreable scoreable() {
            Score updatescore = new Score();

            try {
                final String setScoreBDD = "{call UpdateScore}";
                final CallableStatement call = this.getConnection().prepareCall(setScoreBDD);
                call.execute();
                final ResultSet resultSet = call.getResultSet();
                if (resultSet.first()) {
                    Score = new Score(score_id, resultSet.getString("LastScore"), resultSet.getString("Score"));
                }
                return score;
            } catch (final SQLException e) {
                e.printStackTrace();
            }
            return null;
        }    }
}
