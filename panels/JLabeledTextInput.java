package panels;

import javax.swing.*;
import java.awt.*;

public class JLabeledTextInput extends JPanel {
    public JLabel label = new JLabel();
    public JTextField text = new JTextField("", 20);

    public JLabeledTextInput(String label_, int textBoxWidth) {
        super();
        label.setText(label_);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.EAST;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        add(label, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = textBoxWidth;
        add(text, c);
    }

    public JLabeledTextInput(String label_) {
        this(label_, 2);
    }

    public String getText() {
        return text.getText();
    }

    public void clearText() {
        text.setText("");
    }
}
