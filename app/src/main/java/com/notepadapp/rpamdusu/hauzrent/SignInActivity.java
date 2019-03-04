package com.notepadapp.rpamdusu.hauzrent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class SignInActivity extends AppCompatActivity {
    
    private static final String DATABASE_NAME = "CopernicusDB.sqlite";
    private static final String DATABASE_TABLE = "TimeReportTable";
    private static final int    DATABASE_VERSION = 1;
     private EditText uName,passCode;
     private Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        work();

         Intent intent = getIntent();
      uName =  findViewById(R.id.userDetails);
      passCode = (EditText) findViewById(R.id.passWord);

      String yUname = uName.getText().toString();
      String ypassWord = passCode.getText().toString();

      signIn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent signIntent = new Intent(SignInActivity.this , DashboardActivity.class);
          }
      });

    }

    private void work() {
        boolean flag = true;

        if(uName.equals("") || uName!=null )
        {
            Toast.makeText(getApplicationContext(), "please enter value",Toast.LENGTH_LONG).show();
            flag = false;
        }
        if(passCode.equals("")|| passCode != null)

            {
                Toast.makeText(getApplicationContext(), "please enter value",Toast.LENGTH_LONG).show();
                flag = false;


        }
}



    }
