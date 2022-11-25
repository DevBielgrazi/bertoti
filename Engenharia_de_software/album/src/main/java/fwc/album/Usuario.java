package fwc.album;

public class Usuario {
    public static String nome;
    public static String codigo;

    public Usuario(){}

    public Usuario(String nome, String codigo){
        this.nome=nome;
        this.codigo=codigo;
    }

    public static String senha;
    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Usuario.nome = nome;
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        Usuario.codigo = codigo;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        Usuario.senha = senha;
    }
}
