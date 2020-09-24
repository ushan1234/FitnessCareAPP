package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BmiCall1 extends AppCompatActivity {
    Database myDb;


    RadioGroup genderGroup;
    RadioButton maleRadio, femaleradio;


    Button nextBtn,report;
    String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_call1);
        myDb = new Database (this);

        genderGroup = findViewById(R.id.genderGroup);
        maleRadio = findViewById(R.id.rmale);
        femaleradio = findViewById(R.id.rfemale);
        report=findViewById(R.id.Breport);





        nextBtn = findViewById(R.id.nextbtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(genderGroup.getCheckedRadioButtonId() == R.id.rmale){
                    gender = "Male";
                }else if (genderGroup.getCheckedRadioButtonId() == R.id.rfemale){
                    gender = "Female";
                }



                if (gender.equals("Male") || gender.equals("Female")){
                    //Toast.makeText(BmiCall1.this, "Gender: "+gender+" "+date , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(BmiCall1.this, Male.class);
                    intent.putExtra("gender", gender);
                    startActivity(intent);
                }else {
                    Toast.makeText(BmiCall1.this, "Please select your gender", Toast.LENGTH_SHORT).show();
                }
            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BmiCall1.this,Beforreoprt.class));

            }
        });




    }
}