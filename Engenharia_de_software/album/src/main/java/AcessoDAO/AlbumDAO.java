package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import fwc.album.Pais;
import fwc.album.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AlbumDAO {
    public void save(String pais, Integer numero){
        String sql = "INSERT INTO sticker_album (numero,pais,album) VALUES ( ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, numero);
            pstm.setString(2, pais);
            pstm.setString(3, Usuario.getCodigo());

            pstm.execute();

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("FIGURINHA REPETIDA!");
            alert.showAndWait();
        }
    }

    public static Integer Dataqtd(){

        Connection conn = null;
        ResultSet rset = null;

        Integer qtd=null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            PreparedStatement ps = conn.prepareStatement("select count(*) as qtd from sticker_album where album=?");
            ps.setString(1, Usuario.getCodigo());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getInt("qtd");
            }
        }catch (Exception e){

            e.printStackTrace();

        }
        return qtd;
    }
}
