package com.rodico.duke0808.rodicobarcodescannerv20;

import android.content.Context;
import android.view.View;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * Created by duke0808 on 11.10.15.
 */
public class MyProgram implements Serializable{
    private static final MyProgram myProgram = new MyProgram();
    final static String SHOP_NUMBER_KEY = "com.rodico.duke0808.rodicobarcodescannerv20.ShopNumber";
    final static String ACCESTOKEN_DB_KEY = "com.rodico.duke0808.rodicobarcodescannerv20.accessToken";

    final static  String APP_KEY = "3pulo4hl0ej1lxc";
    final static  String APP_SECRET = "3z20wg3mfj8v02m";
    String accessToken="";
    DropboxAPI<AndroidAuthSession> mDBApi;
    String accauntInfo="";

    OperationProcessor opSaleWomen;
    OperationProcessor opReturnWomen;
    OperationProcessor opGetWomen;
    OperationProcessor opOutWomen;
    OperationProcessor opSaleBogdan;
    OperationProcessor opReturnBogdan;
    OperationProcessor opGetBogdan;
    OperationProcessor opOutBogdan;
    OperationProcessor opSaleRoDiCo;
    OperationProcessor opReturnRoDiCo;
    OperationProcessor opGetRoDiCO;
    OperationProcessor opOutRoDiCo;



    {
        shopNumber=0;
        AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
        AndroidAuthSession session = new AndroidAuthSession(appKeys);
        mDBApi = new DropboxAPI<AndroidAuthSession>(session);


    }
    public int shopNumber;

    public static MyProgram getMyProgram() {
        return myProgram;
    }

    void initProg(){
        Item defItem=new Item(11111,1,1);
        opSaleWomen = new OperationProcessor(defItem,"Women's",Operations.SELL);
        opReturnWomen = new OperationProcessor(defItem,"Women's",Operations.RETURN);
        opGetWomen = new OperationProcessor(defItem,"Women's",Operations.GET);
        opOutWomen = new OperationProcessor(defItem,"Women's",Operations.OUT);

        opSaleBogdan = new OperationProcessor(defItem,"NEW",Operations.SELL);
        opReturnBogdan = new OperationProcessor(defItem,"NEW",Operations.RETURN);
        opGetBogdan = new OperationProcessor(defItem,"NEW",Operations.GET);
        opOutBogdan= new OperationProcessor(defItem,"NEW",Operations.OUT);

        opSaleRoDiCo = new OperationProcessor(defItem,"RoDiCo",Operations.SELL);
        opReturnRoDiCo = new OperationProcessor(defItem,"RoDiCo",Operations.RETURN);
        opGetRoDiCO = new OperationProcessor(defItem,"RoDiCo",Operations.GET);
        opOutRoDiCo = new OperationProcessor(defItem,"RoDiCo",Operations.OUT);
    }

    public long scanBarCode(){



        return 1111;
    }

}
