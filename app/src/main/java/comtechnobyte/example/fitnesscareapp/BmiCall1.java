package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.nio.file.Files;

public class BmiCall1 extends AppCompatActivity {

    RadioGroup genderGroup;
    RadioButton maleRadio, femaleradio;
    Button nextBtn;
    String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_call1);

        genderGroup = findViewById(R.id.genderGroup);
        maleRadio = findViewById(R.id.rmale);
        femaleradio = findViewById(R.id.rfemale);

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
                    Toast.makeText(BmiCall1.this, "Gender: "+gender , Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(BmiCall1.this, "Please select your gender", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}