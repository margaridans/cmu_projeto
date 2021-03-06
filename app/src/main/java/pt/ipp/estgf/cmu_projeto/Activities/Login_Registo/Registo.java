package pt.ipp.estgf.cmu_projeto.Activities.Login_Registo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pt.ipp.estgf.cmu_projeto.MainActivity;
import pt.ipp.estgf.cmu_projeto.R;

public class Registo extends AppCompatActivity {
    EditText editTextUserName, editTextPassword, editTextConfirmPassword;
    Button btnCreateAccount;
    Context context = this;
    Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registo);
        login = new Login(this);
        login = login.open();
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);

        btnCreateAccount = findViewById(R.id.btnCriarConta);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String nome_user = editTextUserName.getText().toString();
                String pass_user = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();
                if (nome_user.equals("") || pass_user.equals("")|| confirmPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Campo vazio", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!pass_user.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(),"A palavra passe não corresponde", Toast.LENGTH_LONG).show();
                } else {
                    login.inserirCampos(nome_user, pass_user);
                    Toast.makeText(getApplicationContext(),"Conta criada com sucesso", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Registo.this,MainActivity.class);
                    startActivity(i);
                    finish();

                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        login.close();
    }
}