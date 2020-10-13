package com.example.careu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registrationPage extends AppCompatActivity {

    Button selectPics,profilePicture;
    EditText firstname,lastname,email,phonenumber,username,password,nic,address,relative1,relativephone1,relative2,relativephone2,relative3,relativephone3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        selectPics = findViewById(R.id.btnProfilePicture);
        selectPics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(registrationPage.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(registrationPage.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
                    return;
                }
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                intent.setType("image/*");
                startActivityForResult(intent,1);
            }
        });

        firstname=findViewById(R.id.firstName);
        lastname=findViewById(R.id.lastName);
        email=findViewById(R.id.email);
        phonenumber=findViewById(R.id.phoneNumber);
        username=findViewById(R.id.userName);
        password=findViewById(R.id.password);
        nic=findViewById(R.id.NIC);
        address=findViewById(R.id.address);
        relative1=findViewById(R.id.relative1);
        relativephone1=findViewById(R.id.relativePhone1);
        relative2=findViewById(R.id.relative2);
        relativephone2=findViewById(R.id.relativePhone2);
        relative3=findViewById(R.id.relative3);
        relativephone3=findViewById(R.id.relativePhone3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void OnRegister(View view) {
        String fName=firstname.getText().toString();
        String lName=lastname.getText().toString();
        String eMail=email.getText().toString();
        String pNumber=phonenumber.getText().toString();
        String uName=username.getText().toString();
        String pWord=password.getText().toString();
        String ID=nic.getText().toString();
        String Address=address.getText().toString();
        String rel1=relative1.getText().toString();
        String relPhone1=relativephone1.getText().toString();
        String rel2=relative2.getText().toString();
        String relPhone2=relativephone2.getText().toString();
        String rel3=relative3.getText().toString();
        String relPhone3=relativephone3.getText().toString();
        String type="register";
        backgroundWorker1 backgroundworker1=new backgroundWorker1(this);
        backgroundworker1.execute(type,fName,lName,eMail,pNumber,uName,pWord,ID,Address,rel1,relPhone1,rel2,relPhone2,rel3,relPhone3);
    }
}
