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
    

     private EditText passCode;
     private Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signIn = findViewById(R.id.button_sign_in);
        passCode = (EditText) findViewById(R.id.passWord);
        work();

         Intent intent = getIntent();



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


        if(passCode.equals("")|| passCode != null)

            {
                Toast.makeText(getApplicationContext(), "please enter value",Toast.LENGTH_LONG).show();
                flag = false;
        }
        else return;
}



    }
