package customer;

import java.io.*;
import java.util.*;

import panels.CustomerPanel;

public class CIO {
    public static final String FILE_DELIMETER=";";
    public static final String DEFAULT_FILE="customer\\customers.dat";

    public static LinkedHashMap<String, Customer> customers = new LinkedHashMap<>();

    //LOAD/SAVE Methods
    public static void loadFile(String fileName) { //loads the customer data in "fileName" into the customers map.
        Scanner in;
        try {
            File f = new File(fileName);
            in = new Scanner(f);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        while(in.hasNextLine()) {
            Customer c = new Customer(in.nextLine().trim());
            addCustomer(c);
        }

        in.close();
    }
    public static void saveToFile(String fileName) { //saves the customer data in the customers map to "fileName"
        PrintStream out;
        try {
            File f = new File(fileName);
            out = new PrintStream(f);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        for(Customer c: CIO.customers.values()) {
            out.println(c);
        }
        out.close();
    }

    public static void addCustomer(Customer c) {
        String key = c.name+" / "+c.phoneNumber;
        customers.put(key, c);
    }
    public static void addCustomer(String s) {
        Customer c = new Customer(s);
        addCustomer(c);
    }

    
}
