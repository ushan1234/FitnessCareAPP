package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Home_health extends AppCompatActivity {

    CardView h1,h2;
    TextView addText,viewText;
    ImageView addImage,viewImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_health);
        h1=findViewById(R.id.h1);
        h2=findViewById(R.id.h2);
        addText=findViewById(R.id.addtext);
        viewText=findViewById(R.id.viewtext);
        addImage=findViewById(R.id.addimage);
        viewImage=findViewById(R.id.viewimage);

        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddHealth.class));
            }
        });
        addText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddHealth.class));
            }
        });
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddHealth.class));
            }
        });

        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HealthRecords.class));
            }
        });
        viewText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HealthRecords.class));
            }
        });
        viewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HealthRecords.class));
            }
        });
    }
}