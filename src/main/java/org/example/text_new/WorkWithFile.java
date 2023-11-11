package org.example.text_new;

import org.example.textDocument.MyFile;

import javax.swing.*;
import java.io.*;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class WorkWithFile {
    private MyFile myFile;      //мой класс где хранится вся инфа и текст
    private File newFile;      //класс для работы с файлами и папками

    private String pathDir;
    private String nameFile;
    private StringBuilder list;
    private StringBuilder textFromFile;
    private ArrayList<StringBuilder> book;
    private ArrayList<MyFile> myFiles;


    public WorkWithFile(String pathDir, String nameFile) throws UnknownHostException {
        this.pathDir = pathDir;
        this.nameFile = nameFile;
        this.myFile = new MyFile(pathDir, nameFile);
        this.myFiles = new ArrayList<>();
    }

    public File getNewFile() {
        return newFile;
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
    public ArrayList<MyFile> getMyFiles(){
        return this.myFiles;
    }
    public void setMyFiles(MyFile myFiles){
        this.myFiles.add(myFiles);
    }

    public boolean myCreatedNewFile() {
        boolean flag = true;
        this.newFile = new File(this.pathDir + File.separator + this.nameFile + ".txt");
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

    public void readFile(String pathDir, String nameFile) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        this.textFromFile = new StringBuilder();
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
//        finally {
//            try {
//                bufferedReader.close();
////                fileReader.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

//        createdMyBook();
        book.add(list);
//        return this.list.toString();
    }

    public void sortFiles(){
        File folder = new File(pathDir);
//        for (File)
    }

    private void createdMyBook(){
        int i = 0;
        int indexList = 0;
        int index = 1;
        this.book = new ArrayList<>();
        String[] strings = textFromFile.toString().split("\n");
        for (; i < strings.length; i++){
            if (indexList % (index * 6) == 0) {
                if (list != null) {
                    book.add(list);
                    index++;
                }
                this.list = new StringBuilder();
            }
            this.list.append(strings[i]);
            indexList++;
        }

//        while (this.textFromFile.isEmpty()){
//            if (indexList % (index * 6) == 0) {
//                if (list != null) {
//                    book.add(list);
//                    index++;
//                }
//                this.list = new StringBuilder();
//            }
//            indexList++;
//        }
        book.add(list);
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


    public void save(String textPane) {
        try (FileWriter fileWriter = new FileWriter(this.pathDir +
                File.separator +
                this.nameFile +
                ".txt", false);) {
//            BufferedReader bufferedReader = new BufferedReader();
            fileWriter.write(textPane);
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

    public void replace() {
        String strSource = JOptionPane.showInputDialog(null,
                "Заменить слово",
                "Замена",
                JOptionPane.QUESTION_MESSAGE);
        String strDect = JOptionPane.showInputDialog(null,
                "Заменить на",
                "Замена",
                JOptionPane.QUESTION_MESSAGE);
        for (int i = 0; i < this.book.size(); i++){
            String s = this.book.get(i).toString().replaceAll(strSource, strDect);
            this.book.get(i).delete(0, this.book.get(i).length());
            this.book.get(i).append(s);
        }
    }
}
