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
}
