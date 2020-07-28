package com.example.vitapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.vitapp.ui.notifications.profileFragment;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addrestaurent extends AppCompatActivity {
    Button add;
    TextInputEditText name;
    String nameres;
    user_db user1;
    DatabaseReference refer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managerestaurant);
        add=findViewById(R.id.add);
        name=(TextInputEditText) findViewById(R.id.name);
        FirebaseApp.initializeApp(this);
        refer1= FirebaseDatabase.getInstance().getReference().child("AdminQR");
        user1=new user_db();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameres=name.getText().toString();
              if(nameres.isEmpty()==true){
                  Toast.makeText(addrestaurent.this,"Name cannot be empty",Toast.LENGTH_LONG).show();
              }else {

               user1.setName(nameres);
               refer1.push().setValue(user1);

              }

            }
        });

    }
}
