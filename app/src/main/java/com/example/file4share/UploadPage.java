package com.example.file4share;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class UploadPage extends AppCompatActivity {
    EditText ed;
    Button bt;

    StorageReference storageReference;
    DatabaseReference databaseReference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);   //to make full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_upload_page);
        ed = findViewById(R.id.name);
        bt = findViewById(R.id.bt1);


        storageReference= FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("Uploads");
    }

    public void upload(View view){
        Intent in = new Intent();
        in.setType("application/pdf");
        in.setAction(Intent.ACTION_GET_CONTENT);
    }

    /*public void upload(View view){
        String edt ;
        edt = String.valueOf(ed.getText());
        if(TextUtils.isEmpty(edt) ){
            Toast.makeText(UploadPage.this, "Enter File Name", Toast.LENGTH_SHORT).show();
            return;
        }
    }*/


}