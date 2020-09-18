package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText FullName,Age,Date,Username,Password,Repassword;
    Button Register;
    FirebaseAuth fAuth;
    ProgressBar progressbar;
    TextView Loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FullName= findViewById(R.id.Name);
        Age=findViewById(R.id.Age);
        Date=findViewById(R.id.Date);
        Username=findViewById(R.id.UName);
        Password=findViewById(R.id.Pwd);
        Repassword=findViewById(R.id.Rpwd);
        Register=findViewById(R.id.Rbtn);
        Loginbtn=findViewById(R.id.textView3);

        fAuth= FirebaseAuth.getInstance();
        progressbar=findViewById(R.id.progressBar2);
    }
}