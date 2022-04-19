package panels;

import javax.swing.*;
import java.awt.*;

import backend.*;

abstract class SearchedCustomerPanel extends JPanel {

    JLabel key;
    JButton select = new JButton("Select");
    Customer customer;
    SearchPanel searchPanel;


    public void seachedCustomerPanel(Customer c, SearchPanel s) {
        customer = c;
        key = new JLabel(CIO.generateKey(c));
        searchPanel = s;
        initializePanel();
    }

    private void initializePanel(){
        select.addActionListener(a -> {
            CIO.currentCustomer = customer;
            searchPanel.searchBar.setText("");
            searchPanel.clearBoxes();
        });
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        setVisible(true);
        c.fill = GridBagConstraints.WEST;
        c.anchor = GridBagConstraints.WEST;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        add(key,c);
        c.gridx = 1;
        c.fill = GridBagConstraints.EAST;
        c.anchor = GridBagConstraints.EAST;
        add(select, c);
    }
}
