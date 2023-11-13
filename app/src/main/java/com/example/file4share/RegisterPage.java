package com.example.file4share;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPage extends AppCompatActivity {

    EditText elm,pass,repass;
    FirebaseAuth mAuth;
    ProgressBar progressBar;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        mAuth = FirebaseAuth.getInstance();
        elm = findViewById(R.id.reg_email);
        pass = findViewById(R.id.reg_password);
        progressBar = findViewById(R.id.prog);
        repass = findViewById(R.id.login_password1);
    }
    public void reg(View view){
        progressBar.setVisibility(View.VISIBLE);
        String email, password,repassword ;
        email = String.valueOf(elm.getText());
        password = String.valueOf(pass.getText());
        repassword = String.valueOf(repass.getText());
        if(TextUtils.isEmpty(email) ){
            Toast.makeText(RegisterPage.this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password) ){
            Toast.makeText(RegisterPage.this, "Enter Password", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }
        if(password.equals(repassword)==false){
            Toast.makeText(RegisterPage.this, "Password Missed Matched", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(RegisterPage.this, "Sign-in Successfull.",
                                    Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(RegisterPage.this, HomePage.class);
                            startActivity(in);
                            finish();
                        } else {
                            progressBar.setVisibility(View.GONE);
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterPage.this, "Sign-in failed.",
                                    Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });


    }
}