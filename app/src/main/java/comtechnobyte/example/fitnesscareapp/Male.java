package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Male extends AppCompatActivity {
    Database myDb;


    private Button Calculate,ok;
    private EditText Weight, Hight;
    private TextView Answer, date, gender;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male);



        myDb=new Database(this);
        Calculate = findViewById(R.id.btnCal);
        Weight = findViewById(R.id.fweight);
        Hight = findViewById(R.id.fhight);
        Answer = findViewById(R.id.txCal);
        date = findViewById(R.id.textdate);
        gender = findViewById(R.id.textgender);

        ok = findViewById(R.id.bok);



        Intent intent = getIntent();
        gender.setText(intent.getStringExtra("gender"));
        date.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date()));

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


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted= myDb.inserData(gender.getText().toString(),
                        date.getText().toString(),
                        Weight.getText().toString(),
                        Hight.getText().toString(),
                        Answer.getText().toString()
                        );


                if (isInserted == true)
                    Toast.makeText(Male.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Male.this,"Data not Inserted",Toast.LENGTH_LONG).show();



            }
        });

    }
}