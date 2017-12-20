package co.digitalvilla.mycalc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<String> display;
    // String displayMath;
    boolean negative;
    boolean decimalOn;
    boolean calcOn;
    String operator;
    // String math;
    float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //Set onlcick listeners
        initBtnId();
        //Link Text Views to diplay
        TextView tvResult = (TextView) findViewById(R.id.textViewTotal);
        TextView tvDisplay = (TextView) findViewById(R.id.textViewInput);
        // Link UI ImageButton
        ImageButton iBtnCalc = (ImageButton) findViewById(R.id.iBtnCalc);
        //Anonimus Inner Class
        iBtnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do final resolve and pass the last used operator
                resolve(operator);
                //Update UI 
                updateResultDisplay();
                calcOn = true;
                // displayMath = String.valueOf(result);
                
                //Carry over the final result
                display.add(String.valueOf(result));
            }
        });
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
            if (calcOn) init();
            switch (view.getId()) {
            case R.id.btn1:
                display.add("1");
                break;
            case R.id.btn2:
                display.add("2");
                break;
            case R.id.btn3:
                display.add("3");
                break;
            case R.id.btn4:
                display.add("4");
                break;
            case R.id.btn5:
                display.add("5");
                break;
            case R.id.btn6:
                display.add("6");
                break;
            case R.id.btn7:
                display.add("7");
                break;
            case R.id.btn8:
                display.add("8");
                break;
            case R.id.btn9:
                display.add("9");
                break;
            case R.id.btn0:
                display.add("0");
                break;
            //--OPERATIONS---//
            case R.id.btnDel:
                display.remove(display.size() - 1);
                break;
            case R.id.btnDot:
                if (!decimalOn) {
                    display.add(".");
                    decimalOn = true;
                }
                break;
            case R.id.btnNeg:
                negative = !negative;
                if (negative) {
                    display.add(0, "-");
                } else {
                    display.remove(0);
                }
                break;
            }
            updateResultDisplay();
        }
    };

    private void resolve(String sign) {
        float value = Float.parseFloat(getValue());
        if (operator.equals("")) {
            result = value;
            operator = sign;
        } else {
            float number = value;
            switch (operator) {
            case "*":
                result *= number;
                break;
            case "+":
                result += number;
                break;
            case "-":
                result -= number;
                break;
            case "m":
                result %= number;
                break;
            case "%":
                result = result / 100 * number;
                break;
            case "/":
                if (number != 0) {
                    result /= number;
                } else {
                    // print error 
                }
                break;
            }

        }
        decimalOn = false;
        negative = false;

    }

    private String getValue() {
        String n = (negative == true) ? "-" : "";
        for (int i = 0; i < display.size(); i++) {
            char c = display.get(i).charAt(0);
            if (Character.isDigit(c) || c == '.') {
                n += c;
            }
        }
        display.clear();
        return n;
    }

    private void updateResultDisplay() {
        if (display.size() == 0) {
            // display = result

        } else {
            //print getvalue
            getValue();
        }
    }

    private void init() {
        display = new ArrayList<String>();
        // displayMath = "";
        negative = false;
        decimalOn = false;
        calcOn = false;
        operator = "";
        // math = "";
        result = 0;

        //reset display
        //reset result
    }

}
