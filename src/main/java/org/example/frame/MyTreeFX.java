package org.example.frame;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

public class MyTreeFX extends JTree {
    private DefaultMutableTreeNode top;

    public MyTreeFX(String pathDir) {
        this.top = new DefaultMutableTreeNode(pathDir);
        File folder = new File(pathDir);
        for (File file : folder.listFiles()) {
            top.add(new DefaultMutableTreeNode(file.getName()));
        }
    }

    public void addItem(String nameFile){
        top.add(new DefaultMutableTreeNode(nameFile));
    }
}
