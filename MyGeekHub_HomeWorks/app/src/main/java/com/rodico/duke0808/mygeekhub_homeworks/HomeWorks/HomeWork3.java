package com.rodico.duke0808.mygeekhub_homeworks.HomeWorks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rodico.duke0808.mygeekhub_homeworks.R;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class HomeWork3 extends AppCompatActivity {

    private String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
            "Blackberry", "Ubuntu", "Windows7", "Mac OS X", "Linux", "Ubuntu",
            "Windows7", "Mac OS X", "Linux", "Ubuntu", "Windows7", "Android",
            "iPhone", "WindowsMobile" };
    TextView resTv;
    String[] valRecovery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work3);
        TextView tv1 = (TextView) findViewById(R.id.arrayTv);
        resTv = (TextView) findViewById(R.id.resTv);
        Button reverseBt = (Button) findViewById(R.id.reverseBt);
        Button sortBt = (Button) findViewById(R.id.sortBt);
        Button n3Bt = (Button) findViewById(R.id.n3delBt);
        Button uniqBt = (Button) findViewById(R.id.qBt);
        tv1.setText("");
        for (String s : values){
            tv1.setText(tv1.getText()+s+", ");
        }
        valRecovery = new String[values.length];
        for (int i=0;i<values.length;i++){
            valRecovery[i]=values[i];
        }
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.reverseBt:
                valuesRecover();
                resTv.setText("");
                for (int i=values.length-1; i>0;i--){
                    resTv.setText(resTv.getText()+values[i]+", ");
                }
                resTv.setText(resTv.getText()+values[0]);
                break;
            case R.id.sortBt:
                valuesRecover();
                resTv.setText("");
                Arrays.sort(values);
                for (int i=0;i<values.length-1;i++){
                    resTv.setText(resTv.getText()+values[i]+", ");
                }
                resTv.setText(resTv.getText()+values[values.length-1]);
                break;
            case R.id.n3delBt:
                valuesRecover();
                resTv.setText("");
                LinkedList<String> list = new LinkedList<>();
                for (int i=0;i<values.length;i++){
                    if ((i+1)%3!=0){
                        list.add(values[i]);
                    }
                }
                for (int i=0;i<list.size()-1;i++){
                    resTv.setText(resTv.getText()+list.get(i)+", ");
                }
                resTv.setText(resTv.getText()+list.get(list.size() - 1));
                break;
            case R.id.qBt:
                valuesRecover();
                resTv.setText("");
                LinkedHashSet<String> set = new LinkedHashSet<>();
                String res = "";
                for (int i=0;i<values.length-1;i++){
                    if (!set.contains(values[i])){
                        set.add(values[i]);
                        res+=values[i]+", ";
                    }
                }
                if (!set.contains(values[values.length-1])){
                    set.add(values[values.length-1]);
                    res+=values[values.length-1];
                }
                resTv.setText(res);
                break;
        }
    }
    private void valuesRecover(){
        for (int i=0;i<values.length;i++){
            values[i]=valRecovery[i];
        }
    }
}
