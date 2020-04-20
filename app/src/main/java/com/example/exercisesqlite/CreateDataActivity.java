package com.example.exercisesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateDataActivity extends AppCompatActivity {
    protected Cursor cursor;
    DBHelper dbHelper;
    Button ton1;
    EditText text1, text2, text3, text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_data);

        dbHelper = new DBHelper(this);
        text1 = (EditText) findViewById(R.id.name_edittextcr);
        text2 = (EditText) findViewById(R.id.tl_edittextcr);
        text3 = (EditText) findViewById(R.id.email_edittextcr);
        text4 = (EditText) findViewById(R.id.alm_editviewcr);
        ton1 = (Button) findViewById(R.id.btn_create);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into biodata(nama, tlp, email, alamat) values('" +
                        text1.getText().toString() + "','" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "','" +
                        text4.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}
