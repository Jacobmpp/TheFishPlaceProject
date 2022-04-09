package customer;

import java.io.*;
import java.util.*;

public class CIO {
    public static final String FILE_DELIMETER=";";
    public static final String DEFAULT_FILE="customer\\customers.dat";

    public static TreeMap<String, Customer> customers = new TreeMap<>();

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

    //ADD/REMOVE
    public static void addCustomer(Customer c) {
        String key = generateKey(c);
        customers.put(key, c);
    }
    public static void addCustomer(String s) {
        Customer c = new Customer(s);
        addCustomer(c);
    }
    public static void removeCustomer(Customer c) {
        String key = generateKey(c);
        customers.remove(key);
    }
    public static void removeCustomer(String key) {    //assumes s is in the format given by generateKey()
        customers.remove(key);
    }

    public static String generateKey(Customer c) {
        return c.name + " / " + c.phoneNumber;
    }

    public static TreeMap<String, Customer> search(String s) {  //returns a map of customers that contains the given string.
        TreeMap<String, Customer> results = new TreeMap<>();
        for (String key : CIO.customers.keySet()) {
            if(key.toLowerCase().contains(s.toLowerCase()))
                results.put(key, customers.get(key));
        }
        return results;
    }

    public static void printCustomers(TreeMap<String, Customer> t) {   //prints a list of customers to the terminal. Used for debugging.
        for (String key : t.keySet()) {
            System.out.printf(key);
        }
    }
}
