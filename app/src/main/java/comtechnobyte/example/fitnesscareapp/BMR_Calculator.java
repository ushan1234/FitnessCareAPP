package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class BMR_Calculator extends AppCompatActivity {
    EditText weight, height, age;
    TextView resulttext;
    String calculation, BMIresult;
    Spinner spinner;
    char text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_r__calculator);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resulttext = findViewById(R.id.result);
        age = findViewById(R.id.age);


    }



    public void calculateBMI(View view) {
        String S1 = weight.getText().toString();
        String S2 = height.getText().toString();
        String S3 = age.getText().toString();




        double weightValue = Float.parseFloat(S1);
        double heightValue = Float.parseFloat(S2);
        double ageValue = Float.parseFloat(S3);



        double bmi = 88.362 + (13.397 * weightValue) + (4.799*heightValue) + (5.677*ageValue);









        calculation =  bmi + " calories" ;



        resulttext.setText(calculation);
    

        
    }
}