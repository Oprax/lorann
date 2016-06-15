package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dorian on 15/06/2016.
 */
public class DAOScore extends DAOEntity<Score>{

    /**
     * Instantiates a new DAO entity.
     *
     * @param connection the connection
     * @throws SQLException the SQL exception
     */
    public DAOScore(Connection connection) throws SQLException {
        super(connection);
    }

    public boolean create(Score entity) {
        return false;
    }

    public boolean delete(Score entity) {
        return false;
    }

    public boolean update(Score entity) {
        return false;
    }

    public Entity find(int score_id) {
        return null;
    }

    public Score find(String key) {
        return null;
    }

    public void setscoreBDD() {
            Score score = new Score();

            try {
                final String setScoreBDD = "{call UpdateScore}";
                final CallableStatement call = this.getConnection().prepareCall(setscoreBDD());
                call.execute();
                final ResultSet resultSet = call.getResultSet();
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }


    public void setlastscore() {
            Score LastScore = new
        try {
            final String updateLastScore = "{call UpdateLastScore}";
            final CallableStatement call = this.getConnection().prepareCall(setlastscore());
            call.execute();
            final ResultSet resultSet = call.getResultSet();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
