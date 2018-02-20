package com.example.app.realtimedatabase;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
TextView textView;
Button btn1,btn2;
//DatabaseReference databaseReference;
DatabaseReference  databaseReference= FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionref=databaseReference.child("condition");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.sunny_id);
        btn2=(Button)findViewById(R.id.foggy_id);
        textView=(TextView)findViewById(R.id.text);

    }

    @Override
    protected void onStart() {
        super.onStart();

conditionref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String data = dataSnapshot.getValue(String.class);
        textView.setText(data);

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});
btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        conditionref.setValue("sunny");
    }
});
btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        conditionref.setValue("foggy");
    }
});

    }
}
