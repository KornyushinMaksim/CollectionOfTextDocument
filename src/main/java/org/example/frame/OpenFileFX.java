package org.example.frame;

import org.example.text_new.WorkWithFile;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class OpenFileFX extends JFrame implements ActionListener {

    private WorkWithFile workWithFile;
    protected ArrayList<Integer> indexes;
    private JToolBar toolBar;
    private JPanel panel;
    private JTextPane textPane;
    private int index;
    private String[] lists;
    protected boolean flag;

    //вложенный конструктор с кнопками
    class MyButtons extends JButton {
        MyButtons(String name) {
            super(new ImageIcon("icon" + File.separator + name));
            setFocusPainted(false);
        }
    }

    public OpenFileFX(String str){
        super(str);
    }

    public OpenFileFX(WorkWithFile workWithFile, String nameFile) {
        super(nameFile);
        this.workWithFile = workWithFile;
        this.flag = false;
//        this.workWithFile.readFile(pathDir, nameFile);
//        setDefaultCloseOperation(HIDE_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setLayout(new GridBagLayout());
//        setSize(new Dimension(920, 600));
        this.index = 0;

        setBounds(250, 50, 800, 700);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BorderLayout());

        this.toolBar = new JToolBar("Панель меню");
        MyButtons forward = new MyButtons("forward1.png");
        forward.setToolTipText("Следующая страница");
        MyButtons back = new MyButtons("back1.png");
        back.setToolTipText("Предыдущая страница");
        MyButtons search = new MyButtons("search.png");
        search.setToolTipText("Поиск");
        toolBar.add(search);
        toolBar.add(back);
        toolBar.add(forward);
        add(this.toolBar, BorderLayout.NORTH);

        Border border = BorderFactory.createEtchedBorder();

        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(1, 2));
        add(panel, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane();
        this.textPane = new JTextPane();
        scrollPane.getViewport().add(this.textPane);
        panel.add(scrollPane);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 3));
        p.setBorder(border);
        p.add(new JPanel());
        p.add(new JButton("Ok"));
        p.add(new JPanel());
        add(p, BorderLayout.SOUTH);

        forward.addActionListener(e -> {
            this.flag = true;
            index = (index + 1) % (workWithFile.getBook().size());
            setContent();
        });
        back.addActionListener(e -> {
            this.flag = true;
            index = (index == 0) ? (workWithFile.getBook().size() - 1) : (index - 1);
            setContent();
        });

        search.addActionListener(actionEvent -> {
//            int s = 0;
//            String searchWord = JOptionPane.showInputDialog(null, "",
//                    "Search...", JOptionPane.QUESTION_MESSAGE);
//            int index = textPane.getText().indexOf(searchWord);
//            while (!textPane.getText().isEmpty()) {
//                index = textPane.getText().indexOf(searchWord, index + searchWord.length());
//                if (index > 0){
//                    textPane.select(index, index + searchWord.length());
//                    textPane.requestFocus();
//                    s++;
//                } else {
//                    break;
//                }
//            }
//            System.out.println(s);
            String listForSearch = textPane.getText();
            SearchFX searchFX = new SearchFX(workWithFile, listForSearch, textPane);
//            workWithFile.searchToFile(listForSearch, searchFX.getTextField().getText());
        });


        setContent();
        setVisible(true);

    }

    private void setContent() {
//        try {
        textPane.setText(workWithFile.getBook().get(index).toString());

//            textPane.setPage(lists[index]);
//        } catch (IOException e) {
//            textPane.setText(lists[index]);
////            JOptionPane.showMessageDialog(null, "Страница не найдена", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
//        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        index = Integer.parseInt(((JMenuItem) e.getSource()).getActionCommand());
        setContent();
    }


//        // Cоздание многострочных полей
//        JTextArea area1 = new JTextArea(workWithFile.getBook().get(index).toString(), 45, 60);
//        // Шрифт и табуляция
//        area1.setFont(new Font("Dialog", Font.PLAIN, 14));
//        area1.setTabSize(10);
//        area1.setLineWrap(true);
//        area1.setWrapStyleWord(true);

    // Добавим поля в окно
////        this.textPane = new JPanel();
//        JPanel panel = new JPanel();
//        this.textPane = new JTextPane();
////        this.textPane.add(area1);
////        setContentPane(textPane1);
//        JScrollPane js = new JScrollPane();
////        js.setPreferredSize(new Dimension());
//        js.getViewport().add(this.textPane);
//        panel.add(js);
//        add(js, new GridBagConstraints(0, 0, 0, 1, 1, 1,
//                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
//                new Insets(1, 1, 1, 1), 0, 0));

    // Выводим окно на экран

//        JButton save = new JButton("Сохранить");
//        add(save);
//        save.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                workWithFile.save();
//                dispose();
//            }
//        });

//        JButton delete = new JButton("Удалить");
//        add(delete);
//        delete.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                workWithFile.myDeleteFile();
//                dispose();
//            }
//        });

//        JButton search = new JButton("Поиск по документу");
//        add(search);
//        search.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                workWithFile.searchToFile();
//            }
//        });

//        JButton forward = new JButton("Следующая страница");
//        add(forward);
//        forward.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        JButton back = new JButton("Предыдущая страница");


}
