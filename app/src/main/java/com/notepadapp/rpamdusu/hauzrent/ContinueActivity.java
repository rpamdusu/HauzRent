package com.notepadapp.rpamdusu.hauzrent;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ContinueActivity extends AppCompatActivity {



    private TextView textView;
    private EditText Bvn, addy, phone;
    private Button next;

    AlphaNames PDatadb;
    public SQLiteDatabase pdb;

    public  static final  String NEXT_KEY= "save";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);
        next = findViewById(R.id.nextPage);
        Bvn = findViewById(R.id.bvn);
        addy = findViewById(R.id.address);
        phone = findViewById(R.id.client_phone);



       final Integer yBVN = Bvn.getInputType();
       final String yaddy = addy.getText().toString();
       final Integer yPhone = phone.getInputType();


               next.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                       Intent intent = new Intent(ContinueActivity.this, CContinueActivity.class);
                       startActivity(intent);
                       //boolean enter = PDatadb.insertPData(yBVN,yaddy,yPhone);
                       //if (enter == true){
                         //  Toast.makeText(ContinueActivity.this, "Very Good", Toast.LENGTH_SHORT).show();
                       ///}
                       //else
                         //  Toast.makeText(ContinueActivity.this, "Fill It Out", Toast.LENGTH_SHORT).show();

                   }
               });
        }



}
