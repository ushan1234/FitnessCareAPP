package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText username,password;
    Button loginbtn;
    TextView reg;
    ProgressBar progressBar;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.UName3);
        password=findViewById(R.id.pwd);
        loginbtn=findViewById(R.id.Lbtn);
        reg=findViewById(R.id.textView5);
        progressBar=findViewById(R.id.progressBar);
        fAuth=FirebaseAuth.getInstance();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName=username.getText().toString().trim();
                String Password=password.getText().toString().trim();

                if(TextUtils.isEmpty(UserName)){
                    username.setError("UserName is Required.");
                    return;
                }

                if(TextUtils.isEmpty(Password)){
                    password.setError("Password is Required");
                    return;
                }
                if(Password.length()<6){
                    password.setError("Password Must be more than 6 Characters.");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }
}