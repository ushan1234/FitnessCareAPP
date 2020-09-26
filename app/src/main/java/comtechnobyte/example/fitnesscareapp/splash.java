package comtechnobyte.example.fitnesscareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    private  static int SPLASH_TIME_OUT=5000;

    View first,second,third,fourth,fifth,sixth;
    TextView a,textLine;

    //Animations
    Animation topAnimation,bottomAnimation,middleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        middleAnimation= AnimationUtils.loadAnimation(this,R.anim.middle_animation);

        //hooks
        first=findViewById(R.id.first_line);
        second=findViewById(R.id.second_line);
        third=findViewById(R.id.third_line);
        fourth=findViewById(R.id.fourth_line);
        fifth=findViewById(R.id.fifth_line);
        sixth=findViewById(R.id.sixth_line);

        a=findViewById(R.id.a);
        textLine=findViewById(R.id.textLine);

        first.setAnimation(topAnimation);
        second.setAnimation(topAnimation);
        third.setAnimation(topAnimation);
        fourth.setAnimation(topAnimation);
        fifth.setAnimation(topAnimation);
        sixth.setAnimation(topAnimation);

        a.setAnimation(middleAnimation);
        textLine.setAnimation(bottomAnimation);

        //Splash Screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(splash.this,Register.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);


    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}