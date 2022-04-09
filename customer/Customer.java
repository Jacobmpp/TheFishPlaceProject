package customer;

public class Customer {
    public String name;
    public String phoneNumber;
    public double filterFresh;
    public double reverseOsmosis;
    public double instantOcean;
    public double brackish;
    public double redSea;

    public Customer(String name_, String phoneNumber_, double filterFresh_, double reverseOsmosis_, double instantOcean_,
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
        String[] parts = fromString.split(CIO.FILE_DELIMETER);
        name = parts[0];
        phoneNumber = parts[1];
        try {
            filterFresh = Double.parseDouble(parts[2]);
            reverseOsmosis = Double.parseDouble(parts[3]);
            instantOcean = Double.parseDouble(parts[4]);
            brackish = Double.parseDouble(parts[5]);
            redSea = Double.parseDouble(parts[6]);
        } catch (NumberFormatException e) {
        }
    }
    
    @Override
    public String toString() {
        String delim = CIO.FILE_DELIMETER;
        String out = name + delim + 
                     phoneNumber + delim + 
                     filterFresh + delim + 
                     reverseOsmosis + delim + 
                     instantOcean + delim + 
                     brackish + delim + 
                     redSea;
        return out;
    }
    
    public String phoneNumberAsString() {
        String pNString = phoneNumber+"";
        String out = "(" + pNString.substring(1, 4) + ") " + pNString.substring(4, 7) + "-" + pNString.substring(7);
        return out;
    }
}