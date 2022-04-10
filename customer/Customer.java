package customer;

public class Customer {
    private String name;
    private String phoneNumber;
    private double water[] = new double[5];
    //FilterFresh, ReverseOsmosis, InstantOcean, Brackish, RedSea

    //CONSTRUCTORS
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
    
    //SETTERS/GETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setWater(int index, double value) {
        water[index]=value;
    }

    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public double getWater(int index) {
        return water[index];
    }
    public double[] getWater() {
        return water;
    }

    //ADD/SUBTRACT
    public void addWater(int index, double value) {
        water[index]+=value;
    }
    public void removeWater(int index, double value) {  //edit later on whether the customer doesn't have enough.
        water[index]-=value;
    }

    //OVERRIDES
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