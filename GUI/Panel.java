package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;

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

    public Panel() {
        setLayout(new GridBagLayout());
        setBorder(new LineBorder(Color.BLUE));
    }
}
