package com.example.math_it_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView randomNum1, randomNum2, result, randomOperator, score, showAnswer;

    EditText userInput;

    int scoreCounter;


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


        run_reset();

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