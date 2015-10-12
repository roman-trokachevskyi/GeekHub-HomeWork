package com.rodico.duke0808.rodicobarcodescannerv20;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dropbox.client2.exception.DropboxException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Settings extends AppCompatActivity {


    private static MyProgram myProgram = MyProgram.getMyProgram();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        EditText shopNumET = (EditText) findViewById(R.id.editText);
        Toast.makeText(Settings.this, "This is shop N:  " + myProgram.shopNumber, Toast.LENGTH_SHORT).show();
        if (myProgram.mDBApi.getSession().isLinked()){
            TextView dbAccauntView = (TextView) findViewById(R.id.dropBoxAccauntView);
            String accaunt= "LINKED OK";


            dbAccauntView.setText(accaunt);
        }
        Button unlinkBT = (Button) findViewById(R.id.unLinkButton);
        unlinkBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myProgram.mDBApi.getSession().unlink();
                myProgram.accessToken="";
            }
        });
    }

    public void setShopNumber(View view){
        EditText shopNumET = (EditText) findViewById(R.id.editText);
        myProgram.shopNumber= Integer.parseInt(shopNumET.getText().toString());
    }
}
