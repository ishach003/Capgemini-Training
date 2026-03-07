package batchproccessing.dao;

import batchproccessing.entity.Player;

import java.sql.SQLException;
import java.util.List;

public interface PlayerDAO {
    void insertPlayer(List<Player> players) throws SQLException;

    void updatePlayer(List<Player> players) throws SQLException;

    void deletePlayer(List<Integer> playerId) throws SQLException;

    List<Player> fetchAll() throws SQLException;
}
