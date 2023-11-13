package org.example.textDocument;

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
    private ArrayList <StringBuilder> book;

    public MyFile(String pathDir, String nameFile) {
        this.nameFile = nameFile;
        this.pathDir = pathDir;
        try {
            this.author = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        this.sizeFile = String.format("%.2f",(float)nameFile.length() / 1000);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        this.dateOfCreation = format.format(new Date());
        this.book = new ArrayList<>();
    }

    public String getNameFile() {
        return nameFile;
    }

    public String getPathDir() {
        return pathDir;
    }

    public String getAuthor() {
        return author;
    }

    public String getSizeFile() {
        return sizeFile;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public ArrayList<StringBuilder> getBook() {
        return book;
    }

    public void setSizeFile(String sizeFile) {
        this.sizeFile = sizeFile;
    }

    public void setBook(String str){
        this.book.add(new StringBuilder(str));
    }

    @Override
    public String toString() {
        return this.nameFile +
                "\t\t\t\t\t\t" + author +
                "\t\t\t\t\t\t" + this.sizeFile + " Kb" +
                "\t\t\t\t\t\t" + this.dateOfCreation;
    }
}
