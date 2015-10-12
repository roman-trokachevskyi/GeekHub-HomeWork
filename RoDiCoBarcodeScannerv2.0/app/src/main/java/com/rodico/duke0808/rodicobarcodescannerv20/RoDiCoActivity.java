package com.rodico.duke0808.rodicobarcodescannerv20;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dropbox.client2.exception.DropboxException;

import java.io.IOException;

public class RoDiCoActivity extends AppCompatActivity {
    MyProgram myProgram = MyProgram.getMyProgram();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ro_di_co);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final EditText barCodeET = (EditText) findViewById(R.id.editText2);
        final EditText priceET = (EditText) findViewById(R.id.editText3);
        final EditText quantityET = (EditText) findViewById(R.id.editText4);
        Button saleB = (Button) findViewById(R.id.saleButton);



        saleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item item = new Item(Long.parseLong(barCodeET.getText().toString()),Integer.parseInt(priceET.getText().toString()),Integer.parseInt(quantityET.getText().toString()));
                try {
                    myProgram.opSaleRoDiCo.writeOperation(item);
                    //myProgram.opSaleRoDiCo.saveToDB();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
