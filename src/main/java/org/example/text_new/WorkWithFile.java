package org.example.text_new;

import com.sun.jdi.event.StepEvent;
import org.example.frame.OpenFileFX;
import org.example.textDocument.MyFile;

import javax.swing.*;
import java.io.*;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class WorkWithFile {
    private MyFile myFile;      //мой класс где хранится вся инфа и текст
    private File newFile;      //класс для работы с файлами и папками
    private StringBuilder list;
    private ArrayList<StringBuilder> book;
//    private ArrayList<File> files;


    public WorkWithFile(/*String pathDir, String nameFile*/) throws UnknownHostException {
//        this.myFile = new MyFile(pathDir, nameFile);
//        this.files = new ArrayList<>();
    }

    public File getFile() {
        return newFile;
    }

    public StringBuilder getList() {
        return list;
    }

    public ArrayList<StringBuilder> getBook() {
        return book;
    }

    public MyFile getMyFile() {
        return myFile;
    }
//    public ArrayList<File> getFiles(){
//        return this.files;
//    }

    public boolean myCreatedNewFile(String pathDir, String nameFile) {
        boolean flag = true;
        this.newFile = new File(pathDir + File.separator + nameFile + ".txt");
        if (newFile.exists()) {
            flag = false;
            String text = "Файл с именем '" + nameFile + "' существует";
            JOptionPane.showMessageDialog(null,
                    text,
                    "Предупреждение",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                newFile.createNewFile();
                JOptionPane.showMessageDialog(null,
                        "Файл успешно создан",
                        "Сообщение",
                        JOptionPane.WARNING_MESSAGE);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
//        this.files.add(newFile);
        return flag;
    }

    //первое открытие
    public String openList(String pathDir, String nameFile) {
        readFile(pathDir, nameFile);
        String str = this.book.get(0).toString();
        return str;
    }

    public void readFile(String pathDir, String nameFile) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        int cnt = 0;
        int index = 1;
        this.book = new ArrayList<>();
//        this.list = new StringBuilder();
        try {
            fileReader = new FileReader(pathDir + File.separator + nameFile + ".txt");
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                if (cnt % (index * 6) == 0) {
                    if (list != null) {
                        book.add(list);
                        index++;
                    }
                    this.list = new StringBuilder();
                }
                this.list.append(line);
                this.list.append("\n");
                cnt++;
            }
        } catch (IOException e) {
            e.getMessage();
        }
        book.add(list);
//        return this.list.toString();
    }

    //открытие файла        !!!!переписать на line вместо char[] buf = new char[100000];
//    public String readFile(WorkWithFile myFile) {
//        String strRes = "";
//        FileReader fileReader = null;
//        try {
//            fileReader = new FileReader(myFile.getFile());
////            BufferedReader bufferedReader = new BufferedReader(fileReader);
//        } catch (IOException e) {
//            strRes = e.getMessage();
////        }
//            char[] buf = new char[100000];
//            int cnt = 0;
//            while (true) {
//                try {
//                    if (!((cnt = fileReader.read(buf)) > 0)) {
//                        break;
//                    }
//                } catch (IOException ex) {
//                    strRes = ex.getMessage();
//                }
//                if (cnt < 100000) {
//                    buf = Arrays.copyOf(buf, cnt);
//                }
//            }
//            for (int i = 0, j = 1; i < buf.length; i++) {
//                strRes += buf[i];
//                if (i == j++ * 100) {
//                    strRes += "\n";
//                }
//            }
//        }
//        return strRes;
//    }


    public void save() {
        try (FileWriter fileWriter = new FileWriter(myFile.getPath() +
                File.separator + myFile.getNameFile() +
                ".txt", false);) {
//            BufferedReader bufferedReader = new BufferedReader();
            fileWriter.write(myFile.getPath() +
                    File.separator + myFile.getNameFile() +
                    ".txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void myDeleteFile() {
        newFile.delete();
    }

    public void searchToFile(String list, String str) {
//        String searchStr = JOptionPane.showInputDialog(null, "", "Поиск...", JOptionPane.QUESTION_MESSAGE);
        ArrayList<Integer> words = new ArrayList<>();
        int cnt = 0;
        int index = list.indexOf(str);
        words.add(index);
        while (list.isEmpty()) {
           index = list.indexOf(str, index + 1);
           words.add(index);
            System.out.println(index);
        }
    }
}
