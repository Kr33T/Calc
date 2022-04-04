package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.TypeConverter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView firstNumber;
    TextView sign;
    TextView secondNumber;
    TextView eq;
    TextView result;

    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button root;
    Button degree;
    Button sin;
    Button cos;
    Button clear;
    Button equals;
    Button transition;

    String act;
    boolean fnum;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        act = "";
        fnum = true;

        firstNumber = findViewById(R.id.firstNumber);
        sign = findViewById(R.id.sign);
        secondNumber = findViewById(R.id.secondNumber);
        eq = findViewById(R.id.eq);
        result = findViewById(R.id.result);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        root = findViewById(R.id.root);
        degree = findViewById(R.id.degree);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);
        transition = findViewById(R.id.transition);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        root.setOnClickListener(this);
        degree.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        clear.setOnClickListener(this);
        equals.setOnClickListener(this);
        transition.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.transition:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
                if (!fnum && firstNumber.getText() == "") {
                    fnum = !fnum;
                }
                Button button = (Button) view;
                String numText;
                if (fnum) {
                    numText = firstNumber.getText().toString();
                    numText += button.getText().toString();
                    firstNumber.setText(numText);
                } else {
                    numText = secondNumber.getText().toString();
                    numText += button.getText().toString();
                    secondNumber.setText(numText);
                }
                break;
            case R.id.root:
            case R.id.degree:
            case R.id.sin:
            case R.id.cos:
                Button button1 = (Button) view;
                x = view.getId();
                switch (x) {
                    case R.id.root:
                        sign.setText("√");
                        break;
                    case R.id.degree:
                        sign.setText("^");
                        break;
                    case R.id.sin:
                        sign.setText("s");
                        break;
                    case R.id.cos:
                        sign.setText("c");
                        break;
                }
                if (act == button1.getText().toString()) {
                    act = button1.getText().toString();
                    if (!fnum) {
                        fnum = !fnum;
                    }
                } else {
                    fnum = !fnum;
                }
                break;
            case R.id.clear:
                firstNumber.setText("");
                sign.setText("");
                secondNumber.setText("");
                eq.setText("");
                result.setText("");
                break;
            case R.id.equals:

                double res;
                eq.setText("=");
                switch (x) {
                    case R.id.root:
                        float num1 = Float.valueOf(firstNumber.getText().toString());
                        float num2 = Float.valueOf(secondNumber.getText().toString());
                        res = Math.pow(num2, 1 / num1);
                        result.setText(String.valueOf(res));
                        break;
                    case R.id.degree:
                        float num3 = Float.valueOf(firstNumber.getText().toString());
                        float num4 = Float.valueOf(secondNumber.getText().toString());
                        res = Math.pow(num3, num4);
                        result.setText(String.valueOf(res));
                        break;
                    case R.id.sin:
                        float num5 = Float.valueOf(firstNumber.getText().toString());
                        res = Math.sin(Math.toRadians(num5));
                        result.setText(String.valueOf(res));
                        break;
                    case R.id.cos:
                        float num6 = Float.valueOf(firstNumber.getText().toString());
                        res = Math.cos(Math.toRadians(num6));
                        result.setText(String.valueOf(res));
                        break;
                }
                fnum = !fnum;
                break;
        }
    }
}