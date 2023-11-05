package org.example.textDocument;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyFile {
    private String nameFile;
    private String pathDir;
    private String author;
    private String sizeFile;
    private String dateOfCreation;
    private String[] strings;
    private ArrayList <String> texts;
    private ArrayList <String> lists;

    public MyFile(String pathDir, String nameFile) throws UnknownHostException {
        this.nameFile = nameFile;
        this.pathDir = pathDir;
        this.author = InetAddress.getLocalHost().getHostName();
//        this.sizeFile = String.format("%.2f",(float)nameFile.length() / 1000);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        this.dateOfCreation = format.format(new Date());
    }

    public String getNameFile() {
        return nameFile;
    }

    public String getPath() {
        return pathDir;
    }

    public void setSizeFile(String sizeFile) {
        this.sizeFile = sizeFile;
    }

    @Override
    public String toString() {
        return this.nameFile +
                "\t" + author +
                "\t" + this.sizeFile + " Kb" +
                "\t" + this.dateOfCreation;
    }
//        @Override
//    public String toString() {
//        return "\nnameFile: " + this.nameFile +
//                "\nauthor: " + author +
//                "\nsizeFile: " + this.sizeFile + " Kb" +
//                "\ndate: " + this.dateOfCreation;
//    }
}
