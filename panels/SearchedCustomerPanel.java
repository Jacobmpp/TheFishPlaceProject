package panels;

import javax.swing.*;
import java.awt.*;

import backend.*;

public class SearchedCustomerPanel extends JPanel {

    JButton select;
    Customer customer;
    SearchPanel searchPanel;


    public SearchedCustomerPanel(Customer c, SearchPanel s) {
        super();
        customer = c;
        select = new JButton("Select: " + CIO.generateKey(c));
        searchPanel = s;
        initializePanel();
    }

    private void initializePanel(){
        select.addActionListener(a -> {
            CIO.currentCustomer = customer;
            searchPanel.infoPanel.updateInfo(); // So I don't have to import and store this stuff for one line of code
            searchPanel.searchBar.text.setText("");
            searchPanel.clearBoxes();
        });
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        setVisible(true);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        add(select, c);
    }
}
