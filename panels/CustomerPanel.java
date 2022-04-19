
package panels;

import backend.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class CustomerPanel extends Panel {

    JLabeledTextInput name = new JLabeledTextInput("Name: ");
    JLabeledTextInput phoneNumber = new JLabeledTextInput("phoneNumber: ");
    JLabeledTextInput waters[] = {
            new JLabeledTextInput("Filter Fresh: "),
            new JLabeledTextInput("Reverse Osmosis: "),
            new JLabeledTextInput("Instant Ocean: "),
            new JLabeledTextInput("Brackish: "),
            new JLabeledTextInput("Red Sea: ")
    };
    JLabel error = new JLabel(" ");
    JButton submit = new JButton("Submit");

    public CustomerPanel() {
        super();
        setLayout(new GridBagLayout());
        setBorder(new LineBorder(Color.YELLOW));
        initializePanel();
    }

    private void initializePanel() {
        submit.addActionListener(a -> { // this currently assumes the data input it correct
            try {
                CIO.addCustomer(new Customer(encodeTextFields()));
                CIO.saveToFile(CIO.DEFAULT_FILE);
                clearText();
                error.setText(" ");
            } catch (Exception e) {
                error.setText("Failed to add customer, check formating of numbers");
            }
        });
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.EAST;
        c.anchor = GridBagConstraints.EAST;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        add(name, c);
        c.gridy++;
        add(phoneNumber, c);
        c.gridy++;
        c.fill = GridBagConstraints.CENTER;
        c.anchor = GridBagConstraints.CENTER;
        error.setForeground(Color.RED);
        add(error, c);
        c.fill = GridBagConstraints.EAST;
        c.anchor = GridBagConstraints.EAST;
        c.gridy++;
        for (int i = 0; i < waters.length; i++) {
            add(waters[i], c);
            c.gridy++;
        }
        c.gridx = 2;
        c.gridwidth = 1;
        add(submit, c);
    }

    private String encodeTextFields() {
        String out = name.getText().trim() + CIO.FILE_DELIMETERS[0];
        out += phoneNumber.getText().trim() + CIO.FILE_DELIMETERS[0];
        for (int i = 0; i < waters.length; i++) {
            out += waters[i].getText().trim() + CIO.FILE_DELIMETERS[0];
        }
        return out.substring(0, out.length() - 1) + CIO.FILE_DELIMETERS[1]; // replace the last ; with a #
    }

    private void clearText() {
        name.clearText();
        phoneNumber.clearText();
        for (int i = 0; i < waters.length; i++) {
            waters[i].clearText();
        }
    }
}