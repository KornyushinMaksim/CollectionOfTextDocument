package org.example.frame;

import org.example.textDocument.MyFile;
import org.example.text_new.WorkWithFile;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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


    public JTextField getTextField() {
        return textField;
    }

//    class MyButtons extends JButton {
//        MyButtons(String name) {
//            super(new ImageIcon("icon" + File.separator + name));
//            setFocusPainted(false);
//        }
//    }

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
//        panel.add(jLabel);
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
                myClear();
//                int indexWord = textPane.getText().indexOf(textField.getText());
//                indexes.add(indexWord);
//                setContent();
                search(/*indexWord*/);
            }
        });

        forward.addActionListener(e -> {
            indexTap = (indexTap + 1) % (lengthIndexes);
            label.setText((indexTap + 1) + "/" + lengthIndexes);
            setContent();
//            textPane.select(textPane.getText().charAt(indexes.get(index)), (textPane.getText().charAt(index)) + textField.getText().length());
//            textPane.requestFocus();
        });

            back.addActionListener(e -> {
                        indexTap = (indexTap == 0) ? (lengthIndexes - 1) : (indexTap - 1);
                        label.setText((indexTap + 1) + "/" + lengthIndexes);
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
        try {
            int v = indexes.get(indexTap);
            textPane.select(v, v + textField.getText().length());
            textPane.requestFocus();
        } catch (IndexOutOfBoundsException e){
            this.indexes.clear();

        }

    }

    private void search(/*int indexWord*/) {
//        if (!this.flag) {
//            this.indexes.clear();
//        }
//        int index = textPane.getText().indexOf(textField.getText());
//        this.indexes.add(index);
//
        int indexWord = 0;
            indexWord = textPane.getText().indexOf(textField.getText());
            indexes.add(indexWord);
            while (!textPane.getText().isEmpty()) {
                indexWord = textPane.getText().indexOf(textField.getText(), indexWord + textField.getText().length());
                if (indexWord > 0) {
                    this.indexes.add(indexWord);
//                        textPane.select(index, index + textField.getText().length());
//                        textPane.requestFocus();
//                        cnt++;
                } else {
                    break;
                }
            }
            lengthIndexes = this.indexes.size();
//                indexes.clear();
            label.setText((indexWord + 2) + "/" + lengthIndexes);
            setContent();


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
