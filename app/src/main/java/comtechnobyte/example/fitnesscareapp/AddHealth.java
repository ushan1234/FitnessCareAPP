package comtechnobyte.example.fitnesscareapp;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class AddHealth extends AppCompatActivity {
    private static final String TAG = "AddHealth";

    TextView mDisplayDate;
    DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health);

        Spinner mySpinner=(Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(AddHealth.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner.setAdapter(myAdapter);

        Spinner mySpinner2=(Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter2=new ArrayAdapter<String>(AddHealth.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.gender));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner2.setAdapter(myAdapter2);

        mDisplayDate=(TextView) findViewById(R.id.datePicker);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(
                        AddHealth.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day
                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });
        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                Log.d(TAG, "onDataSet: mm/dd/yyy: " + month + "/" + day + "/" + year);
                String date=month + "/" + day + "/" + year;
                mDisplayDate.setText(date);

            }
        };

    }
}