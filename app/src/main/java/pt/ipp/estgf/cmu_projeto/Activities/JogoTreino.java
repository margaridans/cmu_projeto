package pt.ipp.estgf.cmu_projeto.Activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pt.ipp.estgf.cmu_projeto.Activities.Model.PerguntasJogo;
import pt.ipp.estgf.cmu_projeto.R;
import pt.ipp.estgf.database_library.Database.MyDbHelper;
import pt.ipp.estgf.database_library.Model.Dificuldade;
import pt.ipp.estgf.database_library.Model.Pergunta;


public class JogoTreino extends AppCompatActivity {
    private ArrayList<Pergunta> listaPerguntas;
    private PerguntasJogo jogo;
    private Dificuldade dificuldade;
    private TextView txtPergunta;
    private Button btn1, btn2, btn3, btn4;
    private Pergunta pergunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        listaPerguntas = new ArrayList<>();
        jogo = new PerguntasJogo(this, -1);

        txtPergunta = (TextView) findViewById(R.id.pergunta);
        btn1 = (Button) findViewById(R.id.resposta1);
        btn2 = (Button) findViewById(R.id.resposta2);
        btn3 = (Button) findViewById(R.id.resposta3);
        btn4 = (Button) findViewById(R.id.resposta4);

        MyDbHelper dbHelper = new MyDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Pergunta.getPerguntas(db, listaPerguntas);


        setPerguntaToView();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn1.getText().toString(), dificuldade);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn2.getText().toString(), dificuldade);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn3.getText().toString(), dificuldade);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaResposta(btn4.getText().toString(), dificuldade);
            }
        });
    }

    private void verificaResposta(String resposta, Dificuldade dificuldade) {
        if (jogo.respostaCerta(resposta)) {
            Toast.makeText(this, "Ganhou", Toast.LENGTH_LONG).show();
            setPerguntaToView();
        } else {
            Intent intent = new Intent(this, FimJogo.class);
            startActivity(intent);
        }
    }

    private void setPerguntaToView() {
        pergunta = jogo.getNextPergunta();

        txtPergunta.setText(pergunta.getPergunta_name());
        btn1.setText(pergunta.getResposta1());
        btn2.setText(pergunta.getResposta2());
        btn3.setText(pergunta.getResposta3());
        btn4.setText(pergunta.getResposta4());
    }

}

