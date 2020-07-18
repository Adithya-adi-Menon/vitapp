package com.example.vitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vitapp.ui.notifications.profileFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
   TextInputEditText name,regno,phone;
    Button register;
    user_db user;
    DatabaseReference reff;
    //hello
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        name= (TextInputEditText) findViewById(R.id.name);
        regno=(TextInputEditText) findViewById(R.id.regno);
        phone=(TextInputEditText) findViewById(R.id.mobileno);
        register=(Button) findViewById(R.id.register);
        reff = FirebaseDatabase.getInstance().getReference().child("User");
        user = new user_db();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert();

               String phnumber =phone.toString().trim();
               if(phnumber.isEmpty())
               {
                   phone.setError("Number is required");
                   phone.requestFocus();
                   return;
               }
               Intent intent =new Intent(MainActivity.this,otp.class);
                intent.putExtra("phonenumber",phnumber);
                startActivity(intent);

            }
        });


    }
//    private void insert()
//    {
//       Long phne =Long.parseLong(phone.getText().toString().trim());
//       user.setName(name.getText().toString().trim());
//       user.setRegno(regno.getText().toString().trim());
//       user.setPhone(phne);
//
//
//       reff.push().setValue(user);
//        Toast.makeText(MainActivity.this, "Inserted Succesfully", Toast.LENGTH_SHORT).show();
////
////        Intent intent =new Intent(MainActivity.this,otp.class);
//////        intent.putExtra("phonenumber",phne);
////        startActivity(intent);
//    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null)
        {
            Intent intent =new Intent(MainActivity.this, MainActivitydash.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}