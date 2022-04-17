package panels;

import javax.swing.*;
import backend.*;
import java.util.TreeMap;

abstract class Panel extends JPanel {
    protected TreeMap<String, Customer> customers = new TreeMap<>();

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

    public void addReferences(SearchPanel s, CustomerPanel c, PurchasePanel p, InfoPanel i,
            TreeMap<String, Customer> customers_) {
        addReferences(s, c, p, i);
        customers = customers_;
    }

}
