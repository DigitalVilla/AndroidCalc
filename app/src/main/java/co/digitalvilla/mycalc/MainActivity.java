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
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button btn0 = (Button) findViewById(R.id.btn0);
        // Link UI operation buttons
        Button btnAc = (Button) findViewById(R.id.btnAc);
        Button btnDel = (Button) findViewById(R.id.btnDel);
        Button btnMod = (Button) findViewById(R.id.btnMod);
        Button btnCent = (Button) findViewById(R.id.btnCent);
        Button btnDiv = (Button) findViewById(R.id.btnDiv);
        Button btnMulti = (Button) findViewById(R.id.btnMulti);
        Button btnMinus = (Button) findViewById(R.id.btnMinus);
        Button btnPlus = (Button) findViewById(R.id.btnPlus);
        Button btnDot= (Button) findViewById(R.id.btnDot);
        Button btnNeg = (Button) findViewById(R.id.btnNeg);
        // Link UI ImageButton
        ImageButton iBtnCalc = (ImageButton) findViewById(R.id.iBtnCalc);
        //Link Text Views to diplay
        TextView tvResult = (TextView) findViewById(R.id.textViewTotal);
        TextView tvDisplay = (TextView) findViewById(R.id.textViewInput);
        //Set onlcick listeners




    }















}
