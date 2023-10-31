package org.example.frame;

import org.example.textDocument.WorkToFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TextArea extends JFrame{

    public TextArea(WorkToFile myFile)
    {
        super(myFile.getFile().getName());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setSize(new Dimension(920, 600));


        // Cоздание многострочных полей
        JTextArea area1 = new JTextArea(myFile.readFile(myFile), 45, 60);
        // Шрифт и табуляция
        area1.setFont(new Font("Dialog", Font.PLAIN, 14));
        area1.setTabSize(10);
        area1.setLineWrap(true);
        area1.setWrapStyleWord(true);

        // Добавим поля в окно
        JPanel contents = new JPanel();
        contents.add(area1);
//        setContentPane(contents);
        JScrollPane js = new JScrollPane(contents);
        js.setPreferredSize(new Dimension());
        add(js, new GridBagConstraints(0, 0, 0, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));

        // Выводим окно на экран
//        setSize(new Dimension(area1.getWidth(), area1.getHeight()));
//        setLayout(new GridBagLayout());
        setVisible(true);

        JButton jButton = new JButton("Сохранить");
        add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    myFile.createdFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
