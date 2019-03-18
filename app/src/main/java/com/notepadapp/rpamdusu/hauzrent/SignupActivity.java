package com.notepadapp.rpamdusu.hauzrent;




import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    private EditText firstname,lastname,hemail,hpassword;
    private Button mButton, mSignIn;
//    private FirebaseAnalytics mFirebaseAnalytics;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
  //      mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        FirebaseApp.initializeApp(this);
        firstname = findViewById(R.id.fname);
        lastname = findViewById(R.id.lname);
        hemail = findViewById(R.id.email);
        hpassword = findViewById(R.id.password);

        mSignIn = findViewById(R.id.signIn_button);
        mButton = findViewById(R.id.press_button);


            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (view == mButton) {
                        createAccount();
                    }
                }
            });
            mSignIn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (view == mSignIn){
                                startActivity(new Intent(getApplicationContext(),
                                        SignInActivity.class));
                            }
                        }
    });
}
    private void createAccount() {
        final String hFirstname = firstname.getText().toString();
        final String hLastname = lastname.getText().toString();
        final String email = hemail.getText().toString();
        final String password = hpassword.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "A Field is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "A Field is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(hFirstname)) {
            Toast.makeText(this, "A Field is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(hLastname)) {
            Toast.makeText(this, "A Field is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        try {
                            //check if Successful
                            if (task.isSuccessful()) {
                                Toast.makeText(SignupActivity.this, "registration successful",
                                        Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(getApplicationContext(), ContinueActivity.class));
                            } else {
                                Toast.makeText(SignupActivity.this, "Couldn't register, try again",
                                        Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // ...
                    }
                });
    }
}









