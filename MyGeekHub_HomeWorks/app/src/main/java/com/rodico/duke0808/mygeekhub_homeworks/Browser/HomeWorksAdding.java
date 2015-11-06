package com.rodico.duke0808.mygeekhub_homeworks.Browser;

import android.content.Context;

import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HW2Activity;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork1_Main;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork3;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork4.Hw4_activity;
import com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork5.Hw5_activity;

import java.util.List;

/**
 * Created by duke0808 on 06.11.15.
 */
public class HomeWorksAdding extends Thread {
     List<HomeWorkItem> myHWList;
     Context context;
    {
        myHWList = BrowserActivity.myHWList_ex;
        context = BrowserActivity.context_ex;
    }
    /**
     * Calls the <code>run()</code> method of the Runnable object the receiver
     * holds. If no Runnable is set, does nothing.
     *
     * @see Thread#start
     */
    @Override
    public void run() {
        try {
            init2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void init2() throws InterruptedException {
        sleep(200);
        HomeWorkItem homeWorkItem1=new HomeWorkItem("Home Work 1",context,HomeWork1_Main.class);
        HomeWorkItem homeWorkItem2=new HomeWorkItem("Home Work 2",context,HW2Activity.class);
        myHWList.add(homeWorkItem1);
        myHWList.add(homeWorkItem2);
        myHWList.add(new HomeWorkItem("Home Work 3 (Collections)",context, HomeWork3.class));
        myHWList.add(new HomeWorkItem("Home Work 4 (ООП)",context, Hw4_activity.class));
        myHWList.add(new HomeWorkItem("Home Work 5 (Anim & UI)",context, Hw5_activity.class));
        myHWList.add(new HomeWorkItem("Home Work 6 ",context, null));
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
}
