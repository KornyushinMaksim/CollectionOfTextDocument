package org.example.text_new;

import org.example.textDocument.MyFile;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class WorkWithFile {
    private String pathDir;
    private ArrayList<MyFile> myFiles;

    public WorkWithFile(String pathDir) {
        this.pathDir = pathDir;
        this.myFiles = new ArrayList<>();
    }

    public ArrayList<MyFile> getMyFiles() {
        return this.myFiles;
    }

    public void setMyFiles(MyFile myFiles) {
        this.myFiles.add(myFiles);
    }

    public boolean myCreatedNewFile(String nameFile) {
        boolean flag = true;
        File file = new File(pathDir + File.separator + nameFile + ".txt");
        setMyFiles(new MyFile(pathDir, nameFile + ".txt"));
        getItem(nameFile + ".txt").setSizeFile(String.format("%.2f", (float) file.length() / 1000));
        if (file.exists()) {
            flag = false;
            String text = "Файл с именем '" + nameFile + "' существует";
            JOptionPane.showMessageDialog(null,
                    text,
                    "Предупреждение",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                file.createNewFile();
                JOptionPane.showMessageDialog(null,
                        "Файл успешно создан",
                        "Сообщение",
                        JOptionPane.WARNING_MESSAGE);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return flag;
    }

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
            for (int i = 0; i < allLine.length(); i++) {
                s.add(allLine.substring(i, Math.min(allLine.length(), i + 700)));
                getItem(nameFile).setBook(String.valueOf(s));
            }
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
        int cnt = 0;
        int index = 1;
        StringBuilder list = null;
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

    public void sortFiles(String string) {
        File folder = new File(pathDir);
    }

    public void save(String textPane, String nameFile) {
        try (FileWriter fileWriter = new FileWriter(this.pathDir +
                File.separator +
                nameFile +
                ".txt", false);) {
            fileWriter.write(textPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
