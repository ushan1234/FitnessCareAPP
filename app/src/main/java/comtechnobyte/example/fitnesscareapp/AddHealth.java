package comtechnobyte.example.fitnesscareapp;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AddHealth extends AppCompatActivity {
    private static final String TAG = "AddHealth";

    TextView mDisplayDate;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    Spinner blood,gender;
    EditText pre,sug,cole,date;
    Button add;
    FirebaseDatabase rootNode;
    DatabaseReference reference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health);

        reference=FirebaseDatabase.getInstance().getReference("health");

        blood = findViewById(R.id.spinner);
        gender = findViewById(R.id.spinner2);
        pre = findViewById(R.id.pressure);
        sug = findViewById(R.id.sugar);
        cole = findViewById(R.id.cholesterol);
        date = findViewById(R.id.datePicker);
        add = findViewById(R.id.button7);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);

        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AddHealth.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner.setAdapter(myAdapter);

        Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(AddHealth.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.gender));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner2.setAdapter(myAdapter2);

        mDisplayDate = (TextView) findViewById(R.id.datePicker);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddHealth.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day
                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                Log.d(TAG, "onDataSet: mm/dd/yyy: " + month + "/" + day + "/" + year);
                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);

            }
        };
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  rootNode = FirebaseDatabase.getInstance();
               // reference = rootNode.getReference("health");
                //Get All The Values
               /* String Blood = blood.getSelectedItem().toString();
                String Gender = gender.getSelectedItem().toString();
                String Pressure = pre.getText().toString().trim();
                String Sugar = sug.getText().toString().trim();
                String Cholesterol = cole.getText().toString().trim();
                String Date = date.getText().toString().trim();

                addHelper AddHelper = new addHelper(Blood, Gender, Pressure, Sugar, Cholesterol, Date);

                reference.setValue("First Data Storage");*/
               addHealth();
            }
        });
    }
        private void addHealth(){
            String Blood= blood.getSelectedItem().toString();
            String Gender= gender.getSelectedItem().toString();
            String Pressure= pre.getText().toString().trim();
            String Sugar= sug.getText().toString().trim();
            String Cholesterol=cole.getText().toString().trim();
            String Date=date.getText().toString().trim();

            if(!TextUtils.isEmpty(Pressure)){
                String id= reference.push().getKey();
                addHelper addHealth=new addHelper(id,Blood,Gender,Pressure,Sugar,Cholesterol,Date);
                reference.child(id).setValue(addHealth);
                Toast.makeText(this,"Add Record", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"You Should Enter Values", Toast.LENGTH_LONG).show();
            }
        }


}