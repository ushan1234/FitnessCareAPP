package comtechnobyte.example.fitnesscareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Ereport extends AppCompatActivity {

    ListView listViewHealth;
    DatabaseReference reference;
    List<ExeHelper> healthList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reference= FirebaseDatabase.getInstance().getReference("exercise");
        setContentView(R.layout.activity_ereport);
        listViewHealth=(ListView) findViewById(R.id.Exlistview);
        healthList=new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                healthList.clear();

                for (DataSnapshot healthSnapshot : dataSnapshot.getChildren()) {
                    ExeHelper addhelper = healthSnapshot.getValue(ExeHelper.class);
                    healthList.add(addhelper);


                }
                ExeList adapter = new ExeList(Ereport.this, healthList);
                listViewHealth.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });








    }

}