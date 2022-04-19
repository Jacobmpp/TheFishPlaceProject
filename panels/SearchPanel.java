
package panels;

import backend.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class SearchPanel extends Panel {
    JTextField searchBar = new JTextField("", 15);

    SearchedCustomerPanel[] boxes = null;
    public SearchPanel() {
        super();
        setLayout(new GridBagLayout());
        setBorder(new LineBorder(Color.GREEN));
    }

    public void clearBoxes() {
        for (SearchedCustomerPanel s : boxes) {
            remove(s);
        }
    }
}