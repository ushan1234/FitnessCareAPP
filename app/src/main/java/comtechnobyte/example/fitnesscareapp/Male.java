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
    private TextView Answer, date, gender, value ;



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
        value= findViewById(R.id.txtvalue);

        ok = findViewById(R.id.bok);
        ok.setVisibility(View.GONE);



        Intent intent = getIntent();
        gender.setText(intent.getStringExtra("gender"));
        date.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date()));

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Weight.getText().toString().equals("") || Hight.getText().toString().equals("")){
                    Toast.makeText(Male.this, "Please enter height and weight", Toast.LENGTH_SHORT).show();
                }else {
                    String getW=Weight.getText().toString();
                    String getH=Hight.getText().toString();



                    float W=Float.parseFloat(getW);
                    float H=Float.parseFloat(getH);

                  //  float newH=H/100;
                    //float bmi=W/(newH*newH);
                    float bmi = calBMI(W,H);


                    if (Float.compare(bmi, 15f) <= 0) {
                       Answer.setText("very_severely_underweight");
                       String var = String.format("%.2f",bmi);
                       value.setText(var);

                    } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
                        Answer.setText("severely_underweight");
                        String var = String.format("%.2f",bmi);
                        value.setText(var);
                        //value.setText(String.valueOf(bmi));
                    } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
                        Answer.setText("underweight");
                        String var = String.format("%.2f",bmi);
                        value.setText(var);
                       // value.setText(String.valueOf(bmi));
                    } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
                        Answer.setText("normal");
                        String var = String.format("%.2f",bmi);
                        value.setText(var);

                       // value.setText(String.valueOf(bmi));
                    } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
                        Answer.setText("overweight");
                        String var = String.format("%.2f",bmi);
                        value.setText(var);
                       // value.setText(String.valueOf(bmi));
                    } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
                        Answer.setText("obese_class_i");
                        String var = String.format("%.2f",bmi);
                        value.setText(var);
                       // value.setText(String.valueOf(bmi));
                    } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
                        Answer.setText("obese_class_ii");
                        String var = String.format("%.2f",bmi);
                        value.setText(var);
                       // value.setText(String.valueOf(bmi));
                    } else {
                        Answer.setText("obese_class_iii");
                        String var = String.format("%.2f",bmi);
                        value.setText(var);
                        //value.setText(String.valueOf(bmi));
                    }



                    ok.setVisibility(View.VISIBLE);
                }




           }

        });


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Weight.getText().equals("") || Hight.getText().equals("") ){

              }else {
                    boolean isInserted= myDb.inserData(gender.getText().toString(),
                            date.getText().toString(),
                            Weight.getText().toString(),
                            Hight.getText().toString(),
                            Answer.getText().toString(),
                            value.getText().toString()
                    );


                    if (isInserted == true)
                        Toast.makeText(Male.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Male.this,"Data not Inserted",Toast.LENGTH_LONG).show();

                    startActivity(new Intent(Male.this, BmiCall1.class));


             }



            }
        });

    }

    public float calBMI(float weight,float height){

        float h = (height /100)*(height /100);
        float bmi = (weight/h);
        return bmi;
    }
}