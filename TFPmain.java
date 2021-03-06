
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import GUI.CustomerPanel;
import GUI.InfoPanel;
import GUI.PurchasePanel;
import GUI.SearchPanel;
import backend.CIO;

public class TFPmain {
    public static void main(String[] args) {
        CIO.loadFile(CIO.DEFAULT_FILE);
        CIO.saveToFile(CIO.DEFAULT_FILE);
        JFrame fullProgram = new JFrame("TFP: Water Credit Tracker");
        fullProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fullProgram.setSize(1050, 500);

        addComponentsToPane(fullProgram.getContentPane());

        fullProgram.setVisible(true);
    }

    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        SearchPanel searchPanel = new SearchPanel();
        CustomerPanel customerPanel = new CustomerPanel();
        PurchasePanel purchasePanel = new PurchasePanel();
        InfoPanel infoPanel = new InfoPanel();

        searchPanel.addReferences(searchPanel, customerPanel, purchasePanel, infoPanel);
        customerPanel.addReferences(searchPanel, customerPanel, purchasePanel, infoPanel);
        purchasePanel.addReferences(searchPanel, customerPanel, purchasePanel, infoPanel);
        infoPanel.addReferences(searchPanel, customerPanel, purchasePanel, infoPanel);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.01;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 3;
        pane.add(searchPanel, c);
        c.weightx = 0.5;
        c.gridx = 2;
        pane.add(customerPanel, c);
        c.gridx = 1;
        c.gridheight = 1;
        pane.add(infoPanel, c);
        c.gridy = 1;
        pane.add(purchasePanel, c);
    }
}
