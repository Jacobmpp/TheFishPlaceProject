package customer;

import java.util.Date;

public class Customer {
    public final int WATER_BRANDS=5;
    private String name;
    private String phoneNumber;
    private double water[] = new double[WATER_BRANDS];

    public boolean hasLastBought=false;
    private Date lastBought;
    private double lastWater[] = new double[WATER_BRANDS];
    //FilterFresh, ReverseOsmosis, InstantOcean, Brackish, RedSea

    //CONSTRUCTORS
    public Customer(String fromString) {
        String[] parts = fromString.split(CIO.FILE_DELIMETERS[1]);
        importData(parts[0]);
        if(parts.length==1) //if there is no data on last purchase.
            return;
        importLastData(parts[1]);
    }
    private void importData(String data) {
        String[] parts = data.split(CIO.FILE_DELIMETERS[0]);
        name = parts[0];
        phoneNumber = parts[1];
        for(int i=0;i<water.length;i++) {
            water[i]=Double.parseDouble(parts[i+2]);
        }
    }
    private void importLastData(String data) {
        hasLastBought=true;
        String[] parts = data.split(CIO.FILE_DELIMETERS[0]);

        lastBought = new Date(parts[0]);    //depricated. change to DateFormat.parse(String) at some point.
        for(int i=0;i<water.length;i++) {
            lastWater[i]=Double.parseDouble(parts[i+1]);
        }
    }
    
    //SETTERS/GETTERS-OVERALL
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setWater(int index, double gal) {
        water[index]=gal;
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

    //SETTERS/GETTERS-LASTBOUGHT
    public void setLastBought(Date d) {
        lastBought=d;
    }
    public void setLastWater(int index, double gal) {
        lastWater[index]=gal;
    }

    public Date getLastBought() {
        return lastBought;
    }
    public double getLastWater(int index) {
        return lastWater[index];
    }
    public double[] getLastWater() {
        return lastWater;
    }

    //ADD/SUBTRACT
    public void addWater(int index, double gal) {
        water[index]+=gal;
    }
    public void removeWater(int index, double gal) {  //edit later on whether the customer doesn't have enough.
        water[index]-=gal;
    }

    //OVERRIDES/MISC
    public boolean hasEnoughWater(int index, double gal) {
        if(water[index]>=gal)
            return true;
        return false;
    }

    @Override
    public String toString() {
        String delim = CIO.FILE_DELIMETERS[0];

        String out = name + delim + phoneNumber;
        for(int i=0;i<water.length;i++) {
           out+=delim+water[i];
        }

        out+=CIO.FILE_DELIMETERS[1];
        
        if(lastBought==null)    //if they dont have data for the last time they bought stuff.
            return out;
        out+=lastBought.toString();
        for(int i=0;i<water.length;i++) {
            out+=delim+lastWater[i];
         }

        return out;
    }
}