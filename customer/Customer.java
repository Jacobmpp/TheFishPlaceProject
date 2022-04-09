package customer;

public class Customer {
    public String name;
    public String phoneNumber;
    public double water[] = new double[5];
    //FilterFresh, ReverseOsmosis, InstantOcean, Brackish, RedSea

    public Customer(String name_, String phoneNumber_, double filterFresh_, double reverseOsmosis_, double instantOcean_,
            double brackish_, double redSea_) {
        name = name_;
        phoneNumber = phoneNumber_;
        water[0] = filterFresh_;
        water[1] = reverseOsmosis_;
        water[2] = instantOcean_;
        water[3] = brackish_;
        water[4] = redSea_;
    }

    public Customer(String fromString) {
        String[] parts = fromString.split(CIO.FILE_DELIMETER);
        name = parts[0];
        phoneNumber = parts[1];
        for(int i=0;i<water.length;i++) {
            water[i]=Double.parseDouble(parts[i+2]);
        }
    }
    
    @Override
    public String toString() {
        String delim = CIO.FILE_DELIMETER;
        String out = name + delim + phoneNumber;
        for(int i=0;i<water.length;i++) {
           out+=delim+water[i];
        }
        return out;
    }
}