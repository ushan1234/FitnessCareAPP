package comtechnobyte.example.fitnesscareapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {




    EditText FullName,Email,Date,Password,Repassword;
    Button register;
    FirebaseAuth fAuth;
    ProgressBar progressbar;
    TextView Loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FullName= findViewById(R.id.Name);
        Email=findViewById(R.id.Email);
        Date=findViewById(R.id.Date);
        Password=findViewById(R.id.Pwd);
        Repassword=findViewById(R.id.Rpwd);
        register=findViewById(R.id.Rbtn);
        Loginbtn=findViewById(R.id.textView3);

        fAuth= FirebaseAuth.getInstance();
        progressbar=findViewById(R.id.progressBar2);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=Email.getText().toString().trim();
                String password=Password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    Email.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Password.setError("Password is Required");
                    return;
                }
                if(password.length()<6){
                    Password.setError("Password Must be more than 6 Characters.");
                    return;
                }
                progressbar.setVisibility(View.VISIBLE);

                //register the user in firebase

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(Register.this,"User Created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Das.class));
                        }
                        else{
                            Toast.makeText(Register.this, "Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressbar.setVisibility(View.GONE);
                        }

                    }
                });
            }
        });

        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));

            }
        });
    }
}