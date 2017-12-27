package pt.ipp.estgf.cmu_projeto.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pt.ipp.estgf.cmu_projeto.R;

public class FimJogo extends AppCompatActivity {
private String status;
private ImageView imageView;
private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_jogo);

        Intent intent=getIntent();

        status= intent.getStringExtra("status");

        if(status.equals("Perdeu")) {
            imageView.setImageResource(R.drawable.sad);
            textView.setText(R.string.msg_perder);
        } else if(status.equals("Ganhou")) {
            imageView.setImageResource(R.drawable.happy);
            textView.setText(R.string.msg_ganhou);
        }
    }
}
