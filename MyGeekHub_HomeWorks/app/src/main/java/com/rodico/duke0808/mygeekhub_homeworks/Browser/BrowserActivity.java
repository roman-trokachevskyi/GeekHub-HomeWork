package com.rodico.duke0808.mygeekhub_homeworks.Browser;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HW2Activity;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork1_Main;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork3;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork4.Hw4_activity;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork5.Hw5_activity;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork6.Hw6_Mainctivity;
import com.rodico.duke0808.mygeekhub_homeworks.R;

import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;
import java.util.List;

public class BrowserActivity extends AppCompatActivity {
    static List<HomeWorkItem> myHWList_ex;
    static Context context_ex;
    List<HomeWorkItem> myHWList;
    HwAdapter hwAdapter;
    Context context;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_browser);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;
        context_ex = context;
        listView = (ListView) findViewById(R.id.myHWView);
        ViewGroup parent = (ViewGroup) listView.getParent();
        parent.removeView(listView);
        parent.addView(listView);
        init();
        HomeWorksAdding homeWorksAdding = new HomeWorksAdding();
        //homeWorksAdding.start();

        SwingBottomInAnimationAdapter animationAdapter = new SwingBottomInAnimationAdapter(hwAdapter);
        animationAdapter.setAbsListView(listView);
        listView.setAdapter(animationAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HomeWorkItem item = (HomeWorkItem) parent.getItemAtPosition(position);
                if (item.getIntent() != null) {
                    startActivity(item.getIntent());
                } else {
                    Toast.makeText(BrowserActivity.this, "Maybe next time...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void init(){
        myHWList = new ArrayList<>();
        myHWList_ex = myHWList;
        hwAdapter = new HwAdapter(myHWList,this);

        HomeWorkItem homeWorkItem1=new HomeWorkItem("Home Work 1",context,HomeWork1_Main.class);
        HomeWorkItem homeWorkItem2=new HomeWorkItem("Home Work 2",context,HW2Activity.class);
        myHWList.add(homeWorkItem1);
        myHWList.add(homeWorkItem2);
        myHWList.add(new HomeWorkItem("Home Work 3 (Collections)",context, HomeWork3.class));
        myHWList.add(new HomeWorkItem("Home Work 4 (ООП)",context, Hw4_activity.class));
        myHWList.add(new HomeWorkItem("Home Work 5 (Anim & UI)",context, Hw5_activity.class));
        myHWList.add(new HomeWorkItem("Home Work 6 (Flexible UI)",context, Hw6_Mainctivity.class));
        myHWList.add(new HomeWorkItem("Home Work 7 ",context, null));
        myHWList.add(new HomeWorkItem("Home Work 8 ",context, null));
        myHWList.add(new HomeWorkItem("Home Work 9 ",context, null));
        myHWList.add(new HomeWorkItem("Home Work 10 ",context, null));
        myHWList.add(new HomeWorkItem("Home Work 11 ",context, null));
        myHWList.add(new HomeWorkItem("Home Work 12 ",context, null));
        myHWList.add(new HomeWorkItem("Home Work 13 ",context, null));
        myHWList.add(new HomeWorkItem("Home Work 14 ",context, null));
        myHWList.add(new HomeWorkItem("Home Work 15 ",context, null));
        myHWList.add(new HomeWorkItem("Home Work 16 ",context, null));
        myHWList.add(new HomeWorkItem("Home Work 17 ",context, null));
        myHWList.add(new HomeWorkItem("Home Work 18 ",context, null));
    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.d("fix_browser", "finished super.onResume()");
    }
}
