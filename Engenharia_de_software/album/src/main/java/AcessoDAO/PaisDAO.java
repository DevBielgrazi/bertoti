package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import fwc.album.Pais;
import fwc.album.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PaisDAO {
    public static ObservableList<Pais> Datapais(){

        Connection conn = null;
        ResultSet rset = null;

        ObservableList<Pais> list = FXCollections.observableArrayList();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT pais, count(*) as qtd FROM sticker_album where album = ? GROUP BY pais;");
            ps.setString(1, Usuario.getCodigo());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add((new Pais(rs.getString("pais"), rs.getString("qtd"))));
            }
        }catch (Exception e){

            e.printStackTrace();

        }

        return list;

    }
}
