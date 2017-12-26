package pt.ipp.estgf.cmu_projeto.Database_Library.Model;

/**
 * Created by Bernardino on 26/12/2017.
 */

public class Pontuacao {
    public static String NAME_TABLE="tblPontuacao";
    private int id_pontuacao;
    private int pontuacao;
    private String nome_user;

    public Pontuacao(int id_pontuacao, int pontuacao, String nome_user) {
        this.id_pontuacao = id_pontuacao;
        this.pontuacao = pontuacao;
        this.nome_user = nome_user;
    }

    public Pontuacao(int pontuacao, String nome_user) {
        this.pontuacao = pontuacao;
        this.nome_user = nome_user;
    }

    public int getId_pontuacao() {
        return id_pontuacao;
    }

    public void setId_pontuacao(int id_pontuacao) {
        this.id_pontuacao = id_pontuacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getNome_user() {
        return nome_user;
    }

    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }
}
