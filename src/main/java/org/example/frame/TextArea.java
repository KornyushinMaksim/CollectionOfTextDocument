package org.example.frame;

import javax.swing.*;
import java.awt.*;

public class TextAreaTest extends JFrame{

    public TextAreaTest(String nameFile, String buf)
    {
        super(nameFile);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setSize(new Dimension(700, 500));


        // Cоздание многострочных полей
        JTextArea area1 = new JTextArea(buf, 45, 60);
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
        js.setPreferredSize(new Dimension(700, 500));
        add(js, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));

        // Выводим окно на экран
//        setSize(new Dimension(area1.getWidth(), area1.getHeight()));
//        setLayout(new GridBagLayout());
        setVisible(true);
    }
}
