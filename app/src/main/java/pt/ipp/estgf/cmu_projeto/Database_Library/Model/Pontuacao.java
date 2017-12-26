package pt.ipp.estgf.cmu_projeto.Database_Library.Model;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Bernardino on 26/12/2017.
 */

public class Pontuacao {
    public static String NAME_TABLE = "tblPontuacao", ID_PONT="id_pontuacao", ;
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


    public boolean addPontuacao(SQLiteDatabase db) {
        try {
            db.execSQL("INSERT INTO " + NAME_TABLE + "(" + NOME_DIFIC + ")VALUES ('" + dificuldade_name + "');");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean deletePontuacao(SQLiteDatabase db) {
        try {
            db.execSQL("DELETE FROM " + NAME_TABLE + "WHERE " + ID_DIFIC + "=" + id_dificuldade + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean updatePontuacao(SQLiteDatabase db) {
        try {
            db.execSQL("UPDATE " + NAME_TABLE + "SET " + NOME_DIFIC + " = '" + dificuldade_name + "' WHERE " + ID_DIFIC + "=" + id_dificuldade + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public static Pontuacao getPontuacaoById(SQLiteDatabase db, int id_dificuldade) {
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + NAME_TABLE + "WHERE " + ID_DIFIC + "=" + id_dificuldade + ";", null);
            Dificuldade dificuldade = null;

            //se o cursor não estiver vazio e se estiver na primeira linha
            if (c != null && c.moveToFirst()) {
                dificuldade = new Dificuldade(c.getInt(0), c.getString(1));
            }
            return dificuldade;

        } catch (SQLException ex) {
            db.close();
            return null;
        }
    }

}
