package co.digitalvilla.mycalc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI number buttons
        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        Button btn4 = (Button) findViewById(R.id.button4);
        Button btn5 = (Button) findViewById(R.id.button5);
        Button btn6 = (Button) findViewById(R.id.button6);
        Button btn7 = (Button) findViewById(R.id.button7);
        Button btn8 = (Button) findViewById(R.id.button8);
        Button btn9 = (Button) findViewById(R.id.button9);
        Button btn0 = (Button) findViewById(R.id.button0);
        // Link UI operation buttons
        Button btnAc = (Button) findViewById(R.id.buttonClear);
        Button btnDel = (Button) findViewById(R.id.buttonDelete);
        Button btnMod = (Button) findViewById(R.id.buttonModulous);
        Button btnCent = (Button) findViewById(R.id.buttonPercent);
        Button btnDiv = (Button) findViewById(R.id.buttonDivide);
        Button btnMulti = (Button) findViewById(R.id.buttonMultiply);
        Button btnMinus = (Button) findViewById(R.id.buttonMinus);
        Button btnPlus = (Button) findViewById(R.id.buttonPlus);
        Button btnDot= (Button) findViewById(R.id.buttonDecimal);
        Button btnNeg = (Button) findViewById(R.id.buttonNegative);
        // Link UI ImageButton
        ImageButton btnCalc = (ImageButton) findViewById(R.id.imageButtonEquals);
        //Link Text Views to diplay
        TextView tvResult = (TextView) findViewById(R.id.textViewTotal);
        TextView tvDisplay = (TextView) findViewById(R.id.textViewInput);
        //Set onlcick listeners




    }















}
