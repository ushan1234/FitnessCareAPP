package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.nio.file.Files;

public class Report extends AppCompatActivity {

    TextView gendertxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        gendertxt  = findViewById(R.id.gender_report);

        Intent intent = getIntent();

        gendertxt.setText(intent.getStringExtra("gender"));

    }
}