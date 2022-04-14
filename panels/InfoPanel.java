
package panels;

import backend.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class InfoPanel extends Panel {
    final int STRING_END = 18;
    JLabel name[] = { new JLabel("Name: "), new JLabel("") };
    JLabel phoneNumber[] = { new JLabel("Phone Number: "), new JLabel("") };
    JLabel waters[][] = {
            { new JLabel("Filter Fresh: "), new JLabel("") },
            { new JLabel("Reverse Osmosis: "), new JLabel("") },
            { new JLabel("Instant Ocean: "), new JLabel("") },
            { new JLabel("Brackish: "), new JLabel("") },
            { new JLabel("Red Sea: "), new JLabel("") }
    };
    JLabel lastDate[] = { new JLabel("Last Transaction: "), new JLabel("") };

    public InfoPanel() {
        super();
        panel.setBorder(new LineBorder(Color.BLUE));
        initializePanel();
    }

    public void updateInfo(Customer c) {
        name[1].setText(c.name);
        phoneNumber[1].setText(c.phoneNumber);
        for (int i = 0; i < waters.length; i++) {
            waters[i][1].setText(c.water[i] + "");
        }

        lastDate[0].setVisible(c.hasLastBought);
        if (c.hasLastBought) {
            lastDate[0].setText(c.lastBought.toString());
        }
    }

    private void initializePanel() {
        panel.setVisible(true);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.3;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(name[0], c);
        c.gridy = 1;
        panel.add(phoneNumber[0], c);
        c.gridy++;
        panel.add(new JLabel(""), c);
        for (int i = 0; i < waters.length; i++) {
            c.gridy++;
            panel.add(waters[i][0], c);
        }
        c.gridy++;
        panel.add(new JLabel(""), c);
        c.gridy++;
        panel.add(lastDate[0], c);

        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.6;
        c.weighty = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        panel.add(name[1], c);
        c.gridy = 1;
        panel.add(phoneNumber[1], c);
        c.gridy++;
        panel.add(new JLabel(""), c);
        for (int i = 0; i < waters.length; i++) {
            c.gridy++;
            panel.add(waters[i][1], c);
        }
        c.gridy++;
        panel.add(new JLabel(""), c);
        c.gridy++;
        panel.add(lastDate[1], c);
    }
}