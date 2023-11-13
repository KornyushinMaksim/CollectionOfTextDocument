package org.example.frame;

import org.example.textDocument.MyFile;
import org.example.text_new.WorkWithFile;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchFX extends OpenFileFX {
    private JTextField textField;
    protected ArrayList<Integer> indexes;
    private JLabel label;
    private int indexTap;
    private int lengthIndexes;
    private JTextPane textPane;
    private MyFile myFile;
    private WorkWithFile workWithFile;

    public SearchFX(WorkWithFile workWithFile, String list, JTextPane textPane, MyFile myFile) {
        super("Поиск...");
        this.workWithFile = workWithFile;
        this.myFile = myFile;
        this.indexes = new ArrayList<>();
        indexTap = 0;
        this.textPane = textPane;
        this.lengthIndexes = 0;

        setBounds(380, 55, 600, 80);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BorderLayout());
        SearchFX.this.textPane.getText();

        this.label = new JLabel("Введите слово");
        this.textField = new JTextField();
        textField.setLayout(new GridLayout(1, 1));
        textField.setSize(new Dimension(100, 50));

        Border border = BorderFactory.createEtchedBorder();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        add(panel, BorderLayout.CENTER);
        panel.add(textField);

        JLabel label = new JLabel((indexTap) + "/" + lengthIndexes);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        JToolBar toolBar = new JToolBar();
        toolBar.setLayout(new GridLayout(1, 4));
        MyButtons forward = new MyButtons("forward.png");
        forward.setToolTipText("Следующий");
        MyButtons back = new MyButtons("back.png");
        back.setToolTipText("Предыдущий");
        MyButtons search = new MyButtons("searchMini.jpeg");
        search.setToolTipText("Поиск");
        toolBar.add(search);
        toolBar.add(back);
        toolBar.add(label, BorderLayout.CENTER);
        toolBar.add(forward);
        add(toolBar, BorderLayout.EAST);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                myClear();
                search();
            }
        });

        forward.addActionListener(e -> {
            indexTap = (indexTap + 1) % (lengthIndexes);
            label.setText((indexTap + 1) + "/" + lengthIndexes);
            setContent();
        });

        back.addActionListener(e -> {
            indexTap = (indexTap == 0) ? (lengthIndexes - 1) : (indexTap - 1);
            label.setText((indexTap + 1) + "/" + lengthIndexes);
            setContent();
        });

        setVisible(true);
    }

    private void setContent() {
        try {
            int v = indexes.get(indexTap);
            textPane.select(v, v + textField.getText().length());
            textPane.requestFocus();
        } catch (IndexOutOfBoundsException e) {
            this.indexes.clear();

        }
    }

    private void search() {
        int indexWord = 0;
        indexWord = textPane.getText().indexOf(textField.getText());
        indexes.add(indexWord);
        while (!textPane.getText().isEmpty()) {
            indexWord = textPane.getText().indexOf(textField.getText(), indexWord + textField.getText().length());
            if (indexWord > 0) {
                this.indexes.add(indexWord);
            } else {
                break;
            }
        }
        lengthIndexes = this.indexes.size();
        label.setText((indexWord + 2) + "/" + lengthIndexes);
        setContent();
        this.flag = false;
    }

    private void myClear() {
        if (!flag || this.indexes == null) {
            indexes.clear();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        indexTap = Integer.parseInt(((JMenuItem) e.getSource()).getActionCommand());
    }
}
