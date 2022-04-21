
package GUI;

import backend.*;

import java.awt.*;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class SearchPanel extends Panel {
    JLabeledTextInput searchBar = new JLabeledTextInput("Search: ", 15);

    TreeMap<String, SearchedCustomerPanel> boxes = new TreeMap<String, SearchedCustomerPanel>();

    SearchPanel searchPanel = this;

    JLabel logo = new JLabel(new ImageIcon("GUI/logo.png"));

    public SearchPanel() {
        super();
        setLayout(new GridBagLayout());
        setBorder(new LineBorder(Color.BLUE));
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
                clearBoxes();
                if (t.keySet().size() < 14 && !searchBar.text.getText().equals("")) {
                    GridBagConstraints c = new GridBagConstraints();
                    c.fill = GridBagConstraints.HORIZONTAL;
                    c.anchor = GridBagConstraints.NORTHWEST;
                    c.gridheight = 1;
                    c.gridwidth = 1;
                    c.weightx = 0.5;
                    c.weighty = 0.5;
                    c.gridx = 0;
                    c.gridy = 0;
                    for (String k : t.keySet()) {
                        boxes.get(k).setVisible(true);
                    }
                }
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NORTH;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        add(logo, c);
        c.gridx++;
        add(searchBar, c);
        c.gridx = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        for (SearchedCustomerPanel s : boxes.values()) {
            c.gridy++;
            s.setVisible(false);
            add(s, c);
        }
    }

    public void clearBoxes() {
        for (SearchedCustomerPanel s : boxes.values()) {
            s.setVisible(false);
        }
    }
}