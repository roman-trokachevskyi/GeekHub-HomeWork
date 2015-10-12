package com.rodico.duke0808.rodicobarcodescannerv20;

import android.text.format.DateFormat;
import android.widget.Toast;

import com.dropbox.client2.exception.DropboxException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
        File tempFile = File.createTempFile("ttemp.txt",null,HomeActivity.context.getCacheDir());
        Loader loader = new Loader(tempFile,path);
        loader.start();
        loader.join();
        FileOutputStream fos = new FileOutputStream(tempFile,true);
        fos.write((item + "\n").toString().getBytes());
        fos.close();
        Saver saver = new Saver(path,tempFile);
        saver.start();
        saver.join();
        tempFile.delete();

    }

    public void saveToDB() throws IOException, DropboxException, InterruptedException {
        file=File.createTempFile("temp.txt",null,HomeActivity.context.getCacheDir());
        Saver saver = new Saver(path,file);
        saver.start();
        saver.join();
        file.delete();
    }

    public static class Saver extends Thread{
        String path;
        File file;
        public void run() {
            String currentDateActual = (String) DateFormat.format("dd-MM-yyyy", new Date());
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {

                myProgram.mDBApi.putFileOverwrite(path, fis, file.length(), null);
            } catch (DropboxException e) {
                e.printStackTrace();
            }
        }

        public Saver(String path, File file) {
            this.path = path;
            this.file = file;
        }
    }

    public class Loader extends Thread{
        File file;
        String path;

        public Loader(File file, String path) {
            this.file = file;
            this.path = path;
        }

        @Override
        public void run() {
            FileOutputStream fos=null;
            try {
                fos = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                myProgram.mDBApi.getFile(path,null,fos,null);
            } catch (DropboxException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
