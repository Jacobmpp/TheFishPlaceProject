package panels;

import javax.swing.*;
import java.awt.*;

abstract class Panel extends JPanel {

    protected SearchPanel searchPanel;
    protected CustomerPanel customerPanel;
    protected PurchasePanel purchasePanel;
    protected InfoPanel infoPanel;

    public void addReferences(SearchPanel s, CustomerPanel c, PurchasePanel p, InfoPanel i) {
        searchPanel = s;
        customerPanel = c;
        purchasePanel = p;
        infoPanel = i;
    }

    public static void notification(String message) {
        JFrame notification = new JFrame();
        notification.setSize(8 * message.length(), 100);
        notification.setLocation(1350 - 8 * message.length(), 638);
        notification.setLayout(new GridBagLayout());
        JLabel label = new JLabel(message);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        notification.add(label, c);
        notification.setVisible(true);
    }
}
