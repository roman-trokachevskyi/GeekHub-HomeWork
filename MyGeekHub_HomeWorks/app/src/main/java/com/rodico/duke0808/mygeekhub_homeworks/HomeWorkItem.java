package com.rodico.duke0808.mygeekhub_homeworks;

import android.content.Context;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by duke0808 on 15.10.15.
 */
public class HomeWorkItem {
    String name;
    static int numberAtAll=0;
    Date dateOnComplite;
    int number;
    Intent intent;
    {dateOnComplite=new Date();}

    public HomeWorkItem(String name, Context context, Class<?> cls ) {
        this.name = name;
        numberAtAll++;
        this.number=numberAtAll;
        dateOnComplite=new Date();
        intent = new Intent(context, cls);
    }

    @Override
    public String toString() {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMM/yyyy ,at kk:mm");
        res = String.format("Home Work # %d, complited at %s",number,simpleDateFormat.format(this.dateOnComplite));
        return res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}
