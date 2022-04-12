package backend;

import java.util.Date;

public class Customer {
    public static final int WATER_BRANDS=5;
    public String name;
    public String phoneNumber;
    public double water[] = new double[WATER_BRANDS];

    public boolean hasLastBought=false;
    public Date lastBought;
    public double lastWater[] = new double[WATER_BRANDS];
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
        
        name = parts[0].trim();
        phoneNumber = parts[1].trim();
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
    
    //ADD/SUBTRACT
    public void addWater(int index, double gal) {
        water[index]+=gal;
    }
    public void removeWater(int index, double gal) {  //edit later on whether the customer doesn't have enough.
        water[index]-=gal;
    }
    public void applyPurchase(Purchase p) {
        hasLastBought=true;
        lastBought=p.purchaseDate;
        lastWater=p.water;
        
        for(int i=0;i<water.length;i++) {
            addWater(i, p.water[i]);
        }
    }

    //OVERRIDES/MISC
    public boolean hasEnoughWater(int index, double gal) {  //has enough water of the index to subtract gal.
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