
package panels;

import backend.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class SearchPanel extends Panel {
    JLabeledTextInput searchBar = new JLabeledTextInput("Search: ", 15);

    TreeMap<String, SearchedCustomerPanel> boxes = new TreeMap<String, SearchedCustomerPanel>();

    SearchPanel searchPanel = this;

    public SearchPanel() {
        super();
        setLayout(new GridBagLayout());
        setBorder(new LineBorder(Color.GREEN));
        initializePanel();
    }

    private void initializePanel() {
        for (Entry<String, Customer> e : CIO.customers.entrySet()) {
            boxes.put(e.getKey(), new SearchedCustomerPanel(e.getValue(), searchPanel));
        }
        searchBar.text.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                search();
            }

            public void removeUpdate(DocumentEvent e) {
                search();
            }

            public void insertUpdate(DocumentEvent e) {
                search();
            }

            public void search() {
                TreeMap<String, Customer> t = CIO.search(searchBar.text.getText());
                if (t.keySet().size() < 20) {
                    for (String k : t.keySet()) {
                        clearBoxes();
                        boxes.get(k).setVisible(true);
                    }
                }
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        add(searchBar, c);
        for (SearchedCustomerPanel s : boxes.values()) {
            c.gridy++;
            add(s, c);
        }
        clearBoxes();
    }

    public void clearBoxes() {
        for (SearchedCustomerPanel s : boxes.values()) {
            s.setVisible(false);
        }
    }
}