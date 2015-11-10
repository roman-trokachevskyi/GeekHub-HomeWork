package com.rodico.duke0808.mygeekhub_homeworks.HomeWorks.HomeWork6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.rodico.duke0808.mygeekhub_homeworks.R;

public class Hw6_Mainctivity extends AppCompatActivity implements ItemFragment.OnFragmentInteractionListener{

    ItemFragment listFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw6__mainctivity);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listFrag = new ItemFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.hw6_list_container,listFrag).commit();
    }

    @Override
    public void onFragmentInteraction(int position) {
        FrameLayout second_cont = (FrameLayout) findViewById(R.id.hw6_second_container);
        if (second_cont!=null){
            SecondFragment secondFragment = new SecondFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position",position);
            secondFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.hw6_second_container,secondFragment).commit();
        } else {
            Intent intent = new Intent(this, Hw6_SecondActivity.class);
            intent.putExtra("position",position);
            startActivity(intent);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
