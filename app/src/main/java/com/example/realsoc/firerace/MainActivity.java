package com.example.realsoc.firerace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.realsoc.firerace.model.CounterView;
import com.example.realsoc.firerace.model.DriverTable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    // Creates a listener for firebase datas which shows new mean drivers' age when changed
    // Call for API
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("lastRace");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TextView textBase = (TextView) findViewById(R.id.textRound);
                DriverTable driverTable = dataSnapshot.getValue(DriverTable.class);
                textBase.setText("Round "+driverTable.getSeason()+"."+driverTable.getRound());
                CounterView counterView = (CounterView) findViewById(R.id.counterView);
                counterView.setValue(Utils.getAgeFromDriverArray(driverTable.getDrivers()));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("FIRE_BASE", "Failed to read value.", error.toException());
            }
        });
        APIHelper helper = new APIHelper();
        helper.process();

    }

}
