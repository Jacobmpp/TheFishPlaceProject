
import customer.*;

public class TFPmain {
    public static void main(String[] args) {
        System.out.printf("====The Fish Place====\n");
        


        CIO.loadFile(CIO.DEFAULT_FILE);
        for(String key: CIO.customers.keySet()) {
            System.out.println(key);
        }
        CIO.saveToFile(CIO.DEFAULT_FILE);
    }
}
