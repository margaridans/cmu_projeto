package pt.ipp.estgf.cmu_projeto.Activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import pt.ipp.estgf.cmu_projeto.Database_Library.Database.MyDbHelper;
import pt.ipp.estgf.cmu_projeto.Database_Library.Model.Dificuldade;
import pt.ipp.estgf.cmu_projeto.Database_Library.Model.Pergunta;
import pt.ipp.estgf.cmu_projeto.Database_Library.Model.PerguntasJogo;
import pt.ipp.estgf.cmu_projeto.R;

public class JogoTreino extends AppCompatActivity {
    private ArrayList<Pergunta> listaPerguntas;
    private int id_lista=0;
    private PerguntasJogo jogo;
    private float pontuacao=0;
    private Dificuldade dificuldade;
    private TextView txtPergunta, txtPontuacao;
    private Button btn1, btn2, btn3, btn4;
    private Pergunta pergunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        listaPerguntas = new ArrayList<>();
        jogo = new PerguntasJogo(this, "Competitivo", -1);

        txtPergunta = (TextView) findViewById(R.id.pergunta);
        btn1 = (Button) findViewById(R.id.resposta1);
        btn2 = (Button) findViewById(R.id.resposta2);
        btn3 = (Button) findViewById(R.id.resposta3);
        btn4 = (Button) findViewById(R.id.resposta4);

        txtPontuacao=(TextView)findViewById(R.id.pontuacao);

        MyDbHelper dbHelper= new MyDbHelper(this);
        SQLiteDatabase db= dbHelper.getWritableDatabase();

        Pergunta.getPerguntas(db,listaPerguntas);
        pergunta=listaPerguntas.get(id_lista);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                verificaResposta(btn1.getText().toString(), dificuldade);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                verificaResposta(btn2.getText().toString(), dificuldade);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                verificaResposta(btn3.getText().toString(), dificuldade);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                verificaResposta(btn3.getText().toString(), dificuldade);
            }
        });
    }

    private void verificaResposta(String resposta, Dificuldade dificuldade) {
        if(jogo.respostaCerta(resposta)) {
            txtPontuacao.setText("Pontos: " + pontuacao);

        } else {
            Intent intent= new Intent(this, FimJogo.class);
           startActivity(intent);
        }
    }


    }

