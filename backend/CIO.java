package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class CIO {
    public static final String[] FILE_DELIMETERS = { ";", "#", "%" };
    public static final String DEFAULT_FILE = "backend\\customers.dat";

    public static TreeMap<String, Customer> customers;
    public static Customer currentCustomer;

    // LOAD/SAVE Methods
    public static void loadFile(String fileName) { // loads the customer data in "fileName" into the customers map.
        customers = new TreeMap<>(); // resets the map.
        Scanner in;
        try {
            File f = new File(fileName);
            in = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        while (in.hasNextLine()) {
            Customer c = new Customer(in.nextLine().trim());
            addCustomer(c);
        }

        in.close();
        saveToFile(DEFAULT_FILE);
    }

    public static void saveToFile(String fileName) { // saves the customer data in the customers map to "fileName"
        PrintStream out;
        try {
            File f = new File(fileName);
            out = new PrintStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        for (Customer c : CIO.customers.values()) {
            out.println(c);
        }
        out.close();
    }

    public static String generateKey(Customer c) {
        return c.name + " / " + c.phoneNumber;
    }

    // ADD/REMOVE
    public static void addCustomer(Customer c) {
        for (Customer k : CIO.customers.values()) {
            if (k.name.equals(c.name))
                throw new IllegalArgumentException("Customer already exists");
        }

        // If customer has not made a purchase in over a year, don't add the customer
        if (!c.hasLastBought || Math.abs(new Date().getTime() - c.lastBought.getTime()) < 31557600000l)
            customers.put(generateKey(c), c);
    }

    public static void addCustomer(String s) {
        addCustomer(new Customer(s));
    }

    public static void removeCustomer(Customer c) {
        customers.remove(generateKey(c));
    }

    public static void removeCustomer(String key) { // assumes s is in the format given by generateKey()
        customers.remove(key);
    }

    // SEARCH/GET INDEX
    public static TreeMap<String, Customer> search(String s) { // returns a map of customers that contains the given
                                                               // string.
        TreeMap<String, Customer> results = new TreeMap<>();
        for (String key : CIO.customers.keySet()) {
            if (key.toLowerCase().contains(s.toLowerCase()))
                results.put(key, customers.get(key));
        }
        return results;
    }

    public static Customer search(String s, int index) throws IndexOutOfBoundsException { // searches the customers map
                                                                                          // and returns the first
                                                                                          // customer.
        TreeMap<String, Customer> t = search(s);
        if (t.size() < index)
            throw new IndexOutOfBoundsException();
        return t.values().toArray(new Customer[0])[index];
    }

    public static Customer getCustomer(int index) throws IndexOutOfBoundsException {
        return customers.values().toArray(new Customer[0])[index];
    }

    // DEBUG
    public static void printCustomers(TreeMap<String, Customer> t) { // prints a list of customers to the terminal. Used
                                                                     // for debugging.
        int i = 0;
        for (Entry<String, Customer> e : t.entrySet()) {
            System.out.printf("(%2d)", i++);
            printCustomer(e.getValue());
        }
    }

    public static void printCustomer(Customer c) {
        if (c == null) {
            System.err.println("Customer pointer is null");
            return;
        }

        System.out.printf("%40s | ", generateKey(c)); // regenerates key. not perfect but works for now.
        printWater(c.water);

        if (!c.hasLastBought) {
            System.out.println();
            return;
        }

        System.out.printf(" |<>|%30s | ", c.lastBought.toString());
        printWater(c.lastWater);
        System.out.println();
    }

    public static void printWater(double[][] w) {
        for (int i = 0; i < w.length; i++) {
            System.out.printf("%6.2f + %6.2f", w[i][0], w[i][1]);
        }
    }

    public static void printWater(double[] w) {
        for (int i = 0; i < w.length; i++) {
            System.out.printf("%6.2f", w[i]);
        }
    }
}
