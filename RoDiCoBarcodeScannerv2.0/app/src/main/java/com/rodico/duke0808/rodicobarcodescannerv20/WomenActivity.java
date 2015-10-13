package com.rodico.duke0808.rodicobarcodescannerv20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class WomenActivity extends AppCompatActivity {
    EditText barCeT;
    MyProgram myProgram = MyProgram.getMyProgram();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women);
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
        barCeT=barCodeET;
        final EditText priceET = (EditText) findViewById(R.id.editText3);
        final EditText quantityET = (EditText) findViewById(R.id.editText4);
        final Button saleB = (Button) findViewById(R.id.saleButton);
        final Button returnB = (Button) findViewById(R.id.returnButton);
        final Button outB = (Button) findViewById(R.id.outButton);
        final Button getB = (Button) findViewById(R.id.getButton);

        Button scanBT = (Button) findViewById(R.id.scanButton);
        scanBT.setOnClickListener(scanProduct);

        saleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(barCodeET.getText().toString().isEmpty()||priceET.getText().toString().isEmpty()||quantityET.getText().toString().isEmpty())) {
                    Item item = new Item(Long.parseLong(barCodeET.getText().toString()),Integer.parseInt(priceET.getText().toString()),Integer.parseInt(quantityET.getText().toString()));
                    saleB.setSelected(true);
                    try {
                        myProgram.opSaleWomen.writeOperation(item);
                        //myProgram.opSaleRoDiCo.saveToDB();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    saleB.setSelected(false);
                    Toast.makeText(WomenActivity.this, "ЗБЕРЕЖЕНО", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(WomenActivity.this, "ПОМИЛКА ВВЕДЕННЯ!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        returnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(barCodeET.getText().toString().isEmpty()||priceET.getText().toString().isEmpty()||quantityET.getText().toString().isEmpty())) {
                    Item item = new Item(Long.parseLong(barCodeET.getText().toString()),Integer.parseInt(priceET.getText().toString()),Integer.parseInt(quantityET.getText().toString()));
                    returnB.setSelected(true);
                    try {
                        myProgram.opReturnWomen.writeOperation(item);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    returnB.setSelected(false);
                    Toast.makeText(WomenActivity.this, "ЗБЕРЕЖЕНО", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(WomenActivity.this, "ПОМИЛКА ВВЕДЕННЯ!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        getB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(barCodeET.getText().toString().isEmpty()||priceET.getText().toString().isEmpty()||quantityET.getText().toString().isEmpty())) {
                    Item item = new Item(Long.parseLong(barCodeET.getText().toString()),Integer.parseInt(priceET.getText().toString()),Integer.parseInt(quantityET.getText().toString()));
                    getB.setSelected(true);
                    try {
                        myProgram.opGetWomen.writeOperation(item);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    getB.setSelected(false);
                    Toast.makeText(WomenActivity.this, "ЗБЕРЕЖЕНО", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(WomenActivity.this, "ПОМИЛКА ВВЕДЕННЯ!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        outB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(barCodeET.getText().toString().isEmpty()||priceET.getText().toString().isEmpty()||quantityET.getText().toString().isEmpty())) {
                    Item item = new Item(Long.parseLong(barCodeET.getText().toString()),Integer.parseInt(priceET.getText().toString()),Integer.parseInt(quantityET.getText().toString()));
                    outB.setSelected(true);
                    try {
                        myProgram.opOutWomen.writeOperation(item);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outB.setSelected(false);
                    Toast.makeText(WomenActivity.this, "ЗБЕРЕЖЕНО", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(WomenActivity.this, "ПОМИЛКА ВВЕДЕННЯ!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private final View.OnClickListener scanProduct = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            IntentIntegrator integrator = new IntentIntegrator(WomenActivity.this);
            integrator.addExtra("SCAN_WIDTH", 800);
            integrator.addExtra("SCAN_HEIGHT", 200);
            integrator.addExtra("RESULT_DISPLAY_DURATION_MS", 3000L);
            integrator.addExtra("PROMPT_MESSAGE", "Custom prompt to scan a product");
            integrator.initiateScan(IntentIntegrator.PRODUCT_CODE_TYPES);
        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (requestCode==0x0000c0de){
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
            if (result != null) {
                String code = result.getContents();
                if (code != null) {
                    barCeT.setText(code);
                } else {
                    Toast.makeText(WomenActivity.this, "SCAN ERROR!!!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}
