package com.biyardimapp.biyardimv1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class YardimlarActivity extends AppCompatActivity {

    ArrayList<String> helpTitlesFromFB;
    ArrayList<String> helpContentFromFB;
    ArrayList<String> helpCitysFromFB;
    ArrayList<String> helpDatesFromFB;
    ArrayList<String> helpContactsFromFB;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    YardimClass adapter;
    ListView listView;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yardimlar);





        helpTitlesFromFB = new ArrayList<String>();
        helpContentFromFB = new ArrayList<String>();
        helpCitysFromFB = new ArrayList<String>();
        helpDatesFromFB = new ArrayList<String>();
        helpContactsFromFB = new ArrayList<String>();

        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();
        mAuth = FirebaseAuth.getInstance();

        adapter = new YardimClass(helpTitlesFromFB,helpContentFromFB,helpCitysFromFB,helpDatesFromFB,helpContactsFromFB,this);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        getDataFromFirebase();
    }

    protected void getDataFromFirebase(){

        DatabaseReference newReference = firebaseDatabase.getReference("HELP");
        newReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    HashMap<String, String> hashMap = (HashMap<String, String>) ds.getValue();
                    helpTitlesFromFB.add(hashMap.get("helpTitle"));
                    helpContentFromFB.add(hashMap.get("helpContent"));
                    helpCitysFromFB.add(hashMap.get("helpCity"));
                    helpDatesFromFB.add(hashMap.get("helpDate"));
                    helpContactsFromFB.add(hashMap.get("helpContact"));

                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

}
