package pt.ipp.estgf.cmu_projeto.Database_Library.Model;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import pt.ipp.estgf.cmu_projeto.Database_Library.Database.MyDbHelper;

/**
 * Created by Bernardino on 26/12/2017.
 */

public class PerguntasJogo {
    private Context context;
    private ArrayList<Pergunta> perguntasJogo;
    private LinkedList<Integer> perguntasJogadas;
    private LinkedList<Integer> respostas;
    private MyDbHelper dbHelper;
    private int posicaoUltimaPergunta;

    public PerguntasJogo(Context context, String tipoJogo, int opcao) {
        this.context=context;
        dbHelper=new MyDbHelper(context);
        perguntasJogo=new ArrayList<>();
        perguntasJogadas= new LinkedList<>();


        if(tipoJogo.equals("Treino")) {
            Pergunta.getPerguntas(dbHelper.getReadableDatabase(),perguntasJogo);
        }
        perguntasJogadas= new LinkedList<>();
        respostas= new LinkedList<>();

        this.posicaoUltimaPergunta = -1;
    }


    public boolean respostaCerta (String resposta) {
        if(posicaoUltimaPergunta>-1) {
            return perguntasJogo.get(posicaoUltimaPergunta).getResposta_certa().equals(resposta);
        }
        return false;
    }

    public Pergunta getNextPergunta() {
        if(perguntasJogo.size()==perguntasJogadas.size()) {
            return null;
        }

        int randomNum=positionPergunta((perguntasJogo.size()));
        perguntasJogadas.add(randomNum);
        posicaoUltimaPergunta=randomNum;

        return perguntasJogo.get(randomNum);
    }

    public int positionPergunta(int tamMaximo) {
        Random random = new Random();
        int randomNum = -1;

        do {
            randomNum=random.nextInt(tamMaximo);
        } while(perguntasJogadas.contains(randomNum));
        return randomNum;
    }

    public String positionResposta (int tamMaximo) {
        Random random = new Random();
        int randomNum = -1;

        do {
            randomNum=random.nextInt(tamMaximo+1);
        } while(respostas.contains(randomNum) || randomNum == 0);
        respostas.add(randomNum);

        if(randomNum==1) {
            return perguntasJogo.get(posicaoUltimaPergunta).getResposta1();
        } else if(randomNum == 2) {
            return perguntasJogo.get(posicaoUltimaPergunta).getResposta2();
        } else if(randomNum == 3) {
            return perguntasJogo.get(posicaoUltimaPergunta).getResposta3();
        } else if(randomNum == 4) {
            return perguntasJogo.get(posicaoUltimaPergunta).getResposta_certa();
        } else {
            return "";
        }
    }


}
