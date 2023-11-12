package org.example.textDocument;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashSet;

public class WorkToFile {
    private MyFile myFile;      //мой класс где хранится вся инфа и текст
    private File file;      //класс для работы с файлами и папками
    private HashSet<MyFile> myFiles;

    public WorkToFile(String nameFile, String pathFile) throws UnknownHostException {
        this.myFile = new MyFile(nameFile, pathFile);
        this.myFiles = new HashSet<>();
        System.out.println(MyFile.class.getName());
    }

//    public File getFile() {
//        return file;
//    }

    public MyFile getMyFile() {
        return myFile;
    }

    //создание нового файла по пути
    public String createdNewFile() throws IOException {
        File file = new File(this.myFile.getPathDir(), this.myFile.getNameFile() + ".txt");
        this.myFile.setSizeFile(String.format("%.2f", (float) file.length() / 1000));
        try {
            boolean created = file.createNewFile();
            return "file created";
        } catch (Exception e) {
            return "file not created";
        }
    }

    //создание папки по пути
    public void createdDir(String path) {
        this.file = new File(path);
    }

//    public String readFile(WorkToFile myFile) {
//        String strRes = "";
//        FileReader fileReader = null;
//        try {
//            fileReader = new FileReader(myFile.getFile());
//        } catch (IOException e) {
//            strRes = e.getMessage();
//        }
//        char[] buf = new char[100000];
//        int cnt = 0;
//        while (true) {
//            try {
//                if (!((cnt = fileReader.read(buf)) > 0)) {
//                    break;
//                }
//            } catch (IOException e) {
//                strRes = e.getMessage();
//            }
//            if (cnt < 100000) {
//                buf = Arrays.copyOf(buf, cnt);
//            }
//        }
//        for (int i = 0, j = 1; i < buf.length; i++) {
//            strRes += buf[i];
//            if (i == j++ * 100) {
//                strRes += "\n";
//            }
//        }
//        return strRes;
//    }

    public void edit() {

    }

    public void openFile() {

    }

    @Override
    public String toString() {
        return this.myFile.toString();
    }
}
