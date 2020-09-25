package comtechnobyte.example.fitnesscareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
                showUpdateDialog(addhelper.getID(), addhelper.getBlood(), addhelper.getGender(), addhelper.getPressure(),addhelper.getSugar(),addhelper.getCholesterol(),addhelper.getDate());
                return false;
            }
        });
    }
    private void showUpdateDialog(final String healthID, final String blood, final String gender, final String pressure, final String sugar, final String cholesterol, final String date){
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        final View dialogView=inflater.inflate(R.layout.update_dialog,null);
        dialogBuilder.setView(dialogView);

        final Spinner spinner3=(Spinner) dialogView.findViewById(R.id.spinner3);
        final Spinner spinner4=(Spinner) dialogView.findViewById(R.id.spinner4);


        final EditText editTextpressre=(EditText) dialogView.findViewById(R.id.editTextpre);

        final EditText editTextsugar=(EditText) dialogView.findViewById(R.id.editTextsug);

        final EditText editTextcholesterol=(EditText) dialogView.findViewById(R.id.editTextcol);
        final EditText editTextDate=(EditText) dialogView.findViewById(R.id.editTextDate);
        final Button update=(Button) dialogView.findViewById(R.id.button8);
        final Button delete=(Button) dialogView.findViewById(R.id.delete);

        dialogBuilder.setTitle("Updating Record"+ healthID);

        final AlertDialog alertDialog=dialogBuilder.create();
        alertDialog.show();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Blood= spinner3.getSelectedItem().toString();
                String Gender= spinner4.getSelectedItem().toString();
                String Pressure= editTextpressre.getText().toString().trim();
                String Sugar= editTextsugar.getText().toString().trim();
                String Cholesterol=editTextcholesterol.getText().toString().trim();
                String Date=editTextDate.getText().toString().trim();

                if(TextUtils.isEmpty(Pressure)){
                    editTextpressre.setError("This Field Is Required");
                    return;
                }
                if(TextUtils.isEmpty(Sugar)){
                    editTextsugar.setError("This Field Is Required");
                    return;
                }

                updateHealth(healthID,Blood,Gender,Pressure,Sugar,Cholesterol,Date);
                alertDialog.dismiss();

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteHealth(healthID);
                alertDialog.dismiss();
            }
        });



    }
    private void deleteHealth(String healthID){
        DatabaseReference dHealth=FirebaseDatabase.getInstance().getReference("health").child(healthID);
        dHealth.removeValue();
        Toast.makeText(this, "Record is Deleted", Toast.LENGTH_LONG).show();

    }

    private boolean updateHealth(String id, String blood, String gender, String pressure, String sugar, String cholesterol, String date){
        DatabaseReference databaseReference =FirebaseDatabase.getInstance().getReference("health").child(id);
        addHelper addhelper=new addHelper(id,blood,gender,pressure,sugar,cholesterol,date);
        databaseReference.setValue(addhelper);
        Toast.makeText(this,"Health Record Updated Successfully",Toast.LENGTH_LONG).show();
        return true;

    }
}