package com.rodico.duke0808.rodicobarcodescannerv20;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AccessTokenPair;

import java.io.IOException;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    public static Context context;


    MyProgram myProgram = MyProgram.getMyProgram();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        loadPreferences();
        context=getApplicationContext();

        if (myProgram.accessToken!=""){
            myProgram.mDBApi.getSession().setOAuth2AccessToken(myProgram.accessToken);
        }

        if (!myProgram.mDBApi.getSession().isLinked()){
            myProgram.mDBApi.getSession().startOAuth2Authentication(HomeActivity.this);
        }

        Button womBut = (Button) findViewById(R.id.womensButton);
        Button bogBut = (Button) findViewById(R.id.bogdanButton);
        Button rodiBut = (Button) findViewById(R.id.rodicoButton);

        rodiBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.context,RoDiCoActivity.class);
                startActivity(intent);
            }
        });
        womBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.context,WomenActivity.class);
                startActivity(intent);
            }
        });
        bogBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.context,BogdanActivity.class);
                startActivity(intent);
            }
        });

        myProgram.initProg();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,Settings.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(HomeActivity.this, myProgram.accessToken, Toast.LENGTH_SHORT).show();

        if (myProgram.mDBApi.getSession().authenticationSuccessful()) {
            try {
                // Required to complete auth, sets the access token on the session
                myProgram.mDBApi.getSession().finishAuthentication();
                //myProgram.accauntInfo="testInfo";
                AccessTokenPair accessTokenPair =myProgram.mDBApi.getSession().getAccessTokenPair();
               myProgram.accessToken = myProgram.mDBApi.getSession().getOAuth2AccessToken();
//                Toast.makeText(HomeActivity.this, myProgram.accessToken, Toast.LENGTH_SHORT).show();

                myProgram.accessToken = myProgram.mDBApi.getSession().getOAuth2AccessToken();
            } catch (IllegalStateException e) {
                Log.i("DbAuthLog", "Error authenticating", e);
            }

            String currentDateActual = (String) DateFormat.format("dd-MM-yyyy", new Date());
            if (!currentDateActual.equals(myProgram.opSaleRoDiCo)){
                myProgram.initProg();
            }
        }
    }

    public void savePreferences(){
        SharedPreferences sharedPref = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(MyProgram.SHOP_NUMBER_KEY,myProgram.shopNumber);
        editor.putString(MyProgram.ACCESTOKEN_DB_KEY, myProgram.accessToken);
        editor.commit();
    }

    public void loadPreferences(){
        SharedPreferences sharedPref = this.getPreferences(MODE_PRIVATE);
        myProgram.shopNumber=sharedPref.getInt(MyProgram.SHOP_NUMBER_KEY,0);
        myProgram.accessToken=sharedPref.getString(MyProgram.ACCESTOKEN_DB_KEY,"");
    }

    @Override
    protected void onPause() {
        super.onPause();
        savePreferences();
    }


}
