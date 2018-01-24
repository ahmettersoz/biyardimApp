package com.biyardimapp.biyardimv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class YardimAlActivity extends AppCompatActivity {


    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    EditText yardimBasligi;
    EditText yardimSehri;
    EditText yardimTarihi;
    EditText yardimIletisim;
    EditText yardimIcerigi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yardim_al);
        yardimBasligi = (EditText) findViewById(R.id.yardimBasliği);
        yardimSehri = (EditText) findViewById(R.id.yardimSehri);
        yardimTarihi = (EditText) findViewById(R.id.yardimTarihi);
        yardimIletisim = (EditText) findViewById(R.id.yardimIletisim);
        yardimIcerigi = (EditText) findViewById(R.id.yardimIcerigi);


        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();
        mAuth = FirebaseAuth.getInstance();

    }


    public void yardimOlustur(View view){

        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();

        String yardimBaslik = yardimBasligi.getText().toString();
        String yardimSehir = yardimSehri.getText().toString();
        String yardimTarih = yardimTarihi.getText().toString();
        String yardimContact = yardimIletisim.getText().toString();
        String yardimContent = yardimIcerigi.getText().toString();

        myRef.child("HELP").child(uuidString).child("helpTitle").setValue(yardimBaslik);
        myRef.child("HELP").child(uuidString).child("helpCity").setValue(yardimSehir);
        myRef.child("HELP").child(uuidString).child("helpDate").setValue(yardimTarih);
        myRef.child("HELP").child(uuidString).child("helpContact").setValue(yardimContact);
        myRef.child("HELP").child(uuidString).child("helpContent").setValue(yardimContent);

        Toast.makeText(getApplicationContext(), "Yardım Talebiniz Oluşturulmuştur.", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(), YardimlarActivity.class);
        startActivity(intent);


    }





}
