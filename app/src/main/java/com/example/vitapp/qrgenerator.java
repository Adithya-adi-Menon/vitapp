package com.example.vitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidmads.library.qrgenearator.QRGSaver;

public class qrgenerator extends AppCompatActivity {
    DatabaseReference reference;
    Button generate;
    Button save;
    ImageView qr;
    String savePath = Environment.getExternalStorageDirectory().getPath() + "/QRCode/";
    QRGEncoder qrgEncoder;
    Bitmap bitmap;
   // String value;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrgenerator);
        reference= FirebaseDatabase.getInstance().getReference().child("AdminQR");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    name=dataSnapshot.getValue(String.class);
                    Log.i("name",name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(qrgenerator.this,"Cannot access database",Toast.LENGTH_LONG).show();
            }
        });


        generate=findViewById(R.id.button);
        save=findViewById(R.id.button1);
        qr=findViewById(R.id.qr);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.length() > 0) {
                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                    Display display = manager.getDefaultDisplay();
                    Point point = new Point();
                    display.getSize(point);
                    int width = point.x;
                    int height = point.y;
                    int smallerDimension = width < height ? width : height;
                    smallerDimension = smallerDimension * 3 / 4;

                    qrgEncoder = new QRGEncoder(
                            name, null,
                            QRGContents.Type.TEXT,
                            smallerDimension);
                    try {
                        bitmap = qrgEncoder.encodeAsBitmap();

                        qr.setImageBitmap(bitmap);
                        qr.setVisibility(View.VISIBLE);


                    }catch (Exception e){
                        Toast.makeText(qrgenerator.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }

                }else {
                  Toast.makeText(qrgenerator.this,"Failed to create QR",Toast.LENGTH_LONG).show();
                }
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean save1;
                String res;
                try {
                    save1= QRGSaver.save(savePath,"QRCODE",bitmap,QRGContents.ImageType.IMAGE_JPEG);
                    res=save1?"QR saved":"Qr save Failed";
                    Toast.makeText(qrgenerator.this,res,Toast.LENGTH_LONG).show();
               }catch (Exception e){
                        Toast.makeText(qrgenerator.this,e.getMessage(),Toast.LENGTH_LONG).show();
               }
            }
        });
    }
}