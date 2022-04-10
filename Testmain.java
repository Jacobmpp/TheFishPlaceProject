/* This main class is available to be used by the developers to make sure their code works.
 * This way they don't have to change the TFPmain.java class.
 * Anything in here does not matter when commited or merged.
 */

import customer.*;

public class Testmain {
    public static void main(String[] args) {
        System.out.println("====The Fish Place====");

        CIO.loadFile(CIO.DEFAULT_FILE);

        CIO.printCustomers(CIO.customers);

        CIO.saveToFile(CIO.DEFAULT_FILE);

    }
}
