package org.example.frame;

import org.example.text_new.WorkWithFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

public class FileManager extends JFrame {
    private WorkWithFile workWithFile;
    private JMenu content, program;
    private JMenuItem[] commands;

    public FileManager(String pathDir) {
        super("окно работы с файлом");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setSize(new Dimension(920, 600));

        setVisible(true);

        JButton createdFile = new JButton("Создать");
        add(createdFile);
        createdFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameFile = JOptionPane.showInputDialog(null,
                        "Введите имя файла", "Создание файла TXT", JOptionPane.QUESTION_MESSAGE);
                if (nameFile != null) {
                    try {
                        workWithFile = new WorkWithFile();
                        if (workWithFile.myCreatedNewFile(pathDir, nameFile)) {
                            TextArea textArea = new TextArea(workWithFile, pathDir, nameFile);
                        }
                    } catch (UnknownHostException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        JButton openFile = new JButton("Открыть");
        add(openFile);
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameFile = JOptionPane.showInputDialog(null,
                        "Введите имя файла", "Открытие файла TXT", JOptionPane.QUESTION_MESSAGE);
                try {
                    workWithFile = new WorkWithFile();
//                    String str = workWithFile.openList(pathDir, nameFile);
                    TextArea textArea = new TextArea(workWithFile, pathDir, nameFile);
                } catch (UnknownHostException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
