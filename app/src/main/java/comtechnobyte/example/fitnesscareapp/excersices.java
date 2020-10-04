package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
//import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class excersices extends AppCompatActivity implements View.OnClickListener {
    EditText editTextNumber;
    TextView textView40;
    float number = 100;
    Button bt;
    private static final String TAG = "AddHealth";

    TextView mDisplayDate;
    TextView textView41;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    Spinner blood,gender;
    EditText pre,sug,cole,date;
    Button add;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersices);
        reference = FirebaseDatabase.getInstance().getReference("exercise");


        pre = findViewById(R.id.editTextNumber);

        date = findViewById(R.id.datePicker);
        add = findViewById(R.id.button8);



        mDisplayDate = (TextView) findViewById(R.id.datePicker);

        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        textView40 = (TextView) findViewById(R.id.textView40);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(excersices.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day
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

                float inNumber = Float.parseFloat(editTextNumber.getText().toString());

                if(inNumber <= number){

                    Intent intent=new Intent(excersices.this,Currentsituation.class);
                    startActivity(intent);
                }
                else if (inNumber > number){

                   // Intent intent=new Intent(underw.this,Currentsituation.class);
                    //startActivity(intent);

                    textView40.setText("under weight");
                }
                else {
                    textView40.setText("Invaild Input");
                }

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
   /* public void button8Clicked(View v){
        int inNumber = Integer.parseInt(editTextNumber.getText().toString());

        if(inNumber <= number){

            add=(Button)findViewById(R.id.button8);
            add.setOnClickListener(this);
        }
        else if (inNumber > number){

            textView40.setText("Over weight");
        }
        else {
            textView40.setText("Invaild Input");
        }


    }*/

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(excersices.this,Currentsituation.class);
        startActivity(intent);
    }
    private void addHealth () {

        String Pressure = editTextNumber.getText().toString().trim();
        String Date = date.getText().toString().trim();

        if (Pressure.isEmpty()) {
            /*String id = reference.push().getKey();
            ExeHelper addHealth = new ExeHelper(id, Pressure, Date);
            reference.child(id).setValue(addHealth);*/
            Toast.makeText(this, "Enter Records", Toast.LENGTH_LONG).show();
           // Toast.makeText(this, "You Should Enter Values", Toast.LENGTH_LONG).show();
        } else {

            String id = reference.push().getKey();
            ExeHelper addHealth = new ExeHelper(id, Pressure, Date);
            reference.child(id).setValue(addHealth);
            Toast.makeText(this, "Added", Toast.LENGTH_LONG).show();
        }
    }


}