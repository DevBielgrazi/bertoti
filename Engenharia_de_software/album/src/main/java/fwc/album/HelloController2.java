package fwc.album;

import AcessoDAO.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController2 {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField campoCodigo;

    @FXML
    private TextField campoNome;

    @FXML
    private PasswordField campoSenha;

    @FXML
    void Cadastrar(ActionEvent event) throws IOException{
        String nome = campoNome.getText();
        String codigo = campoCodigo.getText();
        String senha = campoSenha.getText();
        if (nome.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O NOME!");
            alert.showAndWait();
        } else if (codigo.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O CÓDIGO!");
            alert.showAndWait();
        } else if (senha.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA A SENHA!");
            alert.showAndWait();
        }else{
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setCodigo(codigo);
            String senhaMd5 = Md5.getHashMd5(senha);
            usuario.setSenha(senhaMd5);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.saveusu(usuario);
            HelloApplication.ChangeScene("home");
        }
    }

    @FXML
    void Voltar(ActionEvent event) throws IOException {
        HelloApplication.ChangeScene("login");
    }

}
