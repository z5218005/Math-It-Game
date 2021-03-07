package com.example.math_it_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView randomNum1, randomNum2, result, randomOperator, displayAnswer;

    EditText userInput;


    Button submitButton, clearButton;

    String randomSign;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNum1 = findViewById(R.id.randomNumberOne);
        randomNum2 = findViewById(R.id.randomNumberTwo);
        result = findViewById(R.id.result);
        displayAnswer = findViewById(R.id.displayAnswer);
        randomOperator = findViewById(R.id.randomOperator);
        userInput = (EditText) findViewById(R.id.userInput);


        //submitButton = (Button) findViewById(R.id.enterButton);


        run_reset();

    }

public void run_reset(){
    Random myRandom = new Random();
    Random randInt = new Random();

    int num1 = myRandom.nextInt(101);
    int num2 = myRandom.nextInt(101);
    String[] signs = {"+", "-", "×", "÷"};
    int randomIndex = randInt.nextInt((signs.length - 0 + 1) + 0);
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

        double answer;
        switch(randomSign){
            case "+":
                answer = num1 + num2;
                String disAns1 = String.valueOf(answer);
                if (answer == get_user_answer){
                    result.setText("Correct!");
                    displayAnswer.setText(disAns1);


                }

                else {
                    result.setText("Incorrect");
                    displayAnswer.setText(disAns1);

                }

                break;
            case "-":
                answer = num1 - num2;
                String disAns2 = String.valueOf(answer);

                if (answer == get_user_answer){
                    result.setText("Correct!");
                    displayAnswer.setText(disAns2);


                }
                else {
                    result.setText("Incorrect");
                    displayAnswer.setText(disAns2);

                }
            case "÷":
                answer = num1 / (double) num2;
                double answer2dp = (double) Math.round(answer *100 )/100;
                String disAns3 = String.valueOf(answer2dp);

                if (answer2dp == get_user_answer){
                    result.setText("Correct!");
                    displayAnswer.setText(disAns3);

                }
                else {
                    result.setText("Incorrect");
                    displayAnswer.setText(disAns3);

                }
            case "×":
                answer = num1 * num2;
                String disAns4 = String.valueOf(answer);

                if (answer == get_user_answer){
                    result.setText("Correct!");
                    displayAnswer.setText(disAns4);


                }
                else {
                    result.setText("Incorrect");
                    displayAnswer.setText(disAns4);

                }
        }

        /**submitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        answer = Integer.valueOf(answerInput.getText().toString());
        }
        }**/







    }
}