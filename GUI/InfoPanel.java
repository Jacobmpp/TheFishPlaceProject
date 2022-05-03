
package GUI;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import backend.CIO;

public class InfoPanel extends Panel {
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
        initializePanel();
    }

    public void updateInfo() {
        name[1].setText(CIO.currentCustomer.name);
        phoneNumber[1].setText(CIO.currentCustomer.phoneNumber);
        for (int i = 0; i < waters.length; i++) {
            waters[i][1].setText(CIO.currentCustomer.water[i][0]
                    + " (" + CIO.currentCustomer.amountRedeemable(i) + ")");
        }

        lastDate[0].setVisible(CIO.currentCustomer.hasLastBought);
        if (CIO.currentCustomer.hasLastBought) {
            lastDate[1].setText(CIO.currentCustomer.lastBought.toString());
        }
    }

    private void initializePanel() {
        setVisible(true);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.EAST;
        c.anchor = GridBagConstraints.EAST;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.4;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        add(name[0], c);
        c.gridy = 1;
        add(phoneNumber[0], c);
        c.gridy++;
        add(new JLabel(""), c);
        for (int i = 0; i < waters.length; i++) {
            c.gridy++;
            add(waters[i][0], c);
        }
        c.gridy++;
        add(new JLabel(""), c);
        c.gridy++;
        add(lastDate[0], c);

        c.anchor = GridBagConstraints.WEST;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        add(name[1], c);
        c.gridy = 1;
        add(phoneNumber[1], c);
        c.gridy++;
        add(new JLabel(""), c);
        for (int i = 0; i < waters.length; i++) {
            c.gridy++;
            add(waters[i][1], c);
        }
        c.gridy++;
        add(new JLabel(""), c);
        c.gridy++;
        add(lastDate[1], c);
    }
}