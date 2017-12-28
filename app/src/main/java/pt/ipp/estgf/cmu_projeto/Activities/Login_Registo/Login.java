package pt.ipp.estgf.cmu_projeto.Activities.Login_Registo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import pt.ipp.estgf.database_library.Database.MyDbHelper;


public class Login extends AppCompatActivity {

    /*

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
*/

    public SQLiteDatabase db;
    private final Context context;
    private MyDbHelper dbHelper;

    public Login(Context _context) {
        context = _context;
        dbHelper = new MyDbHelper(context);
    }

    public Login open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String nome_user, String pass_user) {
        ContentValues newValues = new ContentValues();
        newValues.put("USERNAME", nome_user);
        newValues.put("PASSWORD", pass_user);
        db.insert("tblUser", null, newValues);

    }



    public String getSinlgeEntry(String userName) {
        Cursor cursor = db.query("tblUser", null, " USERNAME=?",
                new String[] { userName }, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public void updateEntry(String userName, String password) {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD", password);

        String where = "USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[] { userName });
    }
}