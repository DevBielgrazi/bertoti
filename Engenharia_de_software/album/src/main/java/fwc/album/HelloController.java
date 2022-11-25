package fwc.album;

import AcessoDAO.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoEntrar;

    @FXML
    private TextField campoCodigo;

    @FXML
    private PasswordField campoSenha;

    public static String emailrh;

    @FXML
    void cadastrarLogin(ActionEvent event) throws Exception {
        HelloApplication.ChangeScene("cadastro");
    }

    @FXML
    void entrarLogin(ActionEvent event) throws Exception{

        try {

            Usuario.setCodigo(campoCodigo.getText());


            //validação de campos em branco
            String senhaMd5 = Md5.getHashMd5(campoSenha.getText());

            if (campoCodigo.getText() == "" || campoSenha.getText() == ""){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("campo vazio !");
                alert.showAndWait();

            } else {

                // conexão com banco

                //busca candidato
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                if( usuarioDAO.checklogin(campoCodigo.getText(), senhaMd5)){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Bem Vindo!");
                    alert.showAndWait();
                    usuarioDAO.Usu(campoCodigo.getText());
                    HelloApplication.ChangeScene("home");

                } else{
                    // USUARIO NÃO ENCONTRADO
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Código ou Senha incorretos !");
                    alert.showAndWait();

                    }
                }

        }catch (Exception e){

            // USUARIO NÃO ENCONTRADO
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("FALHA NA CONEXÃO");
            alert.showAndWait();

        }


    }
}



