package org.example.text_new;

import org.example.textDocument.MyFile;

import javax.swing.*;
import java.io.*;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkWithFile {
    private MyFile myFile;      //мой класс где хранится вся инфа и текст
    private File newFile;      //класс для работы с файлами и папками

    private String pathDir;
    private String nameFile;
    private StringBuilder list;
    private StringBuilder textFromFile;
    private ArrayList<StringBuilder> book;
    private ArrayList<MyFile> myFiles;


    public WorkWithFile(String pathDir/*, String nameFile*/) /*throws UnknownHostException*/ {
        this.pathDir = pathDir;
//        this.nameFile = nameFile;
//        this.myFile = new MyFile(pathDir, nameFile);
        this.myFiles = new ArrayList<>();
    }

//    public File getNewFile() {
//        return newFile;
//    }

//    public File getFile() {
//        return newFile;
//    }

    public StringBuilder getList() {
        return list;
    }

    public ArrayList<StringBuilder> getBook() {
        return book;
    }

    public MyFile getMyFile() {
        return myFile;
    }

    public ArrayList<MyFile> getMyFiles() {
        return this.myFiles;
    }

    public void setMyFiles(MyFile myFiles) {
        this.myFiles.add(myFiles);
    }

    public boolean myCreatedNewFile() {
        boolean flag = true;
        File newFile = new File(this.pathDir + File.separator + this.nameFile + ".txt");
//        this.myFile.setSizeFile(String.format("%.2f", (float) this.newFile.length() / 1000));
        if (newFile.exists()) {
            flag = false;
            String text = "Файл с именем '" + this.nameFile + "' существует";
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
//    public String openList() {
//        readFile();
//        String str = this.book.get(0).toString();
//        return str;
//    }

    //запись текста из файла в MyFile
    public void readFiles(String pathDir, String nameFile) {
        try (FileReader file = new FileReader(pathDir + File.separator + nameFile)) {
            int c;
            int cnt = 0;
            int a = 0;
            int index = 1;
            String allLine = "";
            String line = "";
            StringBuilder list = new StringBuilder();
            while ((c = file.read()) != -1) {
                allLine += (char) c;
            }
            ArrayList<String> s = new ArrayList<>();
            for (int i = 0; i < allLine.length(); i++){
                s.add(allLine.substring(i, Math.min(allLine.length(), i + 700)));
                getItem(nameFile).setBook(String.valueOf(s));
            }

//            char[] chars = allLine.toCharArray();
//            for (int i = 0; i < allLine.length(); i++) {
//                if (a == 100) {
//                    if (cnt % (index * 10) == 0) {
//                        if (list != null) {
//                            getItem(nameFile).setBook(line);
//                            index++;
//                        }
//                        list = new StringBuilder();
//                    }
//                    list.append(line);
//                    list.append("\n");
//                    cnt++;
//                    a = 0;
//                    line = "";
//                } else {
//                    line += chars[i];
//                    a++;
//                }
//                getItem(nameFile).setBook(line);
//            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFile(String pathDir, String nameFile) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
//        this.textFromFile = new StringBuilder();
        int cnt = 0;
        int index = 1;
//        this.book = new ArrayList<>();
        StringBuilder list = null;
//        MyFile tmpMyFile = getItem(nameFile);
//        try {
//            this.myFile = new MyFile(pathDir, nameFile);
//        } catch (UnknownHostException e) {
//            throw new RuntimeException(e);
//        }
        try {
            fileReader = new FileReader(pathDir + File.separator + nameFile);
            bufferedReader = new BufferedReader(fileReader);
            list = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                if (cnt % (index * 6) == 0) {
                    if (list != null) {
                        getItem(nameFile).setBook(line);
                        index++;
                        list = new StringBuilder();
                    }
                }
                list.append(line);
                list.append("\n");
                cnt++;
            }
        } catch (IOException e) {
            e.getMessage();
        }
        if (list == null) {
            getItem(nameFile).setBook(line);
        }
    }

    public void sortFiles() {
        File folder = new File(pathDir);
    }

//    private void createdMyBook(){
//        int i = 0;
//        int indexList = 0;
//        int index = 1;
//        this.book = new ArrayList<>();
//        String[] strings = textFromFile.toString().split("\n");
//        for (; i < strings.length; i++){
//            if (indexList % (index * 6) == 0) {
//                if (list != null) {
//                    book.add(list);
//                    index++;
//                }
//                this.list = new StringBuilder();
//            }
//            this.list.append(strings[i]);
//            indexList++;
//        }
//        book.add(list);
//    }

    public void save(String textPane) {
        try (FileWriter fileWriter = new FileWriter(this.pathDir +
                File.separator +
                this.nameFile +
                ".txt", false);) {
            fileWriter.write(textPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchToFile(String list, String str) {
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

    public void replace(String nameFile) {
        String strSource = JOptionPane.showInputDialog(null,
                "Заменить слово",
                "Замена",
                JOptionPane.QUESTION_MESSAGE);
        String strDect = JOptionPane.showInputDialog(null,
                "Заменить на",
                "Замена",
                JOptionPane.QUESTION_MESSAGE);
        ArrayList<StringBuilder> sb = new ArrayList<>(getItem(nameFile + ".txt").getBook());
        for (int i = 0; i < getItem(nameFile + ".txt").getBook().size(); i++) {
            String s = sb.get(i).toString().replaceAll(strSource, strDect);
            sb.get(i).delete(0, sb.get(i).length());
            sb.get(i).append(s);
        }
    }

    //возвращает эл-т массива
    public MyFile getItem(String nameFile) {
        for (int i = 0; i < this.myFiles.size(); i++) {
            if (this.myFiles.get(i).getNameFile().equals(nameFile)) {
                return this.myFiles.get(i);
            }
        }
        return null;
    }
}
