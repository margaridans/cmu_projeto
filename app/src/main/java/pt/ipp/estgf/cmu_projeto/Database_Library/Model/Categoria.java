package pt.ipp.estgf.cmu_projeto.Database_Library.Model;

/**
 * Created by Bernardino on 26/12/2017.
 */

public class Categoria {
    public static String NAME_TABLE = "tblCategoria";
    private int id_categoria;
    private String nome;

    public Categoria(int id_categoria, String nome) {
        this.id_categoria = id_categoria;
        this.nome = nome;
    }

    public Categoria(String nome) {
        //id_categoria=-1;
        this.nome = nome;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
