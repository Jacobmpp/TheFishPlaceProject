/* This main class is available to be used by the developers to make sure their code works.
 * This way they don't have to change the TFPmain.java class.
 * Anything in here does not matter when commited or merged.
 */

import backend.*;

public class Testmain {
    public static void main(String[] args) {
        System.out.println("====The Fish Place====");

        CIO.loadFile(CIO.DEFAULT_FILE);

        
        Purchase p = new Purchase(0,10.0,0,20.25,0);    //example of applying a purchase.
        CIO.getCustomer(11).applyPurchase(p);
        CIO.search("pavan", 0).redeem(3,1);
        CIO.printCustomers(CIO.customers);

        CIO.saveToFile(CIO.DEFAULT_FILE);

    }
}
