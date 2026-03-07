import batchproccessing.dao.PlayerDAO;
import batchproccessing.dao.PlayerDAOImpl;
import batchproccessing.entity.Player;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        PlayerDAO dao=new PlayerDAOImpl();

//        List<Player> players= Arrays.asList(
//                new Player(1,"virat","india"),
//                new Player(2,"Babar","Pakistan"),
//                new Player(3,"joe","england")
//        );
//        dao.insertPlayer(players);

//        List<Player> players= Arrays.asList(
//                new Player(1,"A","i"),
//                new Player(2,"B","P"),
//                new Player(3,"C","e")
//
//        );
//        dao.updatePlayer(players);
//        List<Integer> players= Arrays.asList(
//                1,2,3
//        );
//        dao.deletePlayer(players);

        List<Player> players=dao.fetchAll();

        for(Player p:players){
            System.out.println(p);
        }
    }
}
