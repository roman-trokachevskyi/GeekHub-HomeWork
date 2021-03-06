package com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.rodico.duke0808.mygeekhub_homeworks.R;

/**
 * Created by duke0808 on 26.10.15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    ContainerFragment fragment;

    abstract public Boolean isAddFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isAddFragment()==true){
            setContentView(R.layout.layout9);
            Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
            setSupportActionBar(myToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            init();

        } else {
            setContentView(R.layout.empty_layout_hw4);
        }
    }

    public void init(){
        fragment = new ContainerFragment();
        fragment.setFragmentManager(getSupportFragmentManager());
        getSupportFragmentManager().beginTransaction().add(R.id.container_hw4, fragment, "fr_1").commit();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
