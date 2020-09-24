package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public abstract class Beforreoprt<myDb> extends AppCompatActivity {

    RecyclerView recyclerView;

    Database myDb;
    ArrayList<String> date;
    ArrayList<String>gender;
    ArrayList<String>answer;
    ArrayList<String>weight;
    ArrayList<String>hight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beforreport);

        recyclerView = findViewById(R.id.recyclerView);
        myDb = new Database(Beforreoprt.this);

        date = new ArrayList<>();
        gender = new ArrayList<>();
        answer = new ArrayList<>();
        weight = new ArrayList<>();
        hight = new ArrayList<>();

        disspalyData();

    } 


    void disspalyData() {
        Cursor cursor = myDb.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this,"No data.", Toast.LENGTH_LONG).show();

        } else {
            while (cursor.moveToNext()) {
                date.add(cursor.getString(0));
                gender.add(cursor.getString(0));
                answer.add(cursor.getString(0));
                weight.add(cursor.getString(0));
                hight.add(cursor.getString(0));
            }
        }
    }
}