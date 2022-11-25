package fwc.album;

import AcessoDAO.AlbumDAO;
import AcessoDAO.PaisDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController3 implements Initializable {

    @FXML
    private Button botaoSair;

    @FXML
    private ChoiceBox<Integer> campoNumero;

    @FXML
    private ChoiceBox<String> campoPais;

    @FXML
    private TableColumn<Pais,String> colunaPais;
    @FXML
    private TableColumn<Pais,String> colunaQuantidade;

    @FXML
    private Label labelPorcentagem;

    @FXML
    private TableView<Pais> tabelaFigurinha;

    private Integer[] numeros = {1,2,3,4,5,6,7,8,9,10};

    private String[] paises = {"ARG","AUS","BEL","BRA","CAN","CMR","CRC","CRO","DEN","ECU","ENG","ESP","FRA","GER","GHA","IRN","JPN","KOR","KSA","MAR","MEX","NED","POL","POR","QAT","SEN","SRB","SUI","TUN","URU","USA","WAL"};


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        campoNumero.getItems().addAll(numeros);
        campoPais.getItems().addAll(paises);

        colunaPais.setCellValueFactory(new PropertyValueFactory<Pais,String>("Sigla"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<Pais,String>("Qtd"));

        ObservableList<Pais> ListaP = PaisDAO.Datapais();
        tabelaFigurinha.setItems(ListaP);

        AlbumDAO albumDAO = new AlbumDAO();
        double qtd = albumDAO.Dataqtd()/3.2;

        labelPorcentagem.setText("ALBUM "+qtd+"% COMPLETO");

    }

    @FXML
    void adicionarFigurinha(ActionEvent event) throws IOException {
        String pais = campoPais.getValue();
        Integer numero = campoNumero.getValue();
        if (pais == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O PAÍS!");
            alert.showAndWait();
        } else if (numero == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("PREENCHA O NÚMERO!");
            alert.showAndWait();
        } else{
            AlbumDAO albumDAO = new AlbumDAO();
            albumDAO.save(pais, numero);
            HelloApplication.ChangeScene("home");
        }
    }

    @FXML
    void sairLogin(ActionEvent event) throws IOException {
        HelloApplication.ChangeScene("login");
    }
}
