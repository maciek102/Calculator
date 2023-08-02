package com.example.kalkulator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
    }

    protected void updateDisplay(String newString){
        if(getString(R.string.input).equals(display.getText().toString()))
            display.setText("");

        String currentDisplay = display.getText().toString();
        display.setText(currentDisplay + newString);
    }

    public void butZero(View view){
        updateDisplay("0");
    }
    public void butOne(View view){
        updateDisplay("1");
    }
    public void butTwo(View view){
        updateDisplay("2");
    }
    public void butThree(View view){
        updateDisplay("3");
    }
    public void butFour(View view){
        updateDisplay("4");
    }
    public void butFive(View view){
        updateDisplay("5");
    }
    public void butSix(View view){
        updateDisplay("6");
    }
    public void butSeven(View view){
        updateDisplay("7");
    }
    public void butEight(View view){
        updateDisplay("8");
    }
    public void butNine(View view){
        updateDisplay("9");
    }
    public void butMinus(View view){
        updateDisplay("-");
    }
    public void butDivide(View view){
        updateDisplay("÷");
    }
    public void butMultiply(View view){
        updateDisplay("×");
    }
    public void butSubtract(View view){
        updateDisplay("-");
    }
    public void butAdd(View view){
        updateDisplay("+");
    }
    public void butExponent(View view){
        updateDisplay("^");
    }
    public void butClear(View view){
        display.setText("");
    }
    public void butPoint(View view){
        updateDisplay(".");
    }

    public void butEquals(View view){
        String expression = display.getText().toString();

        expression = expression.replaceAll("÷","/");
        expression = expression.replaceAll("×","*");

        double result = ExpressionEvaluator.evaluateMathExpression(expression);

        if((int)result==result)
            display.setText(String.valueOf((int)result));
        else
            display.setText(String.valueOf((result)));
    }

}