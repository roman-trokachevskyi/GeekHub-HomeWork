package com.rodico.duke0808.rodicobarcodescannerv20;

import android.text.format.DateFormat;
import android.widget.Toast;

import com.dropbox.client2.exception.DropboxException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by duke0808 on 12.10.15.
 */
public class OperationProcessor {
    private static MyProgram myProgram = MyProgram.getMyProgram();
    static int processorsCount;
    static {
        processorsCount=0;
        }
    File file=null;
    Operations operation=Operations.SELL;
    String opp_cd;
    Item item;
    String companyCode=null;
    String path;
    String currentDate = (String) DateFormat.format("dd-MM-yyyy", new Date());



    public OperationProcessor(Item item, String companyCode, Operations operation) {
        this.item = item;
        this.companyCode = String.valueOf(companyCode);
        this.operation = operation;
        path="/"+companyCode+"/"+myProgram.shopNumber+"/"+currentDate;
        switch (operation){
            case SELL: opp_cd="-"+myProgram.shopNumber+"-"+"0"; break;
            case RETURN: opp_cd="-0-"+myProgram.shopNumber; break;
            case GET: opp_cd="-1-"+myProgram.shopNumber; break;
            case OUT: opp_cd="-"+myProgram.shopNumber+"-1"; break;
        }
        path+=opp_cd+".txt";
    }

//    public void writeOperation() throws IOException {
//        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
//        String s= item+"\n";
//        fileOutputStream.write(s.getBytes());
//        fileOutputStream.close();
//    }
    public void writeOperation(Item item) throws IOException, InterruptedException {
        byte[] bytes;
        ByteArrayOutputStream bOS = new ByteArrayOutputStream();
        Loader loader = new Loader(bOS,path);
        loader.start();
        loader.join();
        bOS.write(String.valueOf((item.toString()) + "\n").getBytes());
        bOS.close();
        bytes=bOS.toByteArray();
        ByteArrayInputStream bIS = new ByteArrayInputStream(bytes);
        Saver saver = new Saver(path,bIS);
        saver.start();
        saver.join();
    }

    public static class Saver extends Thread{
        String path;
        File file;
        InputStream is;
        public void run() {


            try {

                try {
                    myProgram.mDBApi.putFileOverwrite(path, is, is.available(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (DropboxException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public Saver(String path, InputStream is) {
            this.path = path;
            this.file = file;
            this.is=is;
        }
    }

    public class Loader extends Thread{
        String path;
        OutputStream os;

        public Loader(OutputStream os, String path) {
            this.path = path;
            this.os=os;
        }

        @Override
        public void run() {
            try {
                myProgram.mDBApi.getFile(path,null,os,null);
            } catch (DropboxException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
