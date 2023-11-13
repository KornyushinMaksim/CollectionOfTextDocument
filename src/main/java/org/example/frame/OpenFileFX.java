package org.example.frame;

import org.example.textDocument.MyFile;
import org.example.text_new.WorkWithFile;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenFileFX extends JFrame implements ActionListener {

    private MyFile tmpMyFile;
    private JToolBar toolBar;
    private JPanel panel;
    private JTextPane textPane;
    private int index;
    private String nameFile;
    protected boolean flag;

    public OpenFileFX(String str) {
        super(str);
    }

    public OpenFileFX(WorkWithFile workWithFile, String nameFile) {
        super(nameFile);
        this.tmpMyFile = workWithFile.getItem(nameFile + ".txt");
        this.flag = true;
        this.index = 0;
        this.nameFile = nameFile;

        setBounds(300, 150, 800, 700);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BorderLayout());

        this.toolBar = new JToolBar("Панель меню");
        MyButtons forward = new MyButtons("forward1.png");
        forward.setToolTipText("Следующая страница");
        MyButtons back = new MyButtons("back1.png");
        back.setToolTipText("Предыдущая страница");
        MyButtons search = new MyButtons("search.png");
        search.setToolTipText("Поиск");
        MyButtons replace = new MyButtons("replace1.png");
        replace.setToolTipText("Замена");
        toolBar.add(search);
        toolBar.add(back);
        toolBar.add(forward);
        toolBar.add(replace);
        add(this.toolBar, BorderLayout.NORTH);

        Border border = BorderFactory.createEtchedBorder();

        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(1, 2));
        add(panel, BorderLayout.CENTER);

        JButton ok = new JButton("Ok");
        JButton save = new JButton("Сохранить");

        JScrollPane scrollPane = new JScrollPane();
        this.textPane = new JTextPane();
        scrollPane.getViewport().add(this.textPane);
        panel.add(scrollPane);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 3));
        p.setBorder(border);
        p.add(new JPanel());
        p.add(save);
        p.add(ok);
        p.add(new JPanel());
        add(p, BorderLayout.SOUTH);

        forward.addActionListener(e -> {
            this.flag = true;
            index = (index + 1) % (tmpMyFile.getBook().size());
            setContent();
        });
        back.addActionListener(e -> {
            this.flag = true;
            index = (index == 0) ? (tmpMyFile.getBook().size() - 1) : (index - 1);
            setContent();
        });

        search.addActionListener(actionEvent -> {
            String listForSearch = textPane.getText();
            SearchFX searchFX = new SearchFX(workWithFile, listForSearch, textPane, tmpMyFile);
        });

        replace.addActionListener(e -> {
            workWithFile.replace(nameFile);
            setContent();
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workWithFile.save(textPane.getText(), nameFile);
                dispose();
            }
        });
        setContent();
        setVisible(true);
    }

    private void setContent() {
        if (this.tmpMyFile.getBook().size() != 0) {
            textPane.setText(this.tmpMyFile.getBook().get(index).toString());
        } else {
            textPane.getText();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        index = Integer.parseInt(((JMenuItem) e.getSource()).getActionCommand());
        setContent();
    }
}
