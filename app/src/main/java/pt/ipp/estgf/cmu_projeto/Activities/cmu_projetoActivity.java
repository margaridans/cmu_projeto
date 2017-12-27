package pt.ipp.estgf.cmu_projeto.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pt.ipp.estgf.cmu_projeto.R;


public class cmu_projetoActivity extends AppCompatActivity {

    private Button btnSignUp;
    private LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmu_projeto);

        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        Button btnSignIn = findViewById(R.id.buttonSignIN);
        //btnSignUp =  findViewById(R.id.buttonSignUP);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intentSignUP = new Intent(getApplicationContext(),
                        SignUPActivity.class);
                startActivity(intentSignUP);
            }
        });
    }

//    public void btnJogarOnClick(View v){
//        Intent intent = new Intent(getApplicationContext(), JogoPerguntas.class);
//        startActivity(intent);
//    }


    public void signIn(View V) {
        final Dialog dialog = new Dialog(cmu_projetoActivity.this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");
        final EditText editTextUserName = dialog
                .findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword = dialog
                .findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn = dialog.findViewById(R.id.buttonSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String storedPassword = loginDataBaseAdapter
                        .getSinlgeEntry(userName);
                if (password.equals(storedPassword)) {
                    Toast.makeText(cmu_projetoActivity.this,
                            "Login efetuado com sucesso", Toast.LENGTH_LONG)
                            .show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(cmu_projetoActivity.this,
                            "Username e password não correspondem",
                            Toast.LENGTH_LONG).show();
                }
            }

        });

        dialog.show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }
}