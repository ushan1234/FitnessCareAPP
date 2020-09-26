package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Beforreoprt/*<myDb>*/ extends AppCompatActivity {

    RecyclerView recyclerView;

    Database myDb;
    ArrayList<String> date;
    ArrayList<String>gender;
    ArrayList<String>answer;
    ArrayList<String>weight;
    ArrayList<String>hight;

    ArrayList<String>id;

    BmiAdapter bmiAdapter;

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
        id = new ArrayList<>();

        disspalyData();

        bmiAdapter = new BmiAdapter(Beforreoprt.this, recyclerView, date, id);
        recyclerView.setAdapter(bmiAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Beforreoprt.this));

    } 


    void disspalyData() {
        date.clear();
        Cursor cursor = myDb.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this,"No data.", Toast.LENGTH_LONG).show();

        } else {
            while (cursor.moveToNext()) {
                date.add(cursor.getString(2));
                id.add(cursor.getString(0));
//                gender.add(cursor.getString(1));
//                answer.add(cursor.getString(2));
//                weight.add(cursor.getString(3));
//                hight.add(cursor.getString(4));
            }
        }
    }
}