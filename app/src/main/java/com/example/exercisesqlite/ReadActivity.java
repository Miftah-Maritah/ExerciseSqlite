package com.example.exercisesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReadActivity extends AppCompatActivity {
    protected Cursor cursor;
    DBHelper dbHelper;
    TextView text1, text2, text3, text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        dbHelper = new DBHelper(this);
        text1 = (TextView) findViewById(R.id.name_read1);
        text2 = (TextView) findViewById(R.id.tl_read1);
        text3 = (TextView) findViewById(R.id.em_read1);
        text4 = (TextView) findViewById(R.id.alm_read1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            //text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
        }
    }
}
