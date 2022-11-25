package AcessoDAO;

import ConnectionFA.ConnectionFactory;
import fwc.album.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public boolean checklogin(String email, String senha){

        String sql = "Select codigo_album, senha from usuario where codigo_album = ? and senha = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean check = false;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, email);
            pstm.setString(2,senha);
            rs = pstm.executeQuery();

            if (rs.next()){
                check = true;
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm!=null){
                    pstm.close();
                }

                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return check;
    }

    public void saveusu(Usuario usuario){
        String sql = "INSERT INTO usuario (nome, codigo_album, senha) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getCodigo());
            pstm.setString(3, usuario.getSenha());
            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm!=null){
                    pstm.close();
                }

                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<Usuario> Usu(String codigo)

    {
        String sql = "Select * from usuario where codigo_album = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        List<Usuario> usulist = new ArrayList<Usuario>();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, codigo);
            //objeto para ler os dados do banco
            rset = pstm.executeQuery();


            // laço para percorrer o objeto de acesso ao dados do banco
            while (rset.next()) {

                Usuario usuario = new Usuario();
                usuario.setNome(rset.getString("nome"));
                usuario.setCodigo(rset.getString("codigo_album"));

                usulist.add(usuario);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return usulist;

    }
}
