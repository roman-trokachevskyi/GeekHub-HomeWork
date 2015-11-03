package com.rodico.duke0808.mygeekhub_homeworks.Browser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HW2Activity;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork1_Main;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork3;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork4.Hw4_activity;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork5.Hw5_activity;
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

        ListView listView = (ListView) findViewById(R.id.myHWView);
        init();
        SwingBottomInAnimationAdapter animationAdapter = new SwingBottomInAnimationAdapter(hwAdapter);
        animationAdapter.setAbsListView(listView);
        listView.setAdapter(animationAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HomeWorkItem item = (HomeWorkItem) parent.getItemAtPosition(position);
                if (item.getIntent()!=null) {
                    startActivity(item.getIntent());
                } else {
                    Toast.makeText(BrowserActivity.this, "Maybe next time...", Toast.LENGTH_SHORT).show();
                }
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
        myHWList.add(new HomeWorkItem("Home Work 4 (ООП)",this, Hw4_activity.class));
        myHWList.add(new HomeWorkItem("Home Work 5 (Anim & UI)",this, Hw5_activity.class));
        myHWList.add(new HomeWorkItem("Home Work 6 ",this, null));
        myHWList.add(new HomeWorkItem("Home Work 7 ",this, null));
        myHWList.add(new HomeWorkItem("Home Work 8 ",this, null));
        myHWList.add(new HomeWorkItem("Home Work 9 ",this, null));
        myHWList.add(new HomeWorkItem("Home Work 10 ",this, null));
        myHWList.add(new HomeWorkItem("Home Work 11 ",this, null));
        myHWList.add(new HomeWorkItem("Home Work 12 ",this, null));
        myHWList.add(new HomeWorkItem("Home Work 13 ",this, null));
        myHWList.add(new HomeWorkItem("Home Work 14 ",this, null));
        myHWList.add(new HomeWorkItem("Home Work 15 ",this, null));
        myHWList.add(new HomeWorkItem("Home Work 16 ",this, null));
        myHWList.add(new HomeWorkItem("Home Work 17 ",this, null));
        myHWList.add(new HomeWorkItem("Home Work 18 ",this, null));

        hwAdapter = new HwAdapter(myHWList,this);
    }

}
