package org.example.frame;

import org.example.textDocument.MyFile;
import org.example.text_new.WorkWithFile;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.UnknownHostException;

public class FileManagerFX1 extends JFrame {
    private WorkWithFile workWithFile;
    private JPanel panel;
    private JTextPane textPane;
    private JMenu content, program;
    private JMenuItem[] commands;

    public FileManagerFX1(String pathDir) {
        super("Окно работы с файлом");

        this.workWithFile = new WorkWithFile(pathDir);
        setBounds(250, 100, 800, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JToolBar toolBar = new JToolBar("Фильтр");
        MyButtons size = new MyButtons("size.png");
        size.setToolTipText("Фильтр по размеру");
        MyButtons author = new MyButtons("author.png");
        author.setToolTipText("Фильтр по автору");
        MyButtons date = new MyButtons("date.png");
        date.setToolTipText("Фильтр по дате");
        toolBar.add(size);
        toolBar.add(author);
        toolBar.add(date);
        add(toolBar, BorderLayout.NORTH);

        Border border = BorderFactory.createEtchedBorder();

        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(1, 1));
        add(panel, BorderLayout.CENTER);

        //создание дерева папок
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(pathDir);
        File folder = new File(pathDir);
        for (int i = 0; i < folder.listFiles().length; i++) {
            MyFile tmpMyFile = new MyFile(pathDir, folder.listFiles()[i].getName());
            //добавляем элемент в массив MyFiles
            workWithFile.setMyFiles(tmpMyFile);
            workWithFile.readFile(pathDir, folder.listFiles()[i].getName());
            //у добавленного элемента инициализируем поле size
            workWithFile.getMyFiles().get(i).setSizeFile(String.format("%.2f", (float) folder.listFiles()[i].length() / 1000));
            //добавляем эл-т в tree
            top.add(new DefaultMutableTreeNode(workWithFile.getMyFiles().get(i).toString()));
        }

        JTree tree = new JTree(top);
        JScrollPane scrollPane = new JScrollPane(tree);
        panel.add(scrollPane);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 3));
        p.setBorder(border);
        p.add(new JPanel());
        add(p, BorderLayout.SOUTH);

//        tree.addTreeSelectionListener(new TreeSelectionListener() {
//            @Override
//            public void valueChanged(TreeSelectionEvent tse) {
////                try {
////                    workWithFile = new WorkWithFile(pathDir, "q");
//                File file = new File(pathDir + File.separator + "q.txt");
//                workWithFile.getMyFile().setSizeFile(String.format("%.2f", (float) file.length() / 1000));
////                } catch (UnknownHostException e) {
////                    throw new RuntimeException(e);
////                }
//                workWithFile.readFile(pathDir, "q");
//                System.out.println(workWithFile.getMyFile().toString());
//                OpenFileFX openFileFX = new OpenFileFX(workWithFile, tree.getName());
//
//                //                    workWithFile.openList();
//            }
//        });

        JButton createdFile = new JButton("Создать");
        p.add(createdFile);
        createdFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameFile = JOptionPane.showInputDialog(null,
                        "Введите имя файла", "Создание файла TXT", JOptionPane.QUESTION_MESSAGE);
                if (nameFile != null) {
                    File file = new File(pathDir + File.separator + nameFile);
                    workWithFile.getMyFile().setSizeFile(String.format("%.2f", (float) file.length() / 1000));
                    if (workWithFile.myCreatedNewFile()) {
                        workWithFile.setMyFiles(workWithFile.getMyFile());
                        top.add(new DefaultMutableTreeNode(workWithFile.getMyFile().toString()));
                        tree.updateUI();

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
                String tmpNameFile = workWithFile.getItem(nameFile + ".txt").getNameFile();
                if (tmpNameFile != null) {
//                    workWithFile.readFile(pathDir, nameFile + ".txt");
                    OpenFileFX openFileFX = new OpenFileFX(workWithFile, nameFile);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Файла с таким именем не существует",
                            "Сообщение", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        p.add(new JPanel());
        setVisible(true);

    }
}
