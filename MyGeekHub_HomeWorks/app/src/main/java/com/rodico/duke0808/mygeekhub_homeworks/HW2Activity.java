package com.rodico.duke0808.mygeekhub_homeworks;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rodico.duke0808.mygeekhub_homeworks.R;

import java.math.BigInteger;
import java.util.ArrayList;

public class HW2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button factBT = (Button) findViewById(R.id.factBT);
        Button fibonBT = (Button) findViewById(R.id.fibonBT);
        final EditText eT = (EditText) findViewById(R.id.editText2);
        final TextView tV = (TextView) findViewById(R.id.textView2);
        final MathClass mathClass = MathClass.getMathClass();
        factBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sGot = eT.getText().toString();
                if (sGot!=""&&!sGot.equals("")&&sGot!=null){
                    if (mathClass.isDigit(sGot)) {
                        BigInteger res = mathClass.factorial(Integer.parseInt(sGot));
                        String resS = res.toString();
                        tV.setText(String.valueOf(resS));
                    } else {
                        tV.setText("type int value pls...");
                    }
                } else {
                    tV.setText("type smth pls...");
                }
            }
        });
        fibonBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sGot = eT.getText().toString();
                if (sGot!=""&&!sGot.equals("")&&sGot!=null){
                    if (mathClass.isDigit(sGot)) {
                        int res = mathClass.fibonachi(Integer.parseInt(sGot));
                        String resS = String.valueOf(res);
                        tV.setText(String.valueOf(resS));
                    } else {
                        tV.setText("type int value pls...");
                    }
                } else {
                    tV.setText("type smth pls...");
                }
            }
        });

    }

    static class MathClass{
        public static final MathClass mathClass;
        static {
            mathClass = new MathClass();
        }

        private static MathClass getMathClass() {
            return mathClass;
        }

        BigInteger factorial(int n){
            BigInteger res = BigInteger.valueOf(1);
            for (int i=1;i<=n;i++){
                res=res.multiply(BigInteger.valueOf(i));
            }
            return res;
        }

        int fibonachi(int n){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            int a = 1, b = 1;
            int fib = 2, i = 2;
            while (i <= n) {
                fib = a + b;
                a = b;
                b = fib;
                list.add(b);
                i++;
            }

            return list.get(n);
        }

        private boolean isDigit(String s){
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

}
