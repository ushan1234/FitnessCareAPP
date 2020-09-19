package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Male extends AppCompatActivity {

    private Button Calculate;
    private EditText Weight,Hight;
    private TextView Answer;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male);

        Calculate=findViewById(R.id.btnCal);
        Weight=findViewById(R.id.fweight);
        Hight=findViewById(R.id.fhight);
        Answer=findViewById(R.id.txCal);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getW=Weight.getText().toString();
                String getH=Hight.getText().toString();

                float W=Float.parseFloat(getW);
                float H=Float.parseFloat(getH);

                float newH=H/100;
                float bmi=W/(newH*newH);

                if (bmi<18.5)
                {
                    Answer.setText("You Are Underweight");
                }
                else if (bmi>=18.5&&bmi<25){
                    Answer.setText("You Are Normal");
                }
                else {
                    Answer.setText("You Are Under");
                }


            }
        });

    }
}