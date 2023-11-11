package org.example.frame;

import org.example.textDocument.MyFile;
import org.example.text_new.WorkWithFile;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.io.File;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileManagerFX1 extends JFrame {
    private WorkWithFile workWithFile;
    private JPanel panel;
    private JTextPane textPane;
    private JMenu content, program;
    private JMenuItem[] commands;

    public FileManagerFX1(String pathDir) {
        super("Окно работы с файлом");

        try {
            this.workWithFile = new WorkWithFile(pathDir, "q");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        setBounds(250, 100, 800, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Border border = BorderFactory.createEtchedBorder();

        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(1, 1));
        add(panel, BorderLayout.CENTER);

        //создание дерева папок
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(pathDir);
        File folder = new File(pathDir);
        WorkWithFile workWithFile1 = null;
        for (int i = 0; i < folder.listFiles().length; i++){
            try {
                workWithFile1 = new WorkWithFile(pathDir, folder.listFiles()[i].getName());
                workWithFile1.getMyFile().setSizeFile(String.format("%.2f", (float) folder.listFiles()[i].length() / 1000));

                workWithFile.setMyFiles(workWithFile1.getMyFile());
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            top.add(new DefaultMutableTreeNode(workWithFile.getMyFiles().get(i).toString()));
        }

//        for (File file : folder.listFiles()) {
//            top.add(new DefaultMutableTreeNode(file.getName()));
//            System.out.println(workWithFile.getMyFile().toString());
//
//        }
        JTree tree = new JTree(top);
        JScrollPane scrollPane = new JScrollPane(tree);
        panel.add(scrollPane);
        //
//        String[] strings = new String[5];
//        Object[][] myFiles = new String[5][];
//        JTable table = new JTable(myFiles, strings);
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
                    try {
                        workWithFile = new WorkWithFile(pathDir, nameFile);
                        File file = new File(pathDir + File.separator + nameFile);
                        workWithFile.getMyFile().setSizeFile(String.format("%.2f", (float) file.length() / 1000));
                        if (workWithFile.myCreatedNewFile()) {
                            workWithFile.setMyFiles(workWithFile.getMyFile());
                            top.add(new DefaultMutableTreeNode(workWithFile.getMyFile().toString()));
                            tree.updateUI();

//                            OpenFileFX openFileFX = new OpenFileFX(workWithFile, nameFile);
//                            System.out.println("===");
//                            CreatedFileFX createdFileFX = new CreatedFileFX(workWithFile, pathDir, nameFile);
                        }
                    } catch (UnknownHostException ex) {
                        throw new RuntimeException(ex);
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
                try {
                    workWithFile = new WorkWithFile(pathDir, nameFile);
//                    workWithFile.openList();
                    workWithFile.readFile(pathDir, nameFile);
                    OpenFileFX openFileFX = new OpenFileFX(workWithFile, nameFile);

                } catch (UnknownHostException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        p.add(new JPanel());
        setVisible(true);

    }
}
