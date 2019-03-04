package com.notepadapp.rpamdusu.hauzrent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static com.notepadapp.rpamdusu.hauzrent.SignupActivity.INTENT_KEY;

public class ContinueActivity extends AppCompatActivity {
    private TextView textView;
    private EditText payday, addy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);

        payday = findViewById(R.id.Rent);
        addy = findViewById(R.id.address);

        String ypayday = payday.getText().toString();
        String yaddy = addy.getText().toString();

        Intent intent = getIntent();
        String name = intent.getStringExtra("yfirstname");






    }
}
