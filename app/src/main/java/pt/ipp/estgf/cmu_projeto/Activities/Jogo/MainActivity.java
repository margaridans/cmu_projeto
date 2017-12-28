package pt.ipp.estgf.cmu_projeto.Activities.Jogo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pt.ipp.estgf.cmu_projeto.R;


public class MainActivity extends AppCompatActivity  {
/*
    private Button btnSignUp;
    private Login login;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
/*
        login = new Login(this);
        login = login.open();

        Button btnSignIn = findViewById(R.id.btnLogin);
        //btnSignUp =  findViewById(R.id.buttonSignUP);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intentSignUP = new Intent(getApplicationContext(),
                        Registo.class);
                startActivity(intentSignUP);
            }
        });
    }

    public void btnJogarOnClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuJogo.class);
        startActivity(intent);
    }


    public void signIn(View V) {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");
        final EditText editTextUserName = dialog
                .findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword = dialog
                .findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn = dialog.findViewById(R.id.btnLogin);

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
    */
    }
}