package panels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class CList {
    ArrayList<Customer> customers = new ArrayList<Customer>();

    public void loadCustomers(String filename) {
        File f = new File(filename);
        try {
            Scanner r = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found: " + filename);
        }
    }
}