package com.as.main;

import javax.swing.*;
import java.awt.*;

public abstract class BaseForm extends JFrame {
    public BaseForm(String title, int width, int height) throws HeadlessException {
        super(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
