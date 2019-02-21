package com.example.abdelrahman.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView operationSignTV, resultTV;
    EditText firstNumberET, secondNumberET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operationSignTV = findViewById(R.id.operation_sign);
        firstNumberET = findViewById(R.id.num_1);
        secondNumberET = findViewById(R.id.num_2);
        resultTV = findViewById(R.id.result);
    }

    public void add(View view) {
        setOperationSign("+");
    }

    public void sub(View view) {
        setOperationSign("-");
    }

    public void div(View view) {
        setOperationSign("/");
    }

    public void mul(View view) {
        setOperationSign("*");
    }

    private void setOperationSign(String sign) {
        operationSignTV.setText(sign);
    }

    public void equal(View view) {

        double fNum, sNum, result = 0;

        // Check if the first EditText is empty and show error message if so.
        if (firstNumberET.getText() == null || firstNumberET.getText().equals("")) {
            firstNumberET.setError("Can't be empty!");
            return; // because it's invalid operation.
        } else {
            fNum = Double.valueOf(firstNumberET.getText().toString());
        }

        // Check if the second EditText is empty and show error message if so.
        if (secondNumberET.getText() == null || secondNumberET.getText().equals("")) {
            secondNumberET.setError("Can't be empty!");
            return; // because it's invalid operation.
        } else {
            sNum = Double.valueOf(secondNumberET.getText().toString());
        }

        // Check if the user set the operation and make Toast message if not.
        if (operationSignTV.getText().equals("")) {
            Toast.makeText(this, "Invalid Operation!", Toast.LENGTH_LONG).show();
        } else {
            // Do the operation
            char operation = operationSignTV.getText().toString().charAt(0);
            switch (operation) {
                case '+':
                    result = fNum + sNum;
                    break;
                case '-':
                    result = fNum - sNum;
                    break;
                case '/':
                    result = fNum / sNum;
                    break;
                case '*':
                    result = fNum * sNum;
                    break;
            }
            setResult(result);
        }

    }

    private void setResult(double result) {
        resultTV.setText(String.valueOf(result));
    }
}
