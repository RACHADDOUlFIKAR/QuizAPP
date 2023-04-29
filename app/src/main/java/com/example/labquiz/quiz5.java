package com.example.labquiz;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class quiz5 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button bNext;
    int score ;
    String RepCorrect = "Italie";
    TextView countdownTextView;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);

        rg = (RadioGroup) findViewById(R.id.rg);
        bNext = (Button) findViewById(R.id.bNext);
        countdownTextView = (TextView) findViewById(R.id.countdownTextView);
        Intent intent=getIntent();
        score=intent.getIntExtra("score",0);
        // Set up the countdown timer
        countDownTimer = new CountDownTimer(15000, 1000) { // 30 seconds
            public void onTick(long millisUntilFinished) {
                countdownTextView.setText("Temps restant: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                countdownTextView.setText("Temps écoulé!");
                Intent intent1 = new Intent(quiz5.this, score.class);
                startActivity(intent1);
            }
        };

        // Start the countdown timer
        countDownTimer.start();

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void checkAnswer() {
        // Stop the countdown timer
        countDownTimer.cancel();

        if (rg.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Merci de choisir une réponse S.V.P !", Toast.LENGTH_SHORT).show();
        } else {
            rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            //Toast.makeText(getApplicationContext(),rb.getText().toString(),Toast.LENGTH_SHORT).show();
            if (rb.getText().toString().equals(RepCorrect)) {
                score += 1;
                //Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(quiz5.this, score.class);
            intent.putExtra("score", score);
            startActivity(intent);
            overridePendingTransition(R.anim.exit, R.anim.entry);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        // Stop the countdown timer when the user presses the back button
        countDownTimer.cancel();
        super.onBackPressed();
    }
}