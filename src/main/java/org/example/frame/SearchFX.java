package org.example.frame;

import org.example.text_new.WorkWithFile;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class SearchFX extends OpenFileFX implements ActionListener {
    private JTextField textField;
    private JLabel label;
    private int index;
    private int lengthIndexes;
    private JTextPane textPane;


    public JTextField getTextField() {
        return textField;
    }

    class MyButtons extends JButton {
        MyButtons(String name) {
            super(new ImageIcon("icon" + File.separator + name));
            setFocusPainted(false);
        }
    }

    public SearchFX(WorkWithFile workWithFile, String list, JTextPane textPane) {
        super("Поиск...");
        this.indexes = new ArrayList<>();
        index = 0;
        this.textPane = textPane;
        this.lengthIndexes = 0;

        setBounds(380, 55, 400, 60);
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
//        panel.add(jLabel);
        panel.add(textField);

        JLabel label = new JLabel((index) + "/" + lengthIndexes);
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

//        forward.addActionListener(e -> {
//            index = (index + 1) % (this.indexes.size());
//            textPane.select(index, index + textField.getText().length());
//            textPane.requestFocus();
//        });
//
//        back.addActionListener(e -> {
//            index = (index == 0) ? (this.indexes.size() - 1) : (index - 1);
//            textPane.select(index, index + textField.getText().length());
//            textPane.requestFocus();
//        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                search();
            }
        });

        forward.addActionListener(e -> {
            index = (index + 1) % (lengthIndexes);
            label.setText((index + 1) + "/" + lengthIndexes);
            setContent();
//            textPane.select(textPane.getText().charAt(indexes.get(index)), (textPane.getText().charAt(index)) + textField.getText().length());
//            textPane.requestFocus();
        });

        back.addActionListener(e -> {
            index = (index == 0) ? (lengthIndexes - 1) : (index - 1);
            label.setText((index + 1) + "/" + lengthIndexes);
            setContent();
//            textPane.select(textPane.getText().charAt(indexes.get(index)), (textPane.getText().charAt(index)) + textField.getText().length());
//            textPane.requestFocus();
        });

//        search.addActionListener(actionEvent -> {
//            workWithFile.searchToFile(list, textField.getText());
//        });

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

    private void setContent() {
//        textPane.setText(String.valueOf(indexes.get(index)));
        int v = indexes.get(index);
        textPane.select(v, v + textField.getText().length());
        textPane.requestFocus();
    }

    private void search() {
        if (!this.flag) {
            this.indexes.clear();
        }
        int index = textPane.getText().indexOf(textField.getText());
        this.indexes.add(index);
        while (!textPane.getText().isEmpty()) {
            index = textPane.getText().indexOf(textField.getText(), index + textField.getText().length());
            if (index > 0) {
                this.indexes.add(index);
//                        textPane.select(index, index + textField.getText().length());
//                        textPane.requestFocus();
//                        cnt++;
            } else {
                break;
            }
        }
        setContent();
        lengthIndexes = this.indexes.size();
//                indexes.clear();
        label.setText((index + 2) + "/" + lengthIndexes);

//                    index = textPane.getText().indexOf(textField.getText());
//                while (!textPane.getText().isEmpty()) {
//                    index = textPane.getText().indexOf(textField.getText(), index + textField.getText().length());
//                    if (index > 0) {
//                        textPane.select(index, index + textField.getText().length());
//                        textPane.requestFocus();
////                        cnt++;
//                    } else {
//                        break;
//                    }
//                }
        this.flag = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        index = Integer.parseInt(((JMenuItem) e.getSource()).getActionCommand());
    }
}
