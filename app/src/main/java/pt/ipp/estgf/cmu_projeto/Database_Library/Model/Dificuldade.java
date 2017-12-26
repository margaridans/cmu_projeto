package pt.ipp.estgf.cmu_projeto.Database_Library.Model;

/**
 * Created by Bernardino on 26/12/2017.
 */

public class Dificuldade {
    public static String NAME_TABLE="tblDificuldade";
    private int id_dificuldade;
    private String dificuldade_name;

    public Dificuldade(int id_dificuldade, String dificuldade_name) {
        this.id_dificuldade = id_dificuldade;
        this.dificuldade_name = dificuldade_name;
    }

    public Dificuldade(String dificuldade_name) {
        this.dificuldade_name = dificuldade_name;
    }

    public int getId_dificuldade() {
        return id_dificuldade;
    }

    public void setId_dificuldade(int id_dificuldade) {
        this.id_dificuldade = id_dificuldade;
    }

    public String getDificuldade_name() {
        return dificuldade_name;
    }

    public void setDificuldade_name(String dificuldade_name) {
        this.dificuldade_name = dificuldade_name;
    }
}
