package co.digitalvilla.mycalc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity {
    // String displayMath;
    ArrayList<String> runningNumber;
    TextView tvResult;
    TextView tvDisplay;

    boolean decimalOn;
    boolean negative;
    boolean doMath;
    boolean calcOn;

    String operator;
    String math;

    float leftValue;
    float rightValue;
    float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Link Text Views to diplay
        tvResult = (TextView) findViewById(R.id.textViewTotal);
        tvDisplay = (TextView) findViewById(R.id.textViewInput);
        //Set onlcick listeners
        initBtnId();
        // Link UI ImageButton
        ImageButton iBtnCalc = (ImageButton) findViewById(R.id.iBtnCalc);
        //Anonimus Inner Class
        iBtnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do final resolve and pass the last used operator
                calcOn = true;
                resolve("=");
                // verify that equals wass pressed
                //Carry over the final result
                runningNumber.add(String.valueOf(result));

            }
        });
        init();
    }

    //--OPERATIONS---//
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
            case R.id.btnAc:
                init();
                break;
            case R.id.btnPlus:
                resolve("+");
                break;
            case R.id.btnMinus:
                resolve("-");
                break;
            case R.id.btnMulti:
                resolve("*");
                break;
            case R.id.btnDiv:
                resolve("/");
                break;
            case R.id.btnCent:
                resolve("%");
                break;
            case R.id.btnMod:
                resolve("m");
                break;
            }
        }
    };

    //--Values---//
    private View.OnClickListener buttonClickListenerN = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (calcOn)
                init();
            switch (view.getId()) {
            case R.id.btn1:
                runningNumber.add("1");
                break;
            case R.id.btn2:
                runningNumber.add("2");
                break;
            case R.id.btn3:
                runningNumber.add("3");
                break;
            case R.id.btn4:
                runningNumber.add("4");
                break;
            case R.id.btn5:
                runningNumber.add("5");
                break;
            case R.id.btn6:
                runningNumber.add("6");
                break;
            case R.id.btn7:
                runningNumber.add("7");
                break;
            case R.id.btn8:
                runningNumber.add("8");
                break;
            case R.id.btn9:
                runningNumber.add("9");
                break;
            case R.id.btn0:
                runningNumber.add("0");
                break;
            //--OPERATIONS---//
            case R.id.btnDel:
                if (runningNumber.size() > 0)
                    runningNumber.remove(runningNumber.size() - 1);
                break;
            case R.id.btnDot:
                if (!decimalOn) {
                    if (runningNumber.size() > 0) {
                        runningNumber.add(".");
                    } else {
                        runningNumber.add("0");
                        runningNumber.add(".");
                    }
                    decimalOn = true;
                }
                break;
            case R.id.btnNeg:
                if (runningNumber.size() > 0) {
                    negative = !negative;
                    if (negative) {
                        runningNumber.add(0, "-");
                    } else {
                        runningNumber.remove(0);
                    }
                    break;
                }
            }
            updateResultDisplay(getValue());
        }
    };

    private void resolve(String op) {
        if (runningNumber.size() > 0) {
            //togle operation 
            if (!doMath) {
                if (calcOn) {
                    leftValue = result;
                } else {
                    leftValue = getValue();
                    operator = op;
                }
                doMath = true;
            } else {
                rightValue = getValue();
                switch (operator) {
                case "*":
                    result = leftValue * rightValue;
                    break;
                case "+":
                    result = leftValue + rightValue;
                    break;
                case "-":
                    result = leftValue - rightValue;
                    break;
                case "m":
                    result = leftValue % rightValue;
                    break;
                case "%":
                    result = leftValue / 100 * rightValue;
                    break;
                case "/":
                    if (rightValue != 0) {
                        result = leftValue / rightValue;
                    } else {
                        // print error
                        tvResult.setText("Error: Division by 0");
                    }
                    break;
                }

                updateResultDisplay(result);

                if (!op.equals("=")) {
                    operator = op;
                }

                doMath = false;
            }
            updateMathDisplay(getValue(), operator);
            runningNumber.clear();
            decimalOn = false;
            negative = false;
        }
    }

    private float getValue() {
        int s = runningNumber.size();
        if (s == 0) {
            return 0;
        }
        // String n = (negative == true) ? "-" : "";
        String n = "";
        for (int i = 0; i < s; i++) {
            char c = runningNumber.get(i).charAt(0);
            n += c;
        }
        if (n.equals("0.")) {
            n = "0.000001";
        }
        return Float.parseFloat(n);
    }

    private void updateMathDisplay(float value, String sign) {
        String pattern = (value == Math.floor(value)) ? "%.0f" : "%.2f";
        math += String.format(pattern, value) + " " + sign + " ";
        //Verify if iBtnCalc is pressed
        if (calcOn)
            math = result + " ";
        tvDisplay.setText(math);
    }

    private void updateResultDisplay(float result) {
        String strResult = String.valueOf(result);

        int indx = strResult.indexOf(".");
        int decimals = 0;

        for (int i = indx  + 1; i < strResult.length(); i++) {
            if (strResult.charAt(i) != '0') {
                decimals = i - indx;
            }
        }
        decimals = (decimals > 6)? 6:decimals;

        String pattern = (result == Math.floor(result))?"%13.0f":"%13."+decimals+"f";
        tvResult.setText(String.format(pattern, result));
        //Test for a float without decimals and not infinite
        // (result == Math.floor(result)) && !Float.isInfinite(result)) 
    }

    private void init() {
        runningNumber = new ArrayList<String>();
        // displayMath = "";
        rightValue = 0;
        leftValue = 0;
        negative = false;
        doMath = false;
        decimalOn = false;
        calcOn = false;
        operator = "";
        math = "";
        result = 0;

        //reset runningNumber
        tvDisplay.setText("Calculator");
        //reset result
        tvResult.setText("0");
    }

    public void initBtnId() {
        // Link UI value buttons
        findViewById(R.id.btn1).setOnClickListener(buttonClickListenerN);
        findViewById(R.id.btn2).setOnClickListener(buttonClickListenerN);
        findViewById(R.id.btn3).setOnClickListener(buttonClickListenerN);
        findViewById(R.id.btn4).setOnClickListener(buttonClickListenerN);
        findViewById(R.id.btn5).setOnClickListener(buttonClickListenerN);
        findViewById(R.id.btn6).setOnClickListener(buttonClickListenerN);
        findViewById(R.id.btn7).setOnClickListener(buttonClickListenerN);
        findViewById(R.id.btn8).setOnClickListener(buttonClickListenerN);
        findViewById(R.id.btn9).setOnClickListener(buttonClickListenerN);
        findViewById(R.id.btn0).setOnClickListener(buttonClickListenerN);
        //Value foramters buttons
        findViewById(R.id.btnDel).setOnClickListener(buttonClickListenerN);
        findViewById(R.id.btnDot).setOnClickListener(buttonClickListenerN);
        findViewById(R.id.btnNeg).setOnClickListener(buttonClickListenerN);
        // Link UI operation buttons
        findViewById(R.id.btnAc).setOnClickListener(buttonClickListener);
        findViewById(R.id.btnMod).setOnClickListener(buttonClickListener);
        findViewById(R.id.btnCent).setOnClickListener(buttonClickListener);
        findViewById(R.id.btnDiv).setOnClickListener(buttonClickListener);
        findViewById(R.id.btnMulti).setOnClickListener(buttonClickListener);
        findViewById(R.id.btnMinus).setOnClickListener(buttonClickListener);
        findViewById(R.id.btnPlus).setOnClickListener(buttonClickListener);
    }

}
