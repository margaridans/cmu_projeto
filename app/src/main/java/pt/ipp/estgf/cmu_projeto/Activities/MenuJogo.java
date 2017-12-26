package pt.ipp.estgf.cmu_projeto.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.ipp.estgf.cmu_projeto.R;

public class MenuJogo extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_jogo);

        Button btn_treino=(Button)findViewById(R.id.treino);
        Button btn_competitivo=(Button)findViewById(R.id.competitivo);


    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.treino) {
            Intent intentTreino = new Intent(this,JogoTreino.class);
            startActivity(intentTreino);
        } else if(view.getId()==R.id.competitivo) {
            Intent intentCompetitivo = new Intent(this, JogoCompetitivo.class);
            startActivity(intentCompetitivo);
        }
    }
}
