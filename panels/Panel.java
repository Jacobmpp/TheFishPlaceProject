
package panels;

import javax.swing.*;
import java.awt.*;

abstract class Panel {
    public JPanel panel;

    public Panel() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
    }
}