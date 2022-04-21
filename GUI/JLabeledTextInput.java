package GUI;

import javax.swing.*;
import java.awt.*;

public class JLabeledTextInput extends JPanel {
    public JLabel label = new JLabel();
    public JTextField text = new JTextField("", 15);

    public JLabeledTextInput(String label_, int textBoxWidth) {
        super();
        label.setText(label_);
        GridBagConstraints c = new GridBagConstraints();
        text.setMaximumSize(new Dimension(Integer.MAX_VALUE, text.getHeight()));
        c.fill = GridBagConstraints.WEST;
        c.anchor = GridBagConstraints.WEST;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.99;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        add(label, c);
        c.weightx = 0.01;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.EAST;
        c.gridwidth = textBoxWidth;
        add(text, c);
    }

    public JLabeledTextInput(String label_) {
        this(label_, 2);
    }

    public String getText() {
        if (text.getText().equals(""))
            return "0.0";
        return text.getText();
    }

    public void clearText() {
        text.setText("");
    }
}
