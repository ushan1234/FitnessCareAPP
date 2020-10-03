package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.nio.file.Files;

public class Report extends AppCompatActivity {

    TextView gendertxt;
    TextView answertxt;
    TextView heighttxt;
    TextView weighttxt;
    TextView datetxt;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        gendertxt  = findViewById(R.id.gender_report);
        answertxt= findViewById(R.id.answer_report);
        heighttxt= findViewById(R.id.height_report);
        weighttxt=findViewById(R.id.weight_report);
        datetxt= findViewById(R.id.date_report);
        textView4 = findViewById(R.id.textView4);

        Intent intent = getIntent();

        gendertxt.setText(intent.getStringExtra("gender"));
        answertxt.setText(intent.getStringExtra("answer"));
        heighttxt.setText(intent.getStringExtra("height"));
        weighttxt.setText(intent.getStringExtra("weight"));
        datetxt.setText(intent.getStringExtra("date"));
        textView4.setText(intent.getStringExtra("value"));

    }
}