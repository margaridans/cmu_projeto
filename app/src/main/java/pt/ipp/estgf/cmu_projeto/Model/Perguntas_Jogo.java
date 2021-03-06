package pt.ipp.estgf.cmu_projeto.Model;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import pt.ipp.estgf.database_library.Database.MyDbHelper;
import pt.ipp.estgf.database_library.Model.Pergunta;


public class Perguntas_Jogo {
    private Context context;
    private ArrayList<Pergunta> perguntasJogo;
    private LinkedList<Integer> perguntasJogadas;
    private MyDbHelper dbHelper;
    private int posicaoUltimaPergunta;

    public Perguntas_Jogo(Context context, int opcao) {
        this.context = context;
        dbHelper = new MyDbHelper(context);
        perguntasJogo = new ArrayList<>();
        perguntasJogadas = new LinkedList<>();

        /*Vai buscar as perguntas a serem mostradas*/
        Pergunta.getPerguntas(dbHelper.getReadableDatabase(), perguntasJogo);

        perguntasJogadas = new LinkedList<>();

        this.posicaoUltimaPergunta = -1;
    }

    public boolean respostaCerta(String resposta) {
        return posicaoUltimaPergunta > -1 && perguntasJogo.get(posicaoUltimaPergunta).getResposta_certa().equals(resposta);
    }

    /*Método que calcula qual a próxima pergunta a ser mostrada ao utilizador
    * A pergunta é gerada conforme a sua posição na lista ligada(LinkedList) onde
    * estão as perguntas todas (perguntasJogadas).
    * Para encontrar a próxima pergunta a sua posição não pode estar na lista ligada
    * porque esta contem as posições que já sairam*/


    public Pergunta getNextPergunta() {
        if (perguntasJogo.size() == perguntasJogadas.size()) {
            return null;
        }

        int randomNum = positionPergunta((perguntasJogo.size()));
        perguntasJogadas.add(randomNum);
        posicaoUltimaPergunta = randomNum;

        return perguntasJogo.get(randomNum);
    }

    /*Este método vai gerar a posição da pergunta, vai gerar um número random, de 0(inclusive)
    * até ao número recebido - tamMaximo - (exclusive) e vai retornar esse número gerado*/
    public int positionPergunta(int tamMaximo) {
        Random random = new Random();
        int randomNum;

        do {
            /*randomNum vai ficar com um pseudorandom, ou seja, um valor entre 0 e o tamMax
           um valor interno distribuído uniformemente entre 0 (inclusive) extraído da sequência deste
           gerador de números aleatórios.*/
            randomNum = random.nextInt(tamMaximo);
        } while (perguntasJogadas.contains(randomNum));

        return randomNum;
    }
}
