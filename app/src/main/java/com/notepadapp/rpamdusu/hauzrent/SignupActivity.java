package com.notepadapp.rpamdusu.hauzrent;




import android.app.AppComponentFactory;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private EditText firstname,lastname,email,password;
    private Button mButton, mSignIn;

    AlphaNames clientDb;
    public SQLiteDatabase db;


    public static final String INTENT_KEY = "save";



    final String hFirstname = firstname.getText().toString();
    final String hLastname = lastname.getText().toString();
    final String hEmail = email.getText().toString();
    final String hPass = password.getText().toString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mSignIn = findViewById(R.id.signIn_button);
        mButton= findViewById(R.id.press_button);
        clientDb = new AlphaNames(this);

        firstname = findViewById(R.id.fname);
        lastname = findViewById(R.id.lname);
        email = findViewById(R.id.email_add);
        password = findViewById(R.id.passkey);




        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextAct = new Intent(SignupActivity.this, SignInActivity.class);
                startActivity(nextAct);
            }

        });


    }

    private void dbintent() {
        Intent intent = new Intent(SignupActivity.this, ContinueActivity.class);
        intent.putExtra(INTENT_KEY, hPass );
        startActivity(intent);
    }

    public void addData(){
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInserted =  clientDb.insertData(hFirstname,hLastname,hEmail, hPass );
                if(isInserted == true)
                    Toast.makeText(SignupActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(SignupActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                dbintent();
            }
        });
    }
}



//@Override
//protected void onDestroy() {
//     clientDbhelper.close();
//      super.onDestroy();
// }


//    private void displayNames() {
//   SQLiteDatabase db = clientDbhelper.getReadableDatabase();
//}







