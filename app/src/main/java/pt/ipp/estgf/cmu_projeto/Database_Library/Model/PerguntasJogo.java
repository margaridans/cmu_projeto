package pt.ipp.estgf.cmu_projeto.Database_Library.Model;

import android.content.Context;

import java.util.ArrayList;

import pt.ipp.estgf.cmu_projeto.Database_Library.Database.MyDbHelper;

/**
 * Created by Bernardino on 26/12/2017.
 */

public class PerguntasJogo {
    private Context context;
    private ArrayList<Pergunta> perguntasJogo;
    private MyDbHelper dbHelper;
    private int posicaoUltimaPergunta;

    public PerguntasJogo(Context context, String tipoJogo, int opcao) {
        this.context=context;
        dbHelper=new MyDbHelper(context);
        perguntasJogo=new ArrayList<>();


        if(tipoJogo.equals("Competitivo")) {
            Pergunta.getPerguntas(dbHelper.getReadableDatabase(),perguntasJogo);
        }
    }

    public boolean respostaCerta (String resposta) {
        if(posicaoUltimaPergunta>-1) {
            return perguntasJogo.get(posicaoUltimaPergunta).getResposta_certa().equals(resposta);
        }
        return false;
    }


}
