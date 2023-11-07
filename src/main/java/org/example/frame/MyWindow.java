package org.example.frame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class MyWindow extends JFrame {

    public MyWindow(String str) {
        super(str);
        setBounds(250, 50, 800, 700);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BorderLayout());
    }


}
