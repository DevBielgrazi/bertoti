package fwc.album;

public class Pais {

    private String qtd;
    private String sigla;

    public String getQtd() {return qtd;}

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Pais(){}

    public Pais(String sigla, String qtd){
        this.sigla=sigla;
        this.qtd=qtd;
    }
}
