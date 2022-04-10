
import panels.*;

import javax.swing.*;

import backend.*;

import java.awt.*;

public class TFPmain {
    public static void main(String[] args) {
        System.out.println("====The Fish Place====");

        CIO.loadFile(CIO.DEFAULT_FILE);
        for (String key : CIO.customers.keySet()) {
            System.out.println(key);
        }
        CIO.saveToFile(CIO.DEFAULT_FILE);

        JFrame fullProgram = new JFrame("TFP: Customer Credit Tracker");
        fullProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fullProgram.setSize(1000, 700);

        addComponentsToPane(fullProgram.getContentPane());

        fullProgram.setVisible(true);
    }

    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        SearchPanel searchPanel = new SearchPanel();
        CustomerPanel cPanel = new CustomerPanel();
        PurchasePanel purchasePanel = new PurchasePanel();
        InfoPanel infoPanel = new InfoPanel();

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 3;
        pane.add(searchPanel.panel, c);
        c.gridx = 2;
        pane.add(cPanel.panel, c);
        c.gridx = 1;
        c.gridheight = 2;
        pane.add(purchasePanel.panel, c);
        c.gridy = 2;
        c.weighty = 0.5;
        c.gridheight = 1;
        pane.add(infoPanel.panel, c);
    }
}
