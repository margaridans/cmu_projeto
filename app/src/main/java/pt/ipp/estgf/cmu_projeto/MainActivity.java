package pt.ipp.estgf.cmu_projeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import pt.ipp.estgf.cmu_projeto.Activities.Jogo.MenuJogo;
import pt.ipp.estgf.cmu_projeto.Activities.Login_Registo.Login;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_activity);


        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        Button btnJogar = findViewById(R.id.btnJogar);
        btnJogar.setOnClickListener(this);

        Button btnDicas = findViewById(R.id.btnDicas);
        btnDicas.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnJogar) {
            Intent intentJogar = new Intent(this, MenuJogo.class);
            startActivity(intentJogar);
        } //else if (v.getId() == R.id.btnDicas) {
            //Intent intentDicas = new Intent (this, Dicas.class);
            //startActivity(intentDicas);
         else if (v.getId() == R.id.btnLogin) {
            Intent intentLogin = new Intent(this, Login.class);
            startActivity(intentLogin);
        }
    }
}