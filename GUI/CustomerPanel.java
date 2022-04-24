
package GUI;

import backend.*;

import java.awt.*;

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
        setBorder(new LineBorder(Color.BLUE));
        initializePanel();
    }

    private void initializePanel() {
        submit.addActionListener(a -> { // this currently assumes the data input it correct
            try {
                Customer c = new Customer(encodeTextFields());
                CIO.addCustomer(c);
                CIO.saveToFile(CIO.DEFAULT_FILE);
                clearText();
                error.setText(" ");
                searchPanel.boxes.put(CIO.generateKey(c), new SearchedCustomerPanel(c, searchPanel));
                GridBagConstraints g = new GridBagConstraints();
                g.fill = GridBagConstraints.BOTH;
                g.anchor = GridBagConstraints.CENTER;
                g.gridheight = 1;
                g.gridwidth = 2;
                g.weightx = 0.5;
                g.weighty = 0.5;
                g.gridx = 0;
                g.gridy = searchPanel.boxes.size() + 1;
                searchPanel.boxes.get(CIO.generateKey(c)).setVisible(false);
                searchPanel.add(searchPanel.boxes.get(CIO.generateKey(c)), g);
            } catch (NumberFormatException e) {
                error.setText("Failed to add customer, check formating of numbers");
            } catch (IllegalArgumentException e) {
                error.setText("Failed to add customer, " + e.getMessage());
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

    private String encodeTextFields() throws IllegalArgumentException {
        if (name.text.getText().trim().length() == 0)
            throw new IllegalArgumentException();
        String out = name.text.getText().trim() + CIO.FILE_DELIMETERS[0];
        out += phoneNumber.text.getText().trim() + CIO.FILE_DELIMETERS[0];
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