package pt.ipp.estgf.cmu_projeto.Database_Library;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import pt.ipp.estgf.cmu_projeto.Database_Library.Database.MyDbHelper;


public class LoginDataBaseAdapter {


    public SQLiteDatabase db;
    private final Context context;
    private MyDbHelper dbHelper;

    public LoginDataBaseAdapter(Context _context) {
        context = _context;
        dbHelper = new MyDbHelper(context, "KidsZone", null,1);
    }

    public LoginDataBaseAdapter open() throws SQLException {
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