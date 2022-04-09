
import panels.*;

public class TFPmain {
    public static void main(String[] args) {
        System.out.printf("Hello, World!");
        CList customers = new CList("customers.txt");
        customers.saveCustomers("customers.txt");
    }
}
