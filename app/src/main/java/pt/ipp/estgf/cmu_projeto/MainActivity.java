package pt.ipp.estgf.cmu_projeto;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pt.ipp.estgf.cmu_projeto.Activities.Login_Registo.Login;
import pt.ipp.estgf.cmu_projeto.Activities.Login_Registo.Registo;


public class MainActivity extends AppCompatActivity {

    private Button btnSignUp;
    private Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmu_projeto);

        login = new Login(this);
        login = login.open();

        Button btnSignIn = findViewById(R.id.buttonSignIN);
        //btnSignUp =  findViewById(R.id.buttonSignUP);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intentSignUP = new Intent(getApplicationContext(),
                        Registo.class);
                startActivity(intentSignUP);
            }
        });
    }

//    public void btnJogarOnClick(View v){
//        Intent intent = new Intent(getApplicationContext(), JogoPerguntas.class);
//        startActivity(intent);
//    }


    public void signIn(View V) {
        final Dialog dialog = new Dialog(MainActivity.this);
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
                String storedPassword = login
                        .getSinlgeEntry(userName);
                if (password.equals(storedPassword)) {
                    Toast.makeText(MainActivity.this,
                            "Login efetuado com sucesso", Toast.LENGTH_LONG)
                            .show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this,
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
        login.close();
    }
}