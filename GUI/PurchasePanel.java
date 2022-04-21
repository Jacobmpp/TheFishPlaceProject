
package GUI;

import backend.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class PurchasePanel extends Panel {
    JLabeledTextInput waters[] = {
            new JLabeledTextInput("Filter Fresh: "),
            new JLabeledTextInput("Reverse Osmosis: "),
            new JLabeledTextInput("Instant Ocean: "),
            new JLabeledTextInput("Brackish: "),
            new JLabeledTextInput("Red Sea: ")
    };
    JButton buy = new JButton("Record Purchase");
    JButton redeem = new JButton("Redeem");
    JLabel error = new JLabel(" ");

    public PurchasePanel() {
        super();
        setLayout(new GridBagLayout());
        setBorder(new LineBorder(Color.RED));
        initializePanel();
    }

    private void initializePanel() {
        buy.addActionListener(a -> {
            try {
                CIO.currentCustomer.applyPurchase(new Purchase(encodeTextFields()));
                clearText();
                error.setText(" ");
                infoPanel.updateInfo();
                CIO.saveToFile(CIO.DEFAULT_FILE);
            } catch (NullPointerException e) {
                error.setText("Please select a customer in the search area");
            } catch (NumberFormatException e) {
                error.setText("Wrong number format, try again");
                clearText();
            }
        });
        redeem.addActionListener(a -> {
            try {
                for (int i = 0; i < waters.length; i++) {
                    CIO.currentCustomer.redeem(i, Double.parseDouble(waters[i].getText()));
                }
                clearText();
                error.setText(" ");
                infoPanel.updateInfo();
                CIO.saveToFile(CIO.DEFAULT_FILE);
            } catch (NumberFormatException e) {
                error.setText("Wrong number format, try again");
                clearText();
            } catch (IllegalArgumentException e) {
                error.setText("Not enough water to redeem that amount");
            } catch (NullPointerException e) {
                error.setText("Please select a customer in the search area");
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
        for (int i = 0; i < waters.length; i++) {
            add(waters[i], c);
            c.gridy++;
        }
        c.fill = GridBagConstraints.CENTER;
        c.anchor = GridBagConstraints.CENTER;
        error.setForeground(Color.RED);
        add(error, c);
        c.fill = GridBagConstraints.EAST;
        c.anchor = GridBagConstraints.CENTER;
        c.gridy++;
        c.gridx = 1;
        c.gridwidth = 1;
        add(buy, c);
        c.gridx++;
        add(redeem, c);
    }

    private String encodeTextFields() {
        String out = "";
        for (int i = 0; i < waters.length; i++) {
            out += waters[i].getText().trim() + CIO.FILE_DELIMETERS[0];
        }
        return out.substring(0, out.length() - 1);
    }

    private void clearText() {
        for (int i = 0; i < waters.length; i++) {
            waters[i].clearText();
        }
    }
}