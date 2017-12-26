package pt.ipp.estgf.cmu_projeto.Database_Library.Model;

/**
 * Created by Bernardino on 26/12/2017.
 */

public class Nivel {
    public static String NAME_TABLE = "tblNivel", ID_NIVEL="id_nivel", NIVEL="nivel";
    private int id_nivel;
    private int nivel;

    public Nivel(int id_nivel, int nivel) {
        this.id_nivel = id_nivel;
        this.nivel = nivel;
    }

    public Nivel(int nivel) {
        this.nivel = nivel;
    }

    public int getId_nivel() {
        return id_nivel;
    }

    public void setId_nivel(int id_nivel) {
        this.id_nivel = id_nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
