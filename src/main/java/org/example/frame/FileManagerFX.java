package org.example.frame;

import org.example.text_new.WorkWithFile;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

public class FileManagerFX extends JFrame {
    private WorkWithFile workWithFile;
    private JPanel panel;
    private JTextPane textPane;
    private JMenu content, program;
    private JMenuItem[] commands;

    public FileManagerFX(String pathDir) {
        super("Окно работы с файлом");
        setBounds(250, 100, 800, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Border border = BorderFactory.createEtchedBorder();

        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(1, 2));
        add(panel, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane();
//        this.textPane = new JTextPane();
//        scrollPane.getViewport().add(this.textPane);
        panel.add(scrollPane);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 3));
        p.setBorder(border);
        p.add(new JPanel());
        add(p, BorderLayout.SOUTH);

        JButton createdFile = new JButton("Создать");
        p.add(createdFile);
        createdFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameFile = JOptionPane.showInputDialog(null,
                        "Введите имя файла", "Создание файла TXT", JOptionPane.QUESTION_MESSAGE);
                if (nameFile != null) {
                    try {
                        workWithFile = new WorkWithFile();
                        if (workWithFile.myCreatedNewFile(pathDir, nameFile)) {
//                            System.out.println("===");
//                            CreatedFileFX createdFileFX = new CreatedFileFX(workWithFile, pathDir, nameFile);
                        }
                    } catch (UnknownHostException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        JButton openFile = new JButton("Открыть");
        p.add(openFile);
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameFile = JOptionPane.showInputDialog(null,
                        "Введите имя файла", "Открытие файла TXT", JOptionPane.QUESTION_MESSAGE);
                try {
                    workWithFile = new WorkWithFile();
                    workWithFile.openList(pathDir, nameFile);
                    OpenFileFX openFileFX = new OpenFileFX(workWithFile, nameFile);
                } catch (UnknownHostException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        p.add(new JPanel());
        setVisible(true);

    }
}
