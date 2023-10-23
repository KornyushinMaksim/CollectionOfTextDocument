package org.example.textDocument;

import sun.util.calendar.LocalGregorianCalendar;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class File {
    private String nameFile;
    private String author;
    private int sizeFile;
    private LocalGregorianCalendar.Date dateOfCreation;
    private String[] strings;
    private ArrayList <String> texts;
    private ArrayList <String> lists;

    public File(String nameFile) throws UnknownHostException {
        this.nameFile = nameFile;
        this.author = InetAddress.getLocalHost().getHostName();
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "\nnameFile: " + this.nameFile +
                "\nauthor: " + author;
    }
}
