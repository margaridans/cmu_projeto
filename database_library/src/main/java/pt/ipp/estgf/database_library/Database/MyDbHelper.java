package pt.ipp.estgf.database_library.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pt.ipp.estgf.database_library.Model.Categoria;
import pt.ipp.estgf.database_library.Model.Dicas;
import pt.ipp.estgf.database_library.Model.Dificuldade;
import pt.ipp.estgf.database_library.Model.Pergunta;
import pt.ipp.estgf.database_library.Model.Pontuacao;
import pt.ipp.estgf.database_library.Model.User;


/**
 * Created by Bernardino on 26/12/2017.
 */

public class MyDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "KidsZone";
    private static final int DATABASE_VERSION = 10;


    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Pergunta.NAME_TABLE + "(" + Pergunta.ID_PERG + "INTEGER PRIMARY KEY, " + Pergunta.NOME_PERG + "VARCHAR (150) NOT NULL, " + Pergunta.RESP1 + "VARCHAR (50) NOT NULL, " +
                Pergunta.RESP2 + "VARCHAR (50) NOT NULL, " + Pergunta.RESP3 + "VARCHAR (50) NOT NULL, " + Pergunta.RESP4 + "VARCHAR (50) NOT NULL, " + Pergunta.RESP_CERTA + "VARCHAR (50) NOT NULL, " +
                Pergunta.ID_CAT + "INTEGER NOT NULL," + Pergunta.ID_DIFIC + "INTEGER NOT NULL);");
        db.execSQL("CREATE TABLE" + Categoria.NAME_TABLE + "(" + Categoria.ID_CAT + "INTEGER PRIMARY KEY, " + Categoria.NOME_CAT + "VARCHAR (25) NOT NULL);");
        db.execSQL("CREATE TABLE" + Dificuldade.NAME_TABLE + "(" + Dificuldade.ID_DIFIC + "INTEGER PRIMARY KEY, " + Dificuldade.NOME_DIFIC + "VARCHAR (25) NOT NULL, " +
                Dificuldade.PONTUACAO_PERG + "INTEGER);");
        db.execSQL("CREATE TABLE" + Dicas.NAME_TABLE + "(" + Dicas.ID_DICAS + "INTEGER PRIMARY KEY, " + Dicas.NOME_DICA + "VARCHAR (150) NOT NULL);");
        db.execSQL("CREATE TABLE" + Pontuacao.NAME_TABLE + "(" + Pontuacao.ID_PONT + "INTEGER PRIMARY KEY, " + Pontuacao.PONTUACAO + "VARCHAR (150)," + Pontuacao.USER + "VARCHAR (25));");
        db.execSQL("CREATE TABLE" + User.NAME_TABLE + "(" + User.ID_USER + "INTEGER PRIMARY KEY, " + User.USERNAME + "VARCHAR (25) NOT NULL," + User.PASS + "VARCHAR (25) NOT NULL);");

        createQuestions(db);
    }

    public void createQuestions(SQLiteDatabase db) {
        Categoria categoria_ingles = new Categoria(0, "Inglês");
        Categoria categoria_portugues = new Categoria(1, "Português");
        Categoria categoria_matematica = new Categoria(2, "Matemática");

        categoria_ingles.addCategoria(db);
        categoria_portugues.addCategoria(db);
        categoria_matematica.addCategoria(db);

        Dificuldade dificuldade_facil = new Dificuldade(0, "Fácil", 5);
        Dificuldade dificuldade_medio = new Dificuldade(1, "Médio", 10);
        Dificuldade dificuldade_dificil = new Dificuldade(2, "Díficil", 15);

        dificuldade_facil.addDificuldade(db);
        dificuldade_medio.addDificuldade(db);
        dificuldade_dificil.addDificuldade(db);


        Pergunta pergunta1 = new Pergunta(0, "Qual o plural de batata?", 0, 0, "Tomatos", "Potatos", "Apples", "Potatoes", "Potatoes");
        Pergunta pergunta2 = new Pergunta(1, "Qual palavra abaixo não é um verbo?", 0, 1, "Feeding", "Amazing", "Going", "Looking", "Amazing");
        Pergunta pergunta3 = new Pergunta(2, "Qual membro da família é do sexo masculino?", 0, 2, "Granddaughter", "Grandfather", "Daughter", "Stepmother", "Grandfather");
        Pergunta pergunta4 = new Pergunta(3, "Qual o contrário de algumas?", 1, 0, "muitas", "todas", "nenhuma", "poucas", "todas");
        Pergunta pergunta5 = new Pergunta(4, "Qual é o plural de guarda-chuva?", 1, 1, "guarda-chuva", "guarda-chuvas", "guardas-chuvas", "guardas-chuva", "guarda-chuvas");
        Pergunta pergunta6 = new Pergunta(5, "Qual a palavra que está mal escrita?", 1, 2, "mexer", "chícara", "enxergar", "caprichar", "chícara");
        Pergunta pergunta7 = new Pergunta(6, "Qual destas expressões corresponde ao número mais pequeno?", 2, 0, "2/5", "5/10", "3/2", "1/7", "1/7");
        Pergunta pergunta8 = new Pergunta(7, "Qual dos números completa a seguinte sequência: 2 3 6 18 ", 2, 1, "22", "32", "64", "108", "108");
        Pergunta pergunta9 = new Pergunta(8, "Qual é 6b-10+2b=06", 2, 2, "41", "02", "06", "10", "02");

        pergunta1.addPergunta(db);
        pergunta2.addPergunta(db);
        pergunta3.addPergunta(db);
        pergunta4.addPergunta(db);
        pergunta5.addPergunta(db);
        pergunta6.addPergunta(db);
        pergunta7.addPergunta(db);
        pergunta8.addPergunta(db);
        pergunta9.addPergunta(db);


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE tblPergunta");
        this.onCreate(db);
    }
}
