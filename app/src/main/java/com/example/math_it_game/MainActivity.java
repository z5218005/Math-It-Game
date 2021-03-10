package com.example.math_it_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView randomNum1, randomNum2, result, randomOperator, score, showAnswer;

    EditText userInput;

    int scoreCounter;

    private static final long START_TIME_IN_MILLIS = 600000;

    private TextView mTextViewCountDown;

    private Button mButtonStartPause, mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;



    String randomSign;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNum1 = findViewById(R.id.randomNumberOne);
        randomNum2 = findViewById(R.id.randomNumberTwo);
        result = findViewById(R.id.result);
        randomOperator = findViewById(R.id.randomOperator);
        score = findViewById(R.id.score);
        showAnswer = findViewById(R.id.showAnswer);
        userInput = (EditText) findViewById(R.id.userInput);

        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mButtonStartPause = findViewById(R.id.button_start_pause);

        mButtonReset = findViewById(R.id.button_reset);

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }

            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();

            }
        });

        updateCountDownText();
        run_reset();

    }

    private void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);

            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("Pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer(){
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer(){
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60; // return what is left after calculating minutes

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds); //convert to time string

        mTextViewCountDown.setText(timeLeftFormatted);
    }

public void run_reset(){
    Random myRandom = new Random();
    Random randInt = new Random();

    int num1 = myRandom.nextInt(101);
    int num2 = myRandom.nextInt(101);
    String[] signs = {"+", "-", "×", "÷"};
    int randomIndex = randInt.nextInt(signs.length);
    randomSign = signs[randomIndex];

    randomNum1.setText(""+num1);
    randomNum2.setText(""+num2);
    randomOperator.setText(""+ randomSign);
    result.setText("Result");
    userInput.setText("");


        }


    public void clear(View view) {
        run_reset();

    }

    public void enter(View view) {
        int num1 = Integer.parseInt(randomNum1.getText().toString());
        int num2 = Integer.parseInt(randomNum2.getText().toString());
        double get_user_answer = Double.parseDouble(userInput.getText().toString());
        double answer = 0;
        String disAns;

        switch(randomSign) {
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "÷":
                answer = num1 / (double) num2;
                answer = Math.round(answer * 100.00) / 100.00;
                break;
            case "×":
                answer = num1 * num2;

        }

        if (answer == get_user_answer){
            result.setText("Correct!");
            scoreCounter++;

        }else{
            result.setText("Incorrect");
            scoreCounter--;
        }
        score.setText(""+scoreCounter);
        disAns = String.valueOf(answer);
        showAnswer.setText(disAns);



    }

}