package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView primaryView, secondaryView;
    double number1,number2,result;
    double memory, tempResult = 0;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primaryView=findViewById(R.id.primary_viewId);
        secondaryView=findViewById(R.id.secondary_viewId);
    }

    public void numberFunction(View view) {
        String primaryValue =primaryView.getText().toString();

                if(primaryValue.equals("0")){
        if (view.getId() == R.id.zero_btnID) {
            primaryView.setText("0");
        } else if (view.getId() == R.id.one_btnID) {
            primaryView.setText("1");
        } else if (view.getId() == R.id.two_btnID) {
            primaryView.setText("2");
        } else if (view.getId() == R.id.three_btnID) {
            primaryView.setText("3");
        } else if (view.getId() == R.id.four_btnID) {
            primaryView.setText("4");
        } else if (view.getId() == R.id.five_btnID) {
            primaryView.setText("5");
        } else if (view.getId() == R.id.six_btnID) {
            primaryView.setText("6");
        } else if (view.getId() == R.id.seven_btnID) {
            primaryView.setText("7");
        } else if (view.getId() == R.id.eight_btnID) {
            primaryView.setText("8");
        } else {
            primaryView.setText("9");
        }
    }
                else{
                    if (view.getId() == R.id.zero_btnID) {
                        primaryView.setText(primaryValue+"0");
                    } else if (view.getId() == R.id.one_btnID) {
                        primaryView.setText(primaryValue+"1");
                    } else if (view.getId() == R.id.two_btnID) {
                        primaryView.setText(primaryValue+"2");
                    } else if (view.getId() == R.id.three_btnID) {
                        primaryView.setText(primaryValue+"3");
                    } else if (view.getId() == R.id.four_btnID) {
                        primaryView.setText(primaryValue+"4");
                    } else if (view.getId() == R.id.five_btnID) {
                        primaryView.setText(primaryValue+"5");
                    } else if (view.getId() == R.id.six_btnID) {
                        primaryView.setText(primaryValue+"6");
                    } else if (view.getId() == R.id.seven_btnID) {
                        primaryView.setText(primaryValue+"7");
                    } else if (view.getId() == R.id.eight_btnID) {
                        primaryView.setText(primaryValue+"8");
                    } else {
                        primaryView.setText(primaryValue+"9");
                    }
                }

    }

    public void operationFunction(View view) {
        String primaryValue=primaryView.getText().toString();
        if(view.getId()==R.id.addition_btnID){
            operation="+";
        }
        else if(view.getId()==R.id.subtraction_btnID){
            operation="-";
        }
        else if(view.getId()==R.id.multi_btnID){
            operation="*";
        }
        else{
            operation="/";
        }
        secondaryView.setText(""+primaryValue+" "+operation);
        primaryView.setText("0");
        number1=Double.parseDouble(primaryValue);
    }

    public void resultFunction(View view) {
        String primaryValue = primaryView.getText().toString();
        number2=Double.parseDouble(primaryValue);

        if(operation.equals("+")){
            result=number1+number2;
        }
        else if(operation.equals("-")){
            result=number1-number2;
        }
        else if(operation.equals("*")){
            result=number1*number2;
        }
        else{
            result=number1/number2;
        }

        secondaryView.setText(number1+operation+number2+" ");
        primaryView.setText(""+result);

    }

    public void clearFunction(View view) {
        secondaryView.setText("");
        primaryView.setText("0");
        number2=0.0;
        number1=0.0;
    }
}