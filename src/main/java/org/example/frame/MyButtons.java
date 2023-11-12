package org.example.frame;

import javax.swing.*;
import java.io.File;

public class MyButtons extends JButton {
    public MyButtons(String name) {
        super(new ImageIcon("icon" + File.separator + name));
        setFocusPainted(false);
    }

}

