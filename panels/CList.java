package panels;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class CList {
    ArrayList<Customer> customers = new ArrayList<Customer>();
    
    public CList(String filename) {
        loadCustomers(filename);
    }

    public void loadCustomers(String filename) {
        File f = new File(filename);
        try {
            Scanner r = new Scanner(f);
            while (r.hasNextLine()) {
                customers.add(new Customer(r.nextLine()));
            }
            r.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found: " + filename);
            System.out.println(e.getStackTrace());
        }
    }

    public void saveCustomers(String filename) {
        try{
            FileWriter w = new FileWriter(filename);
            for (Customer c : customers) {
                w.write(c.toString()+"\n");
            }
            ;
            w.close();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            System.out.println(e.getStackTrace());
        }

    }
}