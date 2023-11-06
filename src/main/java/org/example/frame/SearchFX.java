package org.example.frame;

import org.example.text_new.WorkWithFile;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;

public class SearchFX extends JFrame {

    class MyButtons extends JButton {
        MyButtons(String name) {
            super(new ImageIcon("icon" + File.separator + name));
            setFocusPainted(false);
        }
    }
    public SearchFX (WorkWithFile workWithFile, String list){
        super("Поиск...");
        setBounds(380, 55, 400, 60);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel jLabel = new JLabel("Введите слово");
        JTextField textField = new JTextField();
        textField.setSize(new Dimension(100, 50));

        Border border = BorderFactory.createEtchedBorder();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        add(panel, BorderLayout.CENTER);
//        panel.add(jLabel);
        panel.add(textField);

        JToolBar toolBar = new JToolBar();
        MyButtons search = new MyButtons("searchMini.jpeg");
        search.setToolTipText("Поиск");
        toolBar.add(search);
        add(toolBar, BorderLayout.EAST);
        search.addActionListener(actionEvent -> {
            workWithFile.searchToFile(list, textField.getText());
        });

        setVisible(true);

//        JScrollPane scrollPane = new JScrollPane();
////        this.textPane = new JTextPane();
////        scrollPane.getViewport().add(this.textPane);
//        panel.add(scrollPane);
//        JPanel p = new JPanel();
//        p.setLayout(new GridLayout(1,3));
//        p.setBorder(border);
//        p.add(new JPanel());
//        p.add(new JButton("Ok"));
//        p.add(new JPanel());
//        add(p, BorderLayout.SOUTH);
    }
}
