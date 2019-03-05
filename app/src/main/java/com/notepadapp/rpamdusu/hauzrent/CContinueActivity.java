package com.notepadapp.rpamdusu.hauzrent;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

public class CContinueActivity extends AppCompatActivity {
 private EditText r_due_date,r_money, rpm ;
 private Button r_button;

   AlphaNames rent_db;
   public SQLiteDatabase rdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ccontinue);

        r_due_date = findViewById(R.id.rent_due_date);
        r_money = findViewById(R.id.rent_money);
        rpm = findViewById(R.id.rent_pm);
        r_button =  findViewById(R.id.rent_button);


    }
}
