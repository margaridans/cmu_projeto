package pt.ipp.estgf.cmu_projeto.Database_Library.Model;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

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


    public boolean addNivel(SQLiteDatabase db) {
        try {
            db.execSQL("INSERT INTO " + NAME_TABLE + "(" + NIVEL + ")VALUES ('" + nivel + "');");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean deleteNivel(SQLiteDatabase db) {
        try {
            db.execSQL("DELETE FROM " + NAME_TABLE + "WHERE " + ID_NIVEL + "=" + id_nivel + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean updateNivel(SQLiteDatabase db) {
        try {
            db.execSQL("UPDATE " + NAME_TABLE + "SET " + NIVEL  + " = '" + nivel + "' WHERE " + ID_NIVEL + "=" + id_nivel + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public static Nivel getNivelById(SQLiteDatabase db, int id_nivel) {
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + NAME_TABLE + "WHERE " + ID_NIVEL + "=" + id_nivel + ";", null);
            Nivel nivel = null;

            //se o cursor não estiver vazio e se estiver na primeira linha
            if (c != null && c.moveToFirst()) {
                nivel = new Nivel(c.getInt(0), c.getInt(1));
            }
            return nivel;

        } catch (SQLException ex) {
            db.close();
            return null;
        }
    }
}
