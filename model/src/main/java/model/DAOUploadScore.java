package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class DAOLoadMap.
 *
 * @author Quentin Strinati
 */
class DAOUploadScore extends DAOEntityScore<UploadScore> {

    /**
     * Instantiates a new DAO Upload Score.
     *
     * @param connection
     *          the connection
     * @throws SQLException
     *           the SQL exception
     */
    public DAOUploadScore(final Connection connection) throws SQLException {
        super(connection);
    }

    /**
     *
     *
     * @see model.DAOEntityScore#update(model.EntityScore)
     */
    @Override
    public boolean update(final UploadScore entity) {
        // Not implemented
        return false;
    }
    /**
     *
     *
     * @see model.DAOEntityScore#getHighScore()
     */
    public String[][] getHighScore()
    {
        return null;
    }

    /**
     *
     *
     * @see model.DAOEntityScore#upNameAndScore(int, String)
     */
    public void upNameAndScore(final int score, final String nickname) {
        //UploadScore uploadScore = new UploadScore(nickname, score);

        try {
            final String sql = "{call AddShowScore(?, ?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setInt(1, score);
            call.setString(2, nickname);
            final int row = call.executeUpdate();
            if (row > 0)
                System.out.println("The score was uploaded to the db");
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}