package org.example.frame;

import org.example.text_new.WorkWithFile;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SearchFX extends JFrame {
    private JTextField textField;
    int cnt;


    public JTextField getTextField() {
        return textField;
    }

    class MyButtons extends JButton {
        MyButtons(String name) {
            super(new ImageIcon("icon" + File.separator + name));
            setFocusPainted(false);
        }
    }
    public SearchFX (WorkWithFile workWithFile, String list, JTextPane textPane){
        super("Поиск...");
        cnt = 0;

        setBounds(380, 55, 400, 60);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel jLabel = new JLabel("Введите слово");
        this.textField = new JTextField();
        textField.setSize(new Dimension(100, 50));

        Border border = BorderFactory.createEtchedBorder();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        add(panel, BorderLayout.CENTER);
//        panel.add(jLabel);
        panel.add(textField);

        JLabel label = new JLabel(String.valueOf(cnt));

        JToolBar toolBar = new JToolBar();
        MyButtons forward = new MyButtons("forward.png");
        forward.setToolTipText("Следующий");
        MyButtons back = new MyButtons("back.png");
        back.setToolTipText("Предыдущий");
        MyButtons search = new MyButtons("searchMini.jpeg");
        search.setToolTipText("Поиск");
        toolBar.add(search);
        toolBar.add(back);
        toolBar.add(label);
        toolBar.add(forward);
        add(toolBar, BorderLayout.EAST);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                String searchWord = JOptionPane.showInputDialog(null, "",
//                        "Search...", JOptionPane.QUESTION_MESSAGE);
                int index = textPane.getText().indexOf(textField.getText());
                while (!textPane.getText().isEmpty()) {
                    index = textPane.getText().indexOf(textField.getText(), index + textField.getText().length());
                    if (index > 0){
                        textPane.select(index, index + textField.getText().length());
                        textPane.requestFocus();
                        cnt++;
                    } else {
                        break;
                    }
                }
                System.out.println(cnt);

            }
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
}
