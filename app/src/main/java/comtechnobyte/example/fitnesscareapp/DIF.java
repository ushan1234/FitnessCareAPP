package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DIF extends AppCompatActivity {

    TextView showvalue;
    int counter = 0;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_i_f);

        showvalue = (TextView) findViewById(R.id.counterValue);
        btn = findViewById(R.id.button12);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2=new Intent(DIF.this,plank.class);
                startActivity(int2);
            }
        });

    }

    public void countDE(View view) {

                counter++;
                showvalue.setText(Integer.toString(counter));


    }

    public void resetCount (View view){

        counter = 0;
        showvalue.setText(String.valueOf(counter));
    }

}