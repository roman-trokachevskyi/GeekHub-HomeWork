package com.rodico.duke0808.mygeekhub_homeworks.Browser;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HW2Activity;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork1_Main;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork3;
import com.rodico.duke0808.mygeekhub_homeworks.R;

import java.util.ArrayList;
import java.util.List;

public class BrowserActivity extends AppCompatActivity {
    List<HomeWorkItem> myHWList;
    HwAdapter hwAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
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

        ListView listView = (ListView) findViewById(R.id.myHWView);
        init();
        listView.setAdapter(hwAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HomeWorkItem item = (HomeWorkItem) parent.getItemAtPosition(position);
                startActivity(item.getIntent());
            }
        });

    }

    public void init(){

        myHWList = new ArrayList<>();
        HomeWorkItem homeWorkItem1=new HomeWorkItem("Home Work 1",this,HomeWork1_Main.class);
        HomeWorkItem homeWorkItem2=new HomeWorkItem("Home Work 2",this,HW2Activity.class);
        myHWList.add(homeWorkItem1);
        myHWList.add(homeWorkItem2);
        myHWList.add(new HomeWorkItem("Home Work 3 (Collections)",this, HomeWork3.class));

        hwAdapter = new HwAdapter(myHWList,this);
    }

}
