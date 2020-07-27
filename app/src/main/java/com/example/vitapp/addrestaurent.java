package com.example.vitapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.vitapp.ui.notifications.profileFragment;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class addrestaurent extends AppCompatActivity {
    Button add;
    TextInputEditText name;
    String nameres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managerestaurant);
        add=findViewById(R.id.add);
        name=(TextInputEditText) findViewById(R.id.name);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameres=name.getText().toString();
              if(nameres.isEmpty()==true){
                  Toast.makeText(addrestaurent.this,"Name cannot be empty",Toast.LENGTH_LONG).show();
              }

            }
        });

    }
}
