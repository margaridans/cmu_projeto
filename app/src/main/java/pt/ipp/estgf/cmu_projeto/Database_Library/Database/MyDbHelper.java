package pt.ipp.estgf.cmu_projeto.Database_Library.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bernardino on 26/12/2017.
 */

public class MyDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "KidsZone";
    private static final int DATABASE_VERSION = 1;

    public MyDbHelper(Context context1, String databaseName, Context context, int databaseVersion) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tblPergunta (id_pergunta INTEGER PRIMARY KEY, pergunta_name VARCHAR(100) NOT NULL,resposta1 VARCHAR(50)NOT NULL, resposta2 VARCHAR(50)NOT NULL," +
                " resposta3 VARCHAR(50)NOT NULL, resposta4 VARCHAR(50)NOT NULL, resposta_certa VARCHAR(50)NOT NULL, id_categoria INTEGER REFERENCES tblCategoria,  " +
                " id_dificuldade INTEGER REFERENCES tblDificuldade)");
        db.execSQL("CREATE TABLE tblCategoria (id_categoria INTEGER PRIMARY KEY AUTOINCREMENT, categoria_name VARCHAR (25)NOT NULL)");
        db.execSQL("CREATE TABLE tblDificuldade (id_dificuldade INTEGER PRIMARY KEY, dificuldade_name VARCHAR (25)NOT NULL)");
        db.execSQL("CREATE TABLE tblDicas (id_dica INTEGER PRIMARY KEY, dica_name VARCHAR (150)NOT NULL)");
        db.execSQL("CREATE TABLE tblPontuacao (id_pontuacao INTEGER PRIMARY KEY, pontuacao INTEGER, nome_user INTEGER REFERENCES tblUser)");
        db.execSQL("CREATE TABLE tblUser (id_user INTEGER PRIMARY KEY, nome_user VARCHAR (20) NOT NULL, pass_user VARCHAR (25)NOT NULL)");
    }

    public void createQuestions(SQLiteDatabase db) {

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE tblPergunta");
        this.onCreate(db);
    }
}
