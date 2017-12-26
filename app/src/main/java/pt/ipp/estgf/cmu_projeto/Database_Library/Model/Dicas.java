package pt.ipp.estgf.cmu_projeto.Database_Library.Model;

/**
 * Created by Bernardino on 26/12/2017.
 */

public class Dicas {

    public static String NAME_TABLE = "tblDicas";
    private int id_dica;
    private String dica_name;

    public Dicas(int id_dica, String dica_name) {
        this.id_dica = id_dica;
        this.dica_name = dica_name;
    }

    public Dicas(String dica_name) {
        this.dica_name = dica_name;
    }

    public int getId_dica() {
        return id_dica;
    }

    public void setId_dica(int id_dica) {
        this.id_dica = id_dica;
    }

    public String getDica_name() {
        return dica_name;
    }

    public void setDica_name(String dica_name) {
        this.dica_name = dica_name;
    }
}
