package com.example.file4share;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomePage extends AppCompatActivity {
    FirebaseUser user;
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);   //to make full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

    }



    public void logout(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
        builder.setMessage("you want to Log-out ?");
        builder.setTitle("Are You Sure !!");
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            FirebaseAuth.getInstance().signOut();
            Intent in = new Intent(HomePage.this,MainActivity.class);
            startActivity(in);
            finish();
        });

        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void uploadpage(View view){
        Intent in = new Intent(HomePage.this, UploadPage.class);
        startActivity(in);
    }


    public void logout1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
        builder.setMessage("you want to Log-out ?");
        builder.setTitle("Are You Sure !!");
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            FirebaseAuth.getInstance().signOut();
            Intent in = new Intent(HomePage.this,MainActivity.class);
            startActivity(in);
            finish();
        });

        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }




}