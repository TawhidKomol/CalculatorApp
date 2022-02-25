package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    TextView primaryView, secondaryView;
    double number1,number2,result;
    double memory, tempResult = 0;
    String operator;

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

    // Operation Button Click
    public void operationFunction(View view) {
        String primaryValue = primaryView.getText().toString();

        if (view.getId() == R.id.addition_btnID) {
            operator = "+";
        } else if (view.getId() == R.id.subtraction_btnID) {
            operator = "-";
        } else if (view.getId() == R.id.multi_btnID) {
            operator = "*";
        } else {
            operator = "/";
        }
        secondaryView.setText("" + primaryValue + " " + operator);
        primaryView.setText("0");
        number1 = Double.parseDouble(primaryValue);

    }

    // Result Button Click
    public void resultFunction(View view) {
        String primaryValue = primaryView.getText().toString();
        number2 = Double.parseDouble(primaryValue);

        if (operator.equals("+")) {
            result = number1 + number2;
        } else if (operator.equals("-")) {
            result = number1 - number2;
        } else if (operator.equals("*")) {
            result = number1 * number2;
        } else {
            result = number1 / number2;
        }
        secondaryView.setText(number1 + operator + number2 + " ");
        primaryView.setText("" + result);
    }

    // Clear Function
    public void clearFunction(View view) {
        secondaryView.setText("");
        primaryView.setText("");
        number1 = 0.0;
        number2 = 0.0;
        result = 0.0;
        operator = "";
    }

    // Add Decimal Button Click
    public void addDecimal(View sender) {
        String display = primaryView.getText().toString();

        //if display includes a symbol other than an integer, return
        if (isEquationSymbol(sender, display)) {
            return;
        }
        //if decimal is first item being added, append 0
        else if (primaryView.getText().toString().equals("")) {
            primaryView.setText("0.");
            return;
        }

        double currNum = Double.parseDouble(primaryView.getText().toString());
        //if there's already a decimal, return
        if (primaryView.getText().toString().indexOf(".") != -1) {
            return;
        } else {
            primaryView.append(".");
        }
    }

    public boolean isEquationSymbol(View sender, String str) {
        String[] operators = {"+", "-", "*", "/"};
        for (int i = 0; i < operators.length; i++) {
            if (str.contains(operators[i])) {
                return true;
            }
        }
        return false;
    }

    // Back Function Click
    public void backFunction(View view) {

        String s = primaryView.getText().toString();
        if (s.length() != 0) {
            s = s.substring(0, s.length() - 1);
            primaryView.setText(s);
        }

    }

    // Zero Button Click
    public void zeroFunction(View view) {
        String s = primaryView.getText().toString();
        if (s.length() != 0) {
            primaryView.setText(s + "0");
        }
    }

    // Percent Button Click
    public void percentFunction(View view) {
        double no = Double.parseDouble(primaryView.getText().toString()) / 100;
        primaryView.setText(no + "");
    }


    //commit number currently on screen to memory
    public void changeMemory(View sender) {
        //if display is empty, return and commit nothing to memory
        if (primaryView.getText().toString().equals("")) {
            return;
        }

        Button bt = (Button) sender;
        String command = bt.getText().toString();
        String displayText = primaryView.getText().toString();
        if (command.equals("M+")) { //add value to memory
            if (displayText.contains("+") && displayText.indexOf("=") == -1) {   //use this case if the output is showing full equation
                return;
            } else if (displayText.indexOf("=") != -1) { //if a full equation, add tempResult to memory then reset
                memory += tempResult;
                tempResult = 0;
            } else {
                memory += Double.parseDouble(displayText);
            }


        } else { //subtract value from memory
            if (displayText.indexOf("+") != -1 && displayText.indexOf("=") == -1) {   //use this case if the output is showing full equation
                return;
            } else if (displayText.indexOf("=") != -1) {
                memory -= tempResult;
                tempResult = 0;

            } else {
                memory -= Double.parseDouble(displayText);
            }

        }
    }

    //show the current memory value
    public void showMemory(View sender) {
        primaryView.setText(memory + "");
    }

    //reset memory value to 0
    public void clearMemory(View sender) {
        memory = 0;
    }
}