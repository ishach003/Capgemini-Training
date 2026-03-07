package batchproccessing.dao;

import batchproccessing.entity.Player;
import batchproccessing.respository.playerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOImpl implements PlayerDAO {
    @Override
    public void insertPlayer(List<Player> players) throws SQLException {
        Connection connection= playerRepository.getConnection();

        String insertQuery="INSERT INTO players VALUES(?,?,?)";
        PreparedStatement pstmt=connection.prepareStatement(insertQuery);

        for(Player p:players){
            pstmt.setInt(1,p.getPlayerId());
            pstmt.setString(2,p.getPlayerName());
            pstmt.setString(3,p.getPlayerCountry());
            pstmt.addBatch();
        }

        int[] result=pstmt.executeBatch();
        System.out.println("Inserted Rows: "+result.length);

        connection.close();
    }

    @Override
    public void updatePlayer(List<Player> players) throws SQLException{
        Connection connection=playerRepository.getConnection();

        String updateQuery="UPDATE players SET playerName=?,playerCountry=?Where playerID=?";
        PreparedStatement pstmt=connection.prepareStatement(updateQuery);
        for(Player p:players){
            pstmt.setString(1,p.getPlayerName());
            pstmt.setString(2,p.getPlayerCountry());
            pstmt.setInt(3,p.getPlayerId());
            pstmt.addBatch();
        }
        int[] result = pstmt.executeBatch();

        System.out.println("Updated sucessfully "+result.length);

        connection.close();
    }

    @Override
    public void deletePlayer(List<Integer> playerId) throws SQLException {
        Connection connection=playerRepository.getConnection();
        String deleteQuery="DELETE from players WHERE playerId=?";
        PreparedStatement pstmt= connection.prepareStatement(deleteQuery);
         for (Integer p:playerId ){
             pstmt.setInt(1,p);
             pstmt.addBatch();
         }
        int[] result = pstmt.executeBatch();

        System.out.println("Deleted sucessfully rows "+result.length);

        connection.close();
    }


    @Override
    public List<Player> fetchAll() throws SQLException {
        Connection conn=playerRepository.getConnection();
        List<Player> list=new ArrayList<>();
        String queue="SELECT * fROM players";
            PreparedStatement pst=conn.prepareStatement(queue);

            ResultSet rs=pst.executeQuery();

            while (rs.next()){
                int id=rs.getInt("playerID");
                String name=rs.getString("playerName");
                String country=rs.getString("playerCountry");
                Player player=new Player(id,name,country);

                list.add(player);}

        return list;
    }

}
