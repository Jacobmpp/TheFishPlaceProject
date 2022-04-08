package panels;

public class Customer {
    public String name;
    public long phoneNumber;
    public double filterFresh;
    public double reverseOsmosis;
    public double instantOcean;
    public double brackish;
    public double redSea;

    public Customer(String name_, int phoneNumber_, double filterFresh_, double reverseOsmosis_, double instantOcean_,
            double brackish_, double redSea_) {
        name = name_;
        phoneNumber = phoneNumber_;
        filterFresh = filterFresh_;
        reverseOsmosis = reverseOsmosis_;
        instantOcean = instantOcean_;
        brackish = brackish_;
        redSea = redSea_;
    }

    public Customer(String fromString) {
        String[] parts = fromString.split("SPR8R");
        name = parts[0];
        try {
            phoneNumber = Long.parseLong(parts[1])%Long.parseLong("10000000000")+Long.parseLong("10000000000");
            filterFresh = Double.parseDouble(parts[2]);
            reverseOsmosis = Double.parseDouble(parts[3]);
            instantOcean = Double.parseDouble(parts[4]);
            brackish = Double.parseDouble(parts[5]);
            redSea = Double.parseDouble(parts[6]);
        } catch (NumberFormatException e) {
        }
    }
    
    public String toString() {
        String out = name + "SPR8R" + phoneNumber + "SPR8R" + filterFresh + "SPR8R" + reverseOsmosis + "SPR8R"
                + instantOcean + "SPR8R" + brackish + "SPR8R" + redSea;
        return out;
    }
    
    public String phoneNumberAsString() {
        String pNString = phoneNumber+"";
        String out = "(" + pNString.substring(1, 4) + ") " + pNString.substring(4, 7) + "-" + pNString.substring(7);
    }
}