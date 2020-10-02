package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextNumber;
    TextView textView40;
    int number = 100;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersices);

        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        textView40 = (TextView) findViewById(R.id.textView40);
    }
    public void button8Clicked(View v){
        int inNumber = Integer.parseInt(editTextNumber.getText().toString());

        if(inNumber <= number){
            textView40.setText("Under weight");
        }
        else if (inNumber > number){

            bt=(Button)findViewById(R.id.button8);
            bt.setOnClickListener(this);
        }
        else {
            textView40.setText("Invaild Input");
        }


    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,Currentsituation.class);
        startActivity(intent);

    }
}