package comtechnobyte.example.fitnesscareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HealthRecords extends AppCompatActivity {

    ListView listViewHealth;
    DatabaseReference reference;
    List<addHelper> healthList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reference= FirebaseDatabase.getInstance().getReference("health");
        setContentView(R.layout.activity_health_records);
        listViewHealth=(ListView) findViewById(R.id.ListViewHealth);
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
                    addHelper addhelper = healthSnapshot.getValue(addHelper.class);
                    healthList.add(addhelper);


                }
                HealthList adapter = new HealthList(HealthRecords.this, healthList);
                listViewHealth.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        listViewHealth.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                addHelper addhelper=healthList.get(i);
                showUpdateDialog(addhelper.getID(), addhelper.getPressure(),addhelper.getSugar(),addhelper.getCholesterol());
                return false;
            }
        });
    }
    private void showUpdateDialog(String healthID, String pressure, String sugar, String cholesterol){
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        final View dialogView=inflater.inflate(R.layout.update_dialog,null);
        dialogBuilder.setView(dialogView);

        final TextView textViewpressure=(TextView) dialogView.findViewById(R.id.textViewpre);
        final EditText editTextpressre=(EditText) dialogView.findViewById(R.id.editTextpre);
        final TextView textViewsugar=(TextView) dialogView.findViewById(R.id.textViewsug);
        final EditText editTextsugar=(EditText) dialogView.findViewById(R.id.editTextsug);
        final TextView textViewcholesterol=(TextView) dialogView.findViewById(R.id.textViewcole);
        final EditText editTextcholesterol=(EditText) dialogView.findViewById(R.id.editTextcol);
        final Button update=(Button) dialogView.findViewById(R.id.button8);

        dialogBuilder.setTitle("Updating Record"+ healthID);

        AlertDialog alertDialog=dialogBuilder.create();
        alertDialog.show();

    }
}