package com.notepadapp.rpamdusu.hauzrent;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;

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

        // final Integer rdd = r_due_date.getInputType();
       // final Integer rm = r_money.getInputType();
       // final Integer re_pm = rpm.getInputType();
       r_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(CContinueActivity.this,DashboardActivity.class);
               startActivity(intent);
            ///boolean seal = rent_db.insertRData(rdd,rm,re_pm);
               //if (seal == true){
                 //  Toast.makeText(CContinueActivity.this, "Almost there", Toast.LENGTH_SHORT).show();
               //}
               //else
                  // Toast.makeText(CContinueActivity.this, "Fill It Out", Toast.LENGTH_SHORT).show();

           }
       });

    }

}
